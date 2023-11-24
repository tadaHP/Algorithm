package Baekjoon.Baekjoon_25418;

import java.io.*;

public class Main {
	private static final int[] dp = new int[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int start = Integer.parseInt(split[0]);
		int target = Integer.parseInt(split[1]);

		for (int i = start; i < target + 1; i++) {
			dp[i] = 1000001;
		}
		dp[start] = 0;
		if (start + 1 < 1000001) {
			dp[start + 1] = 1;
		}
		if (start * 2 < 1000001) {
			dp[start * 2] = 1;
		}
		for (int i = start + 1; i < target; i++) {
			dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

			if (i * 2 < 1000001) {
				dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
			}
		}
		System.out.println(dp[target]);
	}
}
