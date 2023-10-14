package Baekjoon.Baekjoon_7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int m = Integer.parseInt(split[0]);
		int n = Integer.parseInt(split[1]);
		int h = Integer.parseInt(split[2]);

		int[][][] data = new int[h][n][m]; // 높이 h, 가로 y, 세로 x
		boolean[][][] isVisited = new boolean[h][n][m];
		Queue<Point> pointQueue = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				String[] stringData = br.readLine().split(" ");
				for (int k = 0; k < m; k++) {
					int point = Integer.parseInt(stringData[k]);
					data[i][j][k] = point;
					if (point == 1) {
						pointQueue.add(new Point(i, j, k));
						isVisited[i][j][k] = true;
					} else if (point == -1) {
						isVisited[i][j][k] = true;
					}
				}
			}
		}

		System.out.println(solve(pointQueue, isVisited, data, m, n, h));

	}

	private static int solve(Queue<Point> pointQueue, boolean[][][] isVisited,
		int[][][] data, int m, int n, int h) {
		while (!pointQueue.isEmpty()) {
			Point removedData = pointQueue.remove();
			int xNow = removedData.x;
			int yNow = removedData.y;
			int zNow = removedData.z;

			//[z][y][x]
			if (xNow - 1 >= 0 && !isVisited[zNow][yNow][xNow - 1]) {//x-1
				isVisited[zNow][yNow][xNow - 1] = true;
				data[zNow][yNow][xNow - 1] = data[zNow][yNow][xNow] + 1;
				pointQueue.add(new Point(zNow, yNow, xNow - 1));
			}
			if (xNow + 1 < m && !isVisited[zNow][yNow][xNow + 1]) {//x+1
				isVisited[zNow][yNow][xNow + 1] = true;
				data[zNow][yNow][xNow + 1] = data[zNow][yNow][xNow] + 1;
				pointQueue.add(new Point(zNow, yNow, xNow + 1));
			}
			if (yNow - 1 >= 0 && !isVisited[zNow][yNow - 1][xNow]) {//y-1
				isVisited[zNow][yNow - 1][xNow] = true;
				data[zNow][yNow - 1][xNow] = data[zNow][yNow][xNow] + 1;
				pointQueue.add(new Point(zNow, yNow - 1, xNow));
			}
			if (yNow + 1 < n && !isVisited[zNow][yNow + 1][xNow]) {//y+1
				isVisited[zNow][yNow + 1][xNow] = true;
				data[zNow][yNow + 1][xNow] = data[zNow][yNow][xNow] + 1;
				pointQueue.add(new Point(zNow, yNow + 1, xNow));
			}
			if (zNow - 1 >= 0 && !isVisited[zNow - 1][yNow][xNow]) {//z-1
				isVisited[zNow - 1][yNow][xNow] = true;
				data[zNow - 1][yNow][xNow] = data[zNow][yNow][xNow] + 1;
				pointQueue.add(new Point(zNow - 1, yNow, xNow));
			}
			if (zNow + 1 < h && !isVisited[zNow + 1][yNow][xNow]) {//z+1
				isVisited[zNow + 1][yNow][xNow] = true;
				data[zNow + 1][yNow][xNow] = data[zNow][yNow][xNow] + 1;
				pointQueue.add(new Point(zNow + 1, yNow, xNow));
			}
		}
		int min = -1;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (!isVisited[i][j][k]) {
						return -1;
					}
					if (min < data[i][j][k]) {
						min = data[i][j][k];
					}
				}
			}
		}

		return min  - 1;
	}

	private static class Point {
		private final int z;
		private final int y;
		private final int x;

		public Point(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
	
}
