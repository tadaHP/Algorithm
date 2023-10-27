package Baekjoon.Baekjoon_21736;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int y = Integer.parseInt(split[0]);
		int x = Integer.parseInt(split[1]);
		Position positionNow = null;
		char[][] data = new char[y][x];
		boolean[][] isVisit = new boolean[y][x];
		int count = 0;
		for (int i = 0; i < y; i++) {
			char[] readData = br.readLine().toCharArray();
			for (int j = 0; j < x; j++) {
				if (readData[j] == 'I') {
					positionNow = new Position(j, i);
				}
				data[i][j] = readData[j];
			}
		}
		Queue<Position> queue = new LinkedList<>();
		queue.add(positionNow);

		while (!queue.isEmpty()) {
			Position now = queue.remove();
			int xNow = now.x;
			int yNow = now.y;

			if (xNow - 1 >= 0 && !isVisit[yNow][xNow - 1]) {
				isVisit[yNow][xNow - 1] = true;
				if (data[yNow][xNow - 1] != 'X') {
					queue.add(new Position(xNow - 1, yNow));
					if (data[yNow][xNow - 1] == 'P') {
						count++;
					}
				}
			}

			if (yNow - 1 >= 0 && !isVisit[yNow - 1][xNow]) {
				isVisit[yNow - 1][xNow] = true;
				if (data[yNow - 1][xNow] != 'X') {
					queue.add(new Position(xNow, yNow - 1));
					if (data[yNow - 1][xNow] == 'P') {
						count++;
					}
				}
			}

			if (xNow + 1 < x && !isVisit[yNow][xNow + 1]) {
				isVisit[yNow][xNow + 1] = true;
				if (data[yNow][xNow + 1] != 'X') {
					queue.add(new Position(xNow + 1, yNow));
					if (data[yNow][xNow + 1] == 'P') {
						count++;
					}
				}
			}

			if (yNow + 1 < y && !isVisit[yNow + 1][xNow]) {
				isVisit[yNow + 1][xNow] = true;
				if (data[yNow + 1][xNow] != 'X') {
					queue.add(new Position(xNow, yNow + 1));
					if (data[yNow + 1][xNow] == 'P') {
						count++;
					}
				}
			}
		}

		if (count == 0) {
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
	}

	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


}
