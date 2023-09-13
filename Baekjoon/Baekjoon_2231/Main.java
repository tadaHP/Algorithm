package Baekjoon.Baekjoon_2231;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		calculate(n);

		System.out.println(answer);
	}

	private static void calculate(int n) {
		for (int i = 1; i < n; i++) {
			int d = disassemble(i);
			if (d == n) {
				answer = i;
				break;
			}
		}
	}

	private static int disassemble(int m) {
		String s = String.valueOf(m);
		int digits = 0;
		String[] split = s.split("");
		for (String string : split) {
			digits += Integer.parseInt(string);
		}
		return m + digits;
	}
}
