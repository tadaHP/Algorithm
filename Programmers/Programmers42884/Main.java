package Programmers.Programmers42884;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static int[][] routes1 = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
    // 2

    public static void main(String[] args) {


        int solution = solution(routes1);
        System.out.println("solution = " + solution);

    }

    /**
     * 1. 카메라는 맨 뒤에 설치한다.
     * 2. 출입시점이 나의 나가는 시점보다 작은지 확인
     */
    static int solution(int[][] routes) {
        int answer = 0;
        boolean[] isPass = new boolean[routes.length];

       Arrays.sort(routes,Comparator.comparingInt(o1 -> o1[1]));

        for (int i = 0; i < routes.length; i++) {
            if (isPass[i]) continue;

            int setCam = routes[i][1];
            for (int j = i; j < routes.length; j++) {
                if (routes[j][0] <= setCam) {
                    isPass[j] = true;
                }
            }
            answer++;
        }

        return answer;
    }

}
