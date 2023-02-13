package Programmers.Programmers42842;

import java.util.Arrays;

public class Main {

    static final int brown1 = 10;
    static final int yellow1 = 2;
    // 4,3

    static final int brown2 = 8;
    static final int yellow2 = 1;
    //3,3

    static final int brown3 = 24;
    static final int yellow3 = 24;
    //8, 6


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(brown1, yellow1)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        boolean status = true;
        int H = 2;
        int W = 0;

        while (status) {
            //H값 증가
            H++;
            int tempBrown = brown - H * 2;

            //brown 탐색
            W = (tempBrown / 2) + 2;

            if ((H - 2) * (W - 2) == yellow) {
                status = false;
            }
        }

        answer = new int[]{W, H};


        return answer;
    }

}
