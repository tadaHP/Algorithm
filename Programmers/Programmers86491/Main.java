package Programmers.Programmers86491;


public class Main {

    static final int[][] size1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};//answer = 4000

    static final int[][] size2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7},{5,15}};//answer = 120

    static final int[][] size3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};//answer = 133

    public static void main(String[] args) {
        System.out.println(solution(size3));
    }

    public static int solution(int[][] sizes) {
        int answer = 0;
        int max_Height = -1;
        int max_Width = -1;

        int[][] new_size = new int[sizes.length][2];


        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            if (a > b) {
                new_size[i] = new int[]{a, b};
            } else {
                new_size[i] = new int[]{b, a};
            }
        }

        for (int[] ints : new_size) {
            if (max_Width < ints[0]) {
                max_Width = ints[0];
            }
            if (max_Height < ints[1]) {
                max_Height = ints[1];
            }
        }

        answer = max_Width * max_Height;

        return answer;
    }
}
