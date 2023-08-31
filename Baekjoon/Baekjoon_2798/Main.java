package Baekjoon.Baekjoon_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	private static Stack<Integer> selectCards = new Stack<>();

	private static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		String[] stringCards = br.readLine().split(" ");
		ArrayList<Integer> cards = new ArrayList<>();

		for (String card : stringCards) {
			cards.add(Integer.parseInt(card));
		}

		findOut(0, m, n, 0, cards);

		System.out.println(maxValue);

	}

	private static void findOut(int deep, int m, int n, int start, ArrayList<Integer> cards) {
		if (deep == 3) {
			int sum = 0;
			for (Integer selectCard : selectCards) {
				sum += selectCard;
			}
			if (sum <= m && maxValue < sum) {
				maxValue = sum;
			}
			return;
		}

		for (int i = start; i < n; i++) {
			selectCards.add(cards.get(i));
			findOut(deep + 1, m, n, i+1, cards);
			selectCards.pop();
		}

	}
}
