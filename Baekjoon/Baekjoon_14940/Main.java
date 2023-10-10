package Baekjoon.Baekjoon_14940;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] split = br.readLine().split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);

		Coordinate startCoordinate = null;

		int[][] data = new int[x][y];
		boolean[][] isVisit = new boolean[x][y];

		for (int i = 0; i < x; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < y; j++) {
				int point = Integer.parseInt(input[j]);
				data[i][j] = point;
				if (point == 2) {
					startCoordinate = new Coordinate(i, j);
					isVisit[i][j] = true;
				} else if (point == 0) {
					isVisit[i][j] = true;
				}
			}
		}

		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(startCoordinate);
		data[startCoordinate.x][startCoordinate.y] = 0;

		while (!queue.isEmpty()) {
			Coordinate now = queue.remove();
			int visitX = now.x;
			int visitY = now.y;

			if (visitX + 1 < x && !isVisit[visitX+1][visitY]) { // x + 1
				isVisit[visitX + 1][visitY] = true;
				if (data[visitX + 1][visitY] == 1) {
					data[visitX + 1][visitY] = data[visitX][visitY] + 1;
					queue.add(new Coordinate(visitX + 1, visitY));
				}
			}
			if (visitY + 1 < y && !isVisit[visitX][visitY+1]) { // y + 1
				isVisit[visitX][visitY + 1] = true;
				if (data[visitX][visitY + 1] == 1) {
					data[visitX][visitY + 1] = data[visitX][visitY] + 1;
					queue.add(new Coordinate(visitX, visitY + 1));
				}
			}
			if (visitX - 1 > -1 && !isVisit[visitX - 1][visitY]) { // x - 1
				isVisit[visitX - 1][visitY] = true;
				if (data[visitX - 1][visitY] == 1) {
					data[visitX - 1][visitY] = data[visitX][visitY] + 1;
					queue.add(new Coordinate(visitX - 1, visitY));
				}
			}
			if (visitY - 1 > -1 && !isVisit[visitX][visitY - 1]) { // y - 1
				isVisit[visitX][visitY - 1] = true;
				if (data[visitX][visitY - 1] == 1) {
					data[visitX][visitY - 1] = data[visitX][visitY] + 1;
					queue.add(new Coordinate(visitX, visitY - 1));
				}
			}

		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (isVisit[i][j]) {
					sb.append(data[i][j]).append(" ");
				} else {
					sb.append("-1 ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static class Coordinate {
		private final int x;
		private final int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
