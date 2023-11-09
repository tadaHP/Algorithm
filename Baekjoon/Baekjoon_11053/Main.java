package Baekjoon.Baekjoon_11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int size = Integer.parseInt(br.readLine());
		int[] data = new int[size];
		int[] dp = new int[size];

		String[] split = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			data[i] = Integer.parseInt(split[i]);
		}

		for (int i = 0; i < size; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (data[j] < data[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		for (int i = 0; i < size; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}

}
