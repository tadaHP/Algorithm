package Baekjoon.Baekjoon_2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	private static int[][] data;
	private static int size;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		size = Integer.parseInt(br.readLine());
		data = new int[size][size];

		ArrayList<Integer> counts = new ArrayList<>();

		int number = 1;

		//read
		for (int i = 0; i < size; i++) {
			String[] read = br.readLine().split("");
			for (int j = 0; j < size; j++) {
				if (read[j].equals("1")) {
					data[i][j] = -1;
				} else {
					data[i][j] = 0;
				}
			}
		}

		// calculate
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (data[x][y] == -1) {
					int visit = visit(x, y, number);
					counts.add(visit);
					number++;
				}
			}
		}
		counts.sort(Comparator.naturalOrder());

		sb.append(number - 1).append("\n");
		for (Integer count : counts) {
			sb.append(count).append("\n");
		}

		System.out.println(sb);

	}

	private static int visit(int x, int y, int number) {
		data[x][y] = number;
		int count = 1;

		if (x + 1 < size && data[x + 1][y] == -1) {
			count += visit(x + 1, y, number);
		}
		if (y + 1 < size && data[x][y + 1] == -1) {
			count += visit(x, y + 1, number);
		}
		if (x - 1 >= 0 && data[x - 1][y] == -1) {
			count += visit(x - 1, y, number);
		}
		if (y - 1 >= 0 && data[x][y - 1] == -1) {
			count += visit(x, y - 1, number);
		}

		return count;
	}


}
