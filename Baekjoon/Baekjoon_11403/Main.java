package Baekjoon.Baekjoon_11403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int size;
	private static boolean[][] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		size = Integer.parseInt(br.readLine());
		data = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				int now = Integer.parseInt(split[j]);
				if (now == 0) {
					data[i][j] = false;
				} else {
					data[i][j] = true;
				}
			}
		}

		for (int i = 0; i < size; i++) {//start
			sb.append(toString(solve(i))).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean[] solve(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] isVisit = new boolean[size];
		for (int i = 0; i < size; i++) {
			if (data[start][i]) {
				queue.add(i);
				isVisit[i] = true;
			}
		}

		while (!queue.isEmpty()) {
			int visit = queue.remove();
			for (int i = 0; i < size; i++) {
				if (data[visit][i]&&!isVisit[i]) {
					queue.add(i);
					isVisit[i] = true;
				}
			}
		}
		return isVisit;
	}

	private static String toString(boolean[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (data[i]) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}
		return sb.toString();
	}

}
