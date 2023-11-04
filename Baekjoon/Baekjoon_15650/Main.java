package Baekjoon.Baekjoon_15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static boolean[] isVisit;
	private static int size;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] split = br.readLine().split(" ");
		size = Integer.parseInt(split[0]);
		int target = Integer.parseInt(split[1]);
		isVisit = new boolean[size + 1];

		for (int i = 1; i < size + 2 - target; i++) {
			isVisit[i] = true;
			solve(i, 1, target);
			isVisit[i] = false;
		}
		System.out.println(sb);
	}

	private static void solve(int start, int deep, int target) {
		if (deep == target) {
			print();
			return;
		}

		for (int i = start + 1; i < size + 1; i++) {
			isVisit[i] = true;
			solve(i, deep + 1, target);
			isVisit[i] = false;
		}
	}

	private static void print() {
		for (int i = 1; i < size + 1; i++) {
			if (isVisit[i]) {
				sb.append(i).append(" ");
			}
		}
		sb.append("\n");
	}
}
