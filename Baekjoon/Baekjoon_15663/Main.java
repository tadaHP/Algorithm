package Baekjoon.Baekjoon_15663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
	private static final StringBuilder sb = new StringBuilder();
	private static int size;
	private static int target;
	private static int[] newNum;
	private static boolean[] newIsVisit;
	private static int[] answers;
	private static Set<String> stringAnswers;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		size = Integer.parseInt(input[0]);
		target = Integer.parseInt(input[1]);

		int[] num = new int[size + 1];
		newNum = new int[size - 1];
		boolean[] isVisit = new boolean[size + 1];
		newIsVisit = new boolean[size - 1];
		answers = new int[target];
		stringAnswers = new LinkedHashSet<>();
		input = br.readLine().split(" ");
		for (int i = 1; i < size + 1; i++) {
			num[i] = Integer.parseInt(input[i - 1]);
		}
		Arrays.sort(num);

		for (int i = 1; i < size + 1; i++) {
			answers[0] = num[i];
			isVisit[i] = true;
			makeNewArray(num, isVisit);
			solve(target, 1);
			isVisit[i] = false;
		}

		print();
	}

	private static void makeNewArray(int[] num, boolean[] isVisit) {
		int count = 0;
		for (int i = 1; i < size + 1; i++) {
			if (!isVisit[i]) {
				newNum[count] = num[i];
				count++;
			}
		}
	}

	private static void solve(int target, int deep) {
		if (deep == target) {
			convert();
			return;
		}

		for (int i = 0; i < size - 1; i++) {
			if (!newIsVisit[i]) {
				newIsVisit[i] = true;
				answers[deep] = newNum[i];
				solve(target, deep + 1);
				newIsVisit[i] = false;
			}
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
