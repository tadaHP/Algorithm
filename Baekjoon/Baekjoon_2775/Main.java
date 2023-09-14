package Baekjoon.Baekjoon_2775;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++) {
			int k = Integer.parseInt(br.readLine()); //k층
			int n = Integer.parseInt(br.readLine()); //n호
			sb.append(solve(k, n)).append("\n");
		}

		System.out.println(sb);

	}

	private static int solve(int k, int n) {
		if (k == 0) { //0층이면 i
			return n;
		} else if (n == 1) { //
			return 1;
		}

		int a = solve(k, n - 1);
		int b = solve(k - 1, n);

		return a + b;
	}
}
