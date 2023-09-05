package Baekjoon.Baekjoon_11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		System.out.println(factorial(n) / (factorial(k) * factorial(n - k)));
	}

	private static long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return factorial(n - 1) * n;
	}
}
