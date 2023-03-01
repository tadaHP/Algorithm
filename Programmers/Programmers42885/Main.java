package Programmers.Programmers42885;

import java.util.Arrays;

public class Main {

    static int[] people1 = {70, 50, 80, 50};
    static int limit1 = 100;

    static int[] people2 = {70, 80, 50};
    static int limit2 = 100;

    static int[] people3 = {61, 40, 70};
    static int limit3 = 100;

    public static void main(String[] args) {
        int solution = solution(people3, limit3);
        System.out.println(solution);
    }

//1. 두명, 2. 무게제한

    static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;
        int max = people.length - 1;

        while (min < max) {
            int sum = people[min] + people[max];
            if (sum <= limit) {
                min++;
            }
            max--;
            answer++;
        }

        if (min == max) {
            answer++;
        }


        return answer;
    }

}
