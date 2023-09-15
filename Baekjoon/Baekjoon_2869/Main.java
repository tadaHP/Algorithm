package Baekjoon.Baekjoon_2869;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		int v = Integer.parseInt(split[2]);

		System.out.println(solve(a, b, v));

	}

	private static int solve(int a, int b, int v) {
		int target = v - a;
		int day = target / (a - b);
		if (target % (b - a) > 0) {
			day++;
		}

		return day + 1;
	}
}
