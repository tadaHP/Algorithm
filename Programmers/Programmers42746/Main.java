package Programmers.Programmers42746;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static final int[] numbers1 = {6, 10, 2};
    static final int[] numbers2 = {3, 30, 34, 5, 9}; //9534330 -> 9,5,34
    static final int[] number3 = {0, 0, 0, 0};
    static final int[] number4 = {232, 23};
    static final int[] numbersTemp = {123, 12, 34};

    public static void main(String[] args) {
        System.out.println(solution(number3));
    }

    static String solution(int[] numbers) {
        String answer = "";
        String[] strNum = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String stringNum1 = o1 + o2;
                String stringNum2 = o2 + o1;

                int num1 = Integer.parseInt(stringNum1);
                int num2 = Integer.parseInt(stringNum2);

                return num2-num1;
            }

        });

        for (String s : strNum) {
            answer = answer + s;
        }
        if (answer.charAt(0)=='0') {
            answer = "0";
        }


        return answer;
    }
}