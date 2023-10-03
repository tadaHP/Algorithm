package Baekjoon.Baekjoon_2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[][] matrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] data = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				if (data[j].equals("1")) {
					matrix[i][j] = -1;
				} else {
					matrix[i][j] = 0;
				}
			}
		}

		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(0, 0));
		matrix[0][0] = 1;
		while (!queue.isEmpty()) {
			Position remove = queue.remove();

			if (remove.x + 1 < n && matrix[remove.x + 1][remove.y] == -1) {
				queue.add(new Position(remove.x + 1, remove.y));
				matrix[remove.x + 1][remove.y] = matrix[remove.x][remove.y] + 1;
			}
			if (remove.y + 1 < m && matrix[remove.x][remove.y + 1] == -1) {
				queue.add(new Position(remove.x, remove.y + 1));
				matrix[remove.x][remove.y + 1] = matrix[remove.x][remove.y] + 1;
			}
			if (remove.x - 1 >= 0 && matrix[remove.x - 1][remove.y] == -1) {
				queue.add(new Position(remove.x - 1, remove.y));
				matrix[remove.x - 1][remove.y] = matrix[remove.x][remove.y] + 1;
			}
			if (remove.y - 1 >= 0 && matrix[remove.x][remove.y - 1] == -1) {
				queue.add(new Position(remove.x, remove.y - 1));
				matrix[remove.x][remove.y - 1] = matrix[remove.x][remove.y] + 1;
			}
		}

		System.out.println(matrix[n-1][m-1]);
	}

	private static class Position{
		private final int x;
		private final int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
