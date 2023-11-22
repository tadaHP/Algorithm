package Baekjoon.Baekjoon_1297;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int d = Integer.parseInt(split[0]);
		int h = Integer.parseInt(split[1]);
		int w = Integer.parseInt(split[2]);

		System.out.println(solve(h, w, d));
	}

	public static String solve(double h, double w, double d) {
		double sqrt = Math.sqrt((d * d) / ((h * h) + (w * w)));
		return (int)(sqrt * h) + " " + (int)(sqrt * w);
	}
}
