package Baekjoon.Baekjoon_1051;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int[][] data;
	private static int x;
	private static int y;
	private static int answer = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String[] split = br.readLine().split(" ");
		y = Integer.parseInt(split[0]);
		x = Integer.parseInt(split[1]);

		data = new int[y][x];
		for (int i = 0; i < y; i++) {
			split = br.readLine().split("");
			for (int j = 0; j < x; j++) {
				data[i][j] = Integer.parseInt(split[j]);
			}
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				check(j, i);
			}
		}

		System.out.println(answer);
	}
	private static void check(int i, int j) {
		int select = data[j][i];
		int newI = i + 1;
		int newJ = j + 1;
		while (newI < x && newJ < y) {
			int v1 = data[j][newI];
			int v2 = data[newJ][i];
			int v3 = data[newJ][newI];
			if (select == v1 && v2 == v3 && v1 == v2) {
				answer = Math.max((newI - i + 1) * (newI - i + 1), answer);
			}
			newI++;
			newJ++;
		}
	}
}
