package Baekjoon.Baekjoon_6064;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());
		for (int i = 0; i < size; i++) {
			String[] data = br.readLine().split(" ");

			sb.append(solve(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]),
				Integer.parseInt(data[3]))).append("\n");
		}

		System.out.println(sb);

	}

	private static int solve(int m, int n, int x, int y) {
		int lcm = lcm(m, n);

		while (x != y) {
			if (x < y) {
				x += m;
			} else {
				y += n;
			}
			if (x > lcm) {
				return -1;
			}
		}
		return x;
	}

	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}
