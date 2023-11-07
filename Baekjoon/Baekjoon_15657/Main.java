package Baekjoon.Baekjoon_15657;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final StringBuilder sb = new StringBuilder();
	private static int size;
	private static int target;
	private static int[] num;
	private static int[] answers;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		size = Integer.parseInt(input[0]);
		target = Integer.parseInt(input[1]);

		num = new int[size];
		answers = new int[target];
		input = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(num);

		for (int i = 0; i < size; i++) {
			answers[0] = num[i];
			solve(i, target, 1);
		}

		System.out.println(sb);
	}

	private static void solve(int start, int target, int deep) {
		if (deep == target) {
			print();
			return;
		}

		for (int i = start; i < size; i++) {
			answers[deep] = num[i];
			solve(i, target, deep + 1);
			}
	}

	private static void print() {
		for (int i = 0; i < target; i++) {
			sb.append(answers[i]).append(" ");
		}
		sb.append("\n");
	}

}
