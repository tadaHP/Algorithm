package Baekjoon.Baekjoon_12865;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int itemCount = Integer.parseInt(split[0]);
		int weightLimit = Integer.parseInt(split[1]);

		int[] weight = new int[itemCount + 1];
		int[] value = new int[itemCount + 1];
		int[][] dp = new int[itemCount + 1][weightLimit + 1];

		for (int i = 1; i < itemCount + 1; i++) {
			split = br.readLine().split(" ");

			weight[i] = Integer.parseInt(split[0]);
			value[i] = Integer.parseInt(split[1]);
		}

		for (int i = 1; i < itemCount + 1; i++) {
			for (int j = 1; j < weightLimit + 1; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - weight[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight[i]]+value[i]);
				}
			}
		}

		System.out.println(dp[itemCount][weightLimit]);

	}
}
