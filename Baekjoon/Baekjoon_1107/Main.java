package Baekjoon.Baekjoon_1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int now = 100;
	private static boolean[] access;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		access = new boolean[] {true, true, true, true, true, true, true, true, true, true};

		int target = Integer.parseInt(br.readLine());
		int errorSize = Integer.parseInt(br.readLine());

		if (errorSize > 0) {
			String[] split = br.readLine().split(" ");

			for (int i = 0; i < errorSize; i++) {
				access[Integer.parseInt(split[i])] = false;
			}
		}

		int min = Math.abs(target - now);

		for (int i = 0; i < 1000000; i++) {
			int numberClicked = solve(i);
			if (numberClicked > 0) {
				int clickPlusMinus = Math.abs(target - i);
				min = Math.min(min, clickPlusMinus + numberClicked);
			}
		}

		System.out.println(min);

	}

	private static int solve(int n) {
		if (n == 0) {
			if (access[0]) {
				return 1;
			} else {
				return 0;
			}
		}

		int count = 0;

		while (n > 0) {
			if (!access[n % 10]) {
				return 0;
			}
			count++;
			n /= 10;
		}
		return count;
	}
}
