package Baekjoon.Baekjoon_11047;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int target = Integer.parseInt(split[1]);
		int[] coins = new int[n];

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coins);
		int count = 0;
		int selectCoinPosition = n - 1;

		while (target != 0) {
			int selectCoin = coins[selectCoinPosition];
			if (selectCoin <= target) {
				while (target >= selectCoin) {
					count++;
					target -= selectCoin;
				}
			}
			selectCoinPosition--;
		}

		System.out.println(count);
	}
}
