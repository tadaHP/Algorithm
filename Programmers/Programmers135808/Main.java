package Programmers.Programmers135808;

import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		int k1 = 4;
		int m1 = 3;
		int[] score1 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

		System.out.println(solution(k1, m1, score1));

	}
	public static int solution(int k, int m, int[] score) { // K 최상점, M 사과 포장 개수, score
		int answer = 0;

		Arrays.sort(score);

		Stack<Integer> appleStack = new Stack<>();

		for (int i : score) {
			appleStack.add(i);
		}
		int box = 0;

		while (!appleStack.isEmpty()) {
			if (box == m - 1) {
				box = 0;
				Integer lowestVal = appleStack.pop();
				answer += lowestVal * m;
			} else {
				box++;
				appleStack.pop();
			}
		}

		return answer;
	}
}
