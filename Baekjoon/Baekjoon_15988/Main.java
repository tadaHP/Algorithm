package Baekjoon.Baekjoon_15988;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCaseSize = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCaseSize; i++) {
			int targetNumber = Integer.parseInt(br.readLine());
			int[] dp = new int[targetNumber + 1];
			dp[1] = 1;
			if (targetNumber >= 2) {
				dp[2] = 2;
			}
			if (targetNumber >= 3) {
				dp[3] = 4;
			}
			for (int j = 4; j < targetNumber + 1; j++) {
				dp[j] = (int)(((long)dp[j - 1] + (long)dp[j - 2] + (long)dp[j - 3]) % (long)1000000009);
			}
			sb.append(dp[targetNumber]).append("\n");
		}
		System.out.println(sb);
	}
}
