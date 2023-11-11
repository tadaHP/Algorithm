package Programmers.Programmers_11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split = br.readLine().split(" ");
        int size = Integer.parseInt(split[0]);
        int answerCount = Integer.parseInt(split[1]);

        int[][] data = new int[size + 1][size + 1];
        for (int i = 1; i < size + 1; i++) {
            split = br.readLine().split(" ");
            for (int j = 1; j < size + 1; j++) {
                data[i][j] = Integer.parseInt(split[j - 1]);
            }
        }


        for (int i = 1; i < size + 1; i++) {
            int temp = data[i][1];
            for (int j = 2; j < size + 1; j++) {
                temp = temp + data[i][j];
                data[i][j] = temp;
            }
        }

        for (int i = 0; i < answerCount; i++) {
            int sum = 0;
            String[] replyData = br.readLine().split(" ");
            int startX = Integer.parseInt(replyData[0]);
            int startY = Integer.parseInt(replyData[1]);
            int endX = Integer.parseInt(replyData[2]);
            int endY = Integer.parseInt(replyData[3]);

            for (int j = startX; j <endX + 1; j++) {
                sum = sum + (data[j][endY] - data[j][startY - 1]);
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
