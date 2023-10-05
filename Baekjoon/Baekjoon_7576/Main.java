package Baekjoon.Baekjoon_7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]); // y축
		int m = Integer.parseInt(split[1]); // x축

		int[][] tomatoInfo = new int[m][n];
		Queue<Position> queue = new LinkedList<>();

		for (int x = 0; x < m; x++) {
			String[] data = br.readLine().split(" ");
			for (int y = 0; y < n; y++) {
				int info = Integer.parseInt(data[y]);
				if (info == 1) {
					queue.add(new Position(x, y));
				}
				tomatoInfo[x][y] = info;
			}
		}

		//BFS
		while (!queue.isEmpty()) {
			Position positionNow = queue.remove();
			int x = positionNow.x;
			int y = positionNow.y;

			if (x + 1 < m && tomatoInfo[x + 1][y] == 0) {
				tomatoInfo[x + 1][y] = tomatoInfo[x][y] + 1;
				queue.add(new Position(x + 1, y));
			}
			if (y + 1 < n && tomatoInfo[x][y + 1] == 0) {
				tomatoInfo[x][y + 1] = tomatoInfo[x][y] + 1;
				queue.add(new Position(x, y + 1));
			}
			if (x - 1 >= 0 && tomatoInfo[x - 1][y] == 0) {
				tomatoInfo[x - 1][y] = tomatoInfo[x][y] + 1;
				queue.add(new Position(x - 1, y));
			}
			if (y - 1 >= 0 && tomatoInfo[x][y - 1] == 0) {
				tomatoInfo[x][y - 1] = tomatoInfo[x][y] + 1;
				queue.add(new Position(x, y - 1));
			}
		}

		int max = 0;

		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (tomatoInfo[x][y] == 0) {
					System.out.println("-1");
					return;
				} else if (tomatoInfo[x][y] < 0) {
				} else {
					if (max < tomatoInfo[x][y]) {
						max = tomatoInfo[x][y];
					}
				}
			}
		}
		System.out.println(max - 1);
	}


	private static class Position {
		private final int x;
		private final int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
