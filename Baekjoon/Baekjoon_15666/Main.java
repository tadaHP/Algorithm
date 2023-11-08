package Baekjoon.Baekjoon_15666;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
	private static final StringBuilder sb = new StringBuilder();
	private static int size;
	private static int target;
	private static int[] answers;
	private static Set<String> stringAnswers;
	private static int[] num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		size = Integer.parseInt(input[0]);
		target = Integer.parseInt(input[1]);

		num = new int[size + 1];
		answers = new int[target];
		stringAnswers = new LinkedHashSet<>();
		input = br.readLine().split(" ");
		for (int i = 1; i < size + 1; i++) {
			num[i] = Integer.parseInt(input[i - 1]);
		}
		Arrays.sort(num);

		for (int i = 1; i < size + 1; i++) {
			solve(target, 0, 1);
		}

		print();
	}

	private static void solve(int target, int deep, int start) {
		if (deep == target) {
			convert();
			return;
		}

		for (int i = start; i < size + 1; i++) {
			answers[deep] = num[i];
			solve(target, deep + 1, i);
		}
	}

	private static void convert() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < target; i++) {
			sb.append(answers[i]).append(" ");
		}
		stringAnswers.add(sb.toString());
	}

	private static void print() {
		for (String answer : stringAnswers) {
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
