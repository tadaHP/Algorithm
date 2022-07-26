package Programmers.Programmers_42584;

public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        int[] answer = solution(prices);

        for(int i : answer){
            System.out.println(i);
        }

    }
    
    public static int[] solution(int[] prices) {
        int pricesLength = prices.length;
        int[] answer = new int[pricesLength];

        for(int position = 0 ; position<pricesLength ; position++){
            for(int j = position+1 ; j < pricesLength ; j++){
                if(prices[position]> prices[j]){
                    answer[position] = j-position;
                    break;
                }

                if(j==pricesLength-1){
                    answer[position] = j-position;
                }
            }
        }
        
        return answer;
    }

}
