package Baekjoon.Baekjoon_1297;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] split = br.readLine().split(" ");
		int d = Integer.parseInt(split[0]);
		int h = Integer.parseInt(split[1]);
		int w = Integer.parseInt(split[2]);

		sb.append(solve(h, w, d, h)).append(" ").append(solve(h, w, d, w));
		System.out.println(sb);

	}

	public static int solve(int x, int y, int d, int target) {

		double v = (d * target) / Math.sqrt(x * x + y * y);

		return (int)v;
	}
}
