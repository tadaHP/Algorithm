package Baekjoon.Baekjoon_1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int houseCount = Integer.parseInt(br.readLine());
		int[][] data = new int[houseCount][3];
		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < houseCount; i++) {
			String[] splitData = br.readLine().split(" ");
			data[i][0] = Integer.parseInt(splitData[0]);
			data[i][1] = Integer.parseInt(splitData[1]);
			data[i][2] = Integer.parseInt(splitData[2]);
		}

		for (int i = 1; i < houseCount; i++) {
			data[i][0] += Math.min(data[i - 1][1], data[i - 1][2]);
			data[i][1] += Math.min(data[i - 1][0], data[i - 1][2]);
			data[i][2] += Math.min(data[i - 1][0], data[i - 1][1]);
		}

		for (int i = 0; i < 3; i++) {
			minValue = Math.min(data[houseCount - 1][i], minValue);
		}

		System.out.println(minValue);
	}
}
