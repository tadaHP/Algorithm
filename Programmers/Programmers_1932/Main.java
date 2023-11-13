package Programmers.Programmers_1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int[][] data;
    private static int size;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        data = new int[size][size + 1];
        for (int i = 1; i < size+1; i++) {
            String[] read = br.readLine().split(" ");
            for (int j = 0; j < i; j++) {
                data[i - 1][j + 1] = Integer.parseInt(read[j]);
            }
        }

        dp();

        System.out.println(getMaxAnswer());

    }

    private static void dp() {
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < i + 2; j++) {
                int beforeA = data[i - 1][j - 1];
                int beforeB = data[i - 1][j];

                if (beforeA > beforeB) {
                    data[i][j] += beforeA;
                } else {
                    data[i][j] += beforeB;
                }
            }
        }
    }

    private static int getMaxAnswer() {
        int max = 0;
        for (int i = 0; i < size + 1; i++) {
            max = Math.max(data[size -1][i], max);
        }
        return max;
    }

}
