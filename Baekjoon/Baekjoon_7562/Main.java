package Baekjoon.Baekjoon_7562;

import java.io.*;
import java.util.*;

public class Main {
	private static int[][] chessTable;
	private static boolean[][] isVisited;

	private static int nowX;
	private static int nowY;
	private static int targetX;
	private static int targetY;
	private static int dataSize;

	private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	private static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCaseSIze = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCaseSIze; i++) {
			dataSize = Integer.parseInt(br.readLine());

			chessTable = new int[dataSize][dataSize];
			isVisited = new boolean[dataSize][dataSize];

			String[] now = br.readLine().split(" ");
			nowX = Integer.parseInt(now[0]);
			nowY = Integer.parseInt(now[1]);
			String[] target = br.readLine().split(" ");
			targetX = Integer.parseInt(target[0]);
			targetY = Integer.parseInt(target[1]);

			if (nowX != targetX || nowY != targetY) {
				find();
			}

			sb.append(chessTable[targetX][targetY]).append("\n");

		}
		System.out.println(sb);
	}

	private static void find() {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(nowX, nowY));
		isVisited[nowX][nowY] = true;

		while (!queue.isEmpty()) {
			Coordinate now = queue.remove();
			int nowX = now.x;
			int nowY = now.y;

			for (int i = 0; i < 8; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];

				if (newX == targetX && newY == targetY) {
					chessTable[newX][newY] = chessTable[nowX][nowY] + 1;
					isVisited[newX][newY] = true;
					return;
				}

				if (newX >= 0 && newY >= 0 && newX < dataSize && newY < dataSize && !isVisited[newX][newY]) {
					queue.add(new Coordinate(newX, newY));
					chessTable[newX][newY] = chessTable[nowX][nowY] + 1;
					isVisited[newX][newY] = true;
				}
			}
		}
	}

	private static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
