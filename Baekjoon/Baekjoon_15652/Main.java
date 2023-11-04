package Baekjoon.Baekjoon_15652;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] split = br.readLine().split(" ");
		int size = Integer.parseInt(split[0]);
		int target = Integer.parseInt(split[1]);
		int[] isVisit = new int[size + 1];

		for (int i = 1; i < size + 1; i++) {
			isVisit[i]++;
			solve(isVisit, size, i, 1, target);
			isVisit[i]--;
		}

		System.out.println(sb);
	}

	private static void solve(int[] isVisit, int size, int start, int deep, int target) {
		if (deep == target) {
			print(isVisit, size);
			return;
		}

		for (int i = start; i < size + 1; i++) {
			isVisit[i]++;
			solve(isVisit, size, i, deep + 1, target);
			isVisit[i]--;
		}
	}

	private static void print(int[] isVisit, int size) {
		for (int i = 1; i < size + 1; i++) {
			for (int j = 0; j < isVisit[i]; j++) {
				sb.append(i).append(" ");
			}
		}
		sb.append("\n");
	}

}
