package Programmers.Programmers42748;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static final int[] array1 = {1, 5, 2, 6, 3, 7, 4};
    static final int[][] command1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    public static void main(String[] args) {
        int[] answer = Solution(array1, command1);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    static int[] Solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] sortedArray = Arrays.stream(Arrays.copyOfRange(array, command[0] - 1, command[1])).sorted().toArray();

            answer[i] = sortedArray[command[2] - 1];
        }

        return answer;
    }
}
