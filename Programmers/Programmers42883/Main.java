package Programmers.Programmers42883;

public class Main {

    static String number1 = "1924";
    static int k1 = 2;

    static String number2 = "1231234";
    static int k2 = 3;

    static String number3 = "4177252841";
    static int k3 = 4;

    public static void main(String[] args) {
        System.out.println(solution(number3, k3));
    }

    static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int startPoint = 0;
        int returnSize = number.length() - k;
        int endPoint = k;

        while (true) {
            if(answer.length() == number.length()-k) break;

            int biggestVal = -1;
            int biggestValPoint = -1;
            //최대값 찾기
            System.out.println("startPoint = " + startPoint);
            System.out.println("endPoint = " + endPoint);
            for (int i = startPoint; i <= endPoint; i++) {
                int tempVal = number.charAt(i) - '0';
                if (biggestVal < tempVal) {
                    biggestVal = tempVal;
                    biggestValPoint = i;
                }
            }
            answer.append(biggestVal);
            //다음 루틴 준비
            startPoint = biggestValPoint + 1;
            returnSize--;
            endPoint = number.length() - returnSize;
        }

        return answer.toString();
    }


}
