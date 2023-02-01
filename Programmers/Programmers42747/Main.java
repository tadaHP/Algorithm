package Programmers.Programmers42747;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static final int[] citations1 = {3, 0, 6, 1, 5};//answer 3
    static final int[] citations2 = {9, 9, 9, 1}; //answer 4

    public static void main(String[] args) {
        solution(citations2);
    }

    static int solution(int[] citations) {
        Integer[] temp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Comparator.reverseOrder());

        int answer = 0;
        int size = citations.length;


        for (int i = 0; i < size; i++) {
            if (temp[answer] > answer) {
                answer++;
            }
        }

        System.out.println(answer);

        return answer;
    }


}
