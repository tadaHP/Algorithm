package Baekjoon.Baekjoon_14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static boolean[][] isVisit;
	private static int[][] data;
	private static int width;
	private static int height;
	private static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		width = Integer.parseInt(split[0]);
		height = Integer.parseInt(split[1]);
		data = new int[width][height];
		isVisit = new boolean[width][height];

		for (int i = 0; i < width; i++) {
			String[] read = br.readLine().split(" ");
			for (int j = 0; j < height; j++) {
				data[i][j] = Integer.parseInt(read[j]);
			}
		}

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				isVisit[i][j] = true;
				dfs(i, j, 1, data[i][j]);
				isVisit[i][j] = false;
				calculateT(i, j);
			}
		}

		System.out.println(max);
	}

	private static void dfs(int row, int column, int deep, int sum) {
		if (deep == 4) {
			max = Math.max(max, sum);
			return;
		}

		if (row - 1 >= 0 && !isVisit[row - 1][column]) {
			isVisit[row - 1][column] = true;
			dfs(row - 1, column, deep + 1, sum + data[row - 1][column]);
			isVisit[row - 1][column] = false;
		}
		if (column - 1 >= 0 && !isVisit[row][column - 1]) {
			isVisit[row][column - 1] = true;
			dfs(row, column - 1, deep + 1, sum + data[row][column - 1]);
			isVisit[row][column - 1] = false;
		}
		if (row + 1 < width && !isVisit[row + 1][column]) {
			isVisit[row + 1][column] = true;
			dfs(row + 1, column, deep + 1, sum + data[row + 1][column]);
			isVisit[row + 1][column] = false;
		}
		if (column + 1 < height && !isVisit[row][column + 1]) {
			isVisit[row][column + 1] = true;
			dfs(row, column + 1, deep + 1, sum + data[row][column + 1]);
			isVisit[row][column + 1] = false;
		}
	}

	private static void calculateT(int row, int column) {
		   int sum = 0;
			//ㅜ
		if (row + 1 < width  && column + 2 < height) {
			sum = data[row][column] + data[row][column + 1] + data[row][column + 2] + data[row + 1][column + 1];
			max = Math.max(max, sum);
		}
		   //ㅏ
		if (row + 2 < width && column + 1 < height) {
			sum = data[row][column] + data[row + 1][column] + data[row + 2][column] + data[row + 1][column + 1];
			max = Math.max(max, sum);
		}
		   //ㅗ
		if (column + 2 < height && row - 1 >= 0) {
			sum = data[row][column] + data[row][column + 1] + data[row][column + 2] + data[row - 1][column + 1];
			max = Math.max(max, sum);
		}
		   //ㅓ
		if (column + 1 < height && row - 1 >= 0 && row + 1 < width) {
			sum = data[row][column] + data[row][column + 1] + data[row - 1][column + 1] + data[row + 1][column + 1];
			max = Math.max(max, sum);
		}
	}

}
