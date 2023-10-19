package Baekjoon.Baekjoon_10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] data = new String[n][n];
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				data[i][j] = split[j];
			}
		}
		int normalCount = getArea(data, n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (data[i][j].equals("G")) {
					data[i][j] = "R";
				}
			}
		}
		int colorBlindnessCount = getArea(data, n);

		System.out.println(normalCount + " " + colorBlindnessCount);
	}

	private static int getArea(String[][] data, int n) {
		int count = 0;
		boolean[][] isVisit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isVisit[i][j]) {
					bfs(data, isVisit, i, j, n);
					count++;
				}
			}
		}
		return count;
	}

	private static void bfs(String[][] data, boolean[][] isVisit, int i, int j, int n) {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(i, j));
		while (!queue.isEmpty()) {
			Position removedPosition = queue.remove();
			int x = removedPosition.x;
			int y = removedPosition.y;
			String target = data[x][y];

			//x+1
			if (x + 1 < n && !isVisit[x + 1][y] && data[x + 1][y].equals(target)) {
				isVisit[x + 1][y] = true;
				queue.add(new Position(x + 1, y));
			}
			//x-1
			if (x - 1 >= 0 && !isVisit[x - 1][y] && data[x - 1][y].equals(target)) {
				isVisit[x - 1][y] = true;
				queue.add(new Position(x - 1, y));
			}
			//y+1
			if (y + 1 < n && !isVisit[x][y + 1] && data[x][y + 1].equals(target)) {
				isVisit[x][y + 1] = true;
				queue.add(new Position(x, y + 1));
			}
			//y-1
			if (y - 1 >= 0 && !isVisit[x][y - 1] && data[x][y - 1].equals(target)) {
				isVisit[x][y - 1] = true;
				queue.add(new Position(x, y - 1));
			}
		}


	}

	static class Position {
		private final int x;
		private final int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


}
