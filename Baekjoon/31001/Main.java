import java.util.*;
import java.io.*;
import java.util.stream.*;

class Main{
    private final static HashMap<String, Main.Company> companyHashMap = new HashMap<String, Company>();
    private final static HashMap<Integer, List<Main.Company>> groupHashMap = new HashMap<Integer, List<Company>>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] initData = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int companyLength = initData[0];
        int money = initData[1];
        int menuLength = initData[2];
        List<String> orderList = new ArrayList<>();

        for(int i = 0; i < companyLength; i++){
            String[] companyData = reader.readLine().split(" ");
            int companyGroup = Integer.parseInt(companyData[0]);
            String companyName = companyData[1];
            int initValue = Integer.parseInt(companyData[2]);
            Main.Company company = new Main.Company(companyName, initValue);

            companyHashMap.put(companyName, company);
            List<Main.Company> groupList = groupHashMap.getOrDefault(companyGroup, new ArrayList<>());
            groupList.add(company);
            groupHashMap.put(companyGroup, groupList);
        }

        for (int i = 0; i < menuLength; i++) {
            orderList.add(reader.readLine());
        }

        String answer = calculate(orderList, money);

        writer.write(answer);
        writer.flush();


        reader.close();
        writer.close();
    }

    // 회사를 HashMap에 넣는데
    // 회사 개인이 변동하거나 - 회사 자체를 수정하면 됨
    // new HashMap<String, Company>(); => 회사별 HashMap
    // 회사 그룹이 변동
    // new HashMap<String, List<Company>>(); => 회사 그룹별 HashMap, 

    public static class Company{
        String name;
        long value;
        long count;

        public Company(String name, long value) {
            this.name = name;
            this.value = value;
            this.count = 0;
        }

        public void buy(long count) {
            this.count += count;
        }
        public void sell(long count) {
            this.count -= count;
        }
        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public void resetValue(){
            this.value = 0;
        }

        public String getName() {
            return name;
        }
        public long getCount() {
            return count;
        }
        public void addValue(long value) {
            this.value += value;
        }
    }


    // private final static HashMap<String, Main.Company> companyHashMap = new HashMap<String, Company>();
    // private final static HashMap<String, List<Main.Company>> groupHashMap = new HashMap<String, List<Company>>();

    private static String calculate(List<String> orderList, int money){
        long budget = money;
        StringBuilder sb = new StringBuilder();
        for (String order : orderList) {
            String[] orderData = order.split(" ");
            int command = Integer.parseInt(orderData[0]);

            if(command == 6 ){ // 6 - 현재 가지고 있는 현금 출력
                sb.append(budget).append("\n");
                continue;
            }
            if(command == 7){ //7 - 현재 가지고 있는 주식을 현재값으로 판 총합 + 현재 가지고 있는 현금 출력
                long stockValue = companyHashMap.keySet().stream()
                    .mapToLong(com -> (long)companyHashMap.get(com).getCount() * (long)companyHashMap.get(com).getValue())
                    .sum();
                stockValue += budget;
                sb.append(stockValue).append("\n");
                continue;
            }
            String companyName = orderData[1];
            int count = Integer.parseInt(orderData[2]);

            switch (command) {
                case 1: // 1 A B  - A 회사 주식 B주를 사는데 현금으로 못하면 pass
                    // A 회사 가져와서
                    Main.Company case1TargetCompany = companyHashMap.get(companyName);
                    // count * A 회사 주식 가격을 해서 총 가격을 보고
                    // budget보다 작거나 같으면 빼고 정리
                    long price = (long)count * case1TargetCompany.getValue();
                    if(price <= budget){
                        case1TargetCompany.buy(count);
                        budget -= price;
                    }
                    break;
                case 2: // 2 A B - A 회사 주식 B주를 파는데 0주 가지고있음 아무것도 없고, B가 더 크면 A회사 가지고 있는만큼만 팔기
                    // A 회사 가져와서
                    // 본인이 가진게 B보다 크면 - B만큼팔고 수량 budget조절
                    // 본인이 가진게 B보다 작으면 - 전부 팔고 수량 budget조절
                    Main.Company case2TargetCompany = companyHashMap.get(companyName);
                    if(case2TargetCompany.getCount() >= count){
                        case2TargetCompany.sell(count);
                        budget += count * case2TargetCompany.getValue();
                    }else{
                        long sellingCount = case2TargetCompany.getCount();
                        case2TargetCompany.sell(sellingCount);
                        budget += sellingCount * case2TargetCompany.getValue();
                    }
                    break;
                case 3: // 3 A C - A 회사 주식이 C 만큼 변동, C 가 양수면 오른거 음수면 떨어진거
                    Main.Company case3TargetCompany = companyHashMap.get(companyName);
                    case3TargetCompany.addValue(count);
                    if(case3TargetCompany.getValue() < 0){
                        case3TargetCompany.resetValue();; // 0보다 작으면 0으로 초기화
                    }
                    break;
                case 4: // 4 D C - D 그룹이 속하는 회사들의 주가가 C 만큼 변동
                    Integer case4CompanyGroup = Integer.parseInt(companyName);
                    List<Main.Company> case4TargetCompanyGroupList = groupHashMap.get(case4CompanyGroup);
                    for (Main.Company company : case4TargetCompanyGroupList) {
                        company.addValue(count);
                        if(company.getValue() < 0){
                            company.resetValue(); // 0보다 작으면 0으로 초기화
                        }
                    }
                    break;
                case 5: // 5 D E - D 그룹이 속하는 회사들의 주가가 E% 만큼 변동
                    Integer case5CompanyGroup = Integer.parseInt(companyName);
                    List<Main.Company> case5TargetCompanyGroupList = groupHashMap.get(case5CompanyGroup);
                    for (Main.Company company : case5TargetCompanyGroupList) {
                        long currentValue = company.getValue();
                        int newValue = (int)(currentValue * (100 + count) / 100.0);
                        newValue = (newValue / 10) * 10; // 일의 자리 버림
                        company.setValue(Math.max(0, newValue));
                    }
                    break;
            }

        }
        return sb.toString();
    }
    
}