package Baekjoon.Baekjoon_9465;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testSize = Integer.parseInt(br.readLine());
        int[][] data = null;

        for (int i = 0; i < testSize; i++) {
            int size = Integer.parseInt(br.readLine());

            data = new int[2][size];

            String[] lineA = br.readLine().split(" ");
            String[] lineB = br.readLine().split(" ");

            for (int j = 0; j < size; j++) {
                data[0][j] = Integer.parseInt(lineA[j]);
            }
            for (int j = 0; j < size; j++) {
                data[1][j] = Integer.parseInt(lineB[j]);
            }
            sb.append(solve(size, data)).append("\n");
        }
        System.out.println(sb);
    }

    private static int solve(int size, int[][] data) {
        if (size < 2) {
            return Math.max(data[0][0], data[1][0]);
        }

        data[0][1] += data[1][0];
        data[1][1] += data[0][0];

        for (int i = 2; i < size; i++) {
            data[0][i] += Math.max(data[1][i - 1], data[1][i - 2]);

            data[1][i] += Math.max(data[0][i - 1], data[0][i - 2]);
        }

        return Math.max(data[0][size - 1], data[1][size - 1]);
    }

}
