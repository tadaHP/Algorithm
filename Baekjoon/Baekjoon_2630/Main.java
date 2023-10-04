package Baekjoon.Baekjoon_2630;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int white = 0;
	private static int colored = 0;
	private static boolean[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		paper = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String[] data = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				if (data[j].equals("1")) {
					paper[i][j] = true;
				}
			}
		}

		solve(0, 0, n);


		System.out.println(white);
		System.out.println(colored);


	}

	private static void solve(int x, int y, int size) {
		if (isSame(x, y, size)) {
			if (paper[x][y]) {
				colored++;
			} else {
				white++;
			}
			return;
		}

		int newSize = size / 2;

		solve(x, y, newSize);
		solve(x + newSize, y, newSize);
		solve(x, y + newSize, newSize);
		solve(x + newSize, y + newSize, newSize);

	}

	private static boolean isSame(int x, int y, int size) {

		boolean base = paper[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (base != paper[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}
