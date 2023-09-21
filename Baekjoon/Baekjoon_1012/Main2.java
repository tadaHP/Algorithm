package Baekjoon.Baekjoon_1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 { //BFS
	private static boolean[][] isVisited;

	private static int x;
	private static int y;
	private static int k;
	private static boolean[][] field;
	private static int count;
	private static int[] changeX = {1, 0, -1, 0};
	private static int[] changeY = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++) {
			String[] split = br.readLine().split(" ");
			x = Integer.parseInt(split[0]);
			y = Integer.parseInt(split[1]);
			k = Integer.parseInt(split[2]);

			isVisited = new boolean[x][y];
			field = new boolean[x][y];
			count = 0;
			//데이터 입력
			for (int j = 0; j < k; j++) {
				String[] positions = br.readLine().split(" ");
				field[Integer.parseInt(positions[0])][Integer.parseInt(positions[1])] = true;
			}
			for (int xN = 0; xN < x; xN++) {
				for (int yN = 0; yN < y; yN++) {
					if (field[xN][yN] && !isVisited[xN][yN]) {
						solve(xN, yN);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void solve(int xN, int yN) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {xN, yN});

		while (!queue.isEmpty()) {
			xN = queue.peek()[0];
			yN = queue.peek()[1];
			isVisited[xN][yN] = true;
			queue.poll();
			for (int i = 0; i <4; i++) {
				int xU = xN - changeX[i];
				int yU = yN - changeY[i];

				if (xU >= 0 && yU >= 0 && xU < x && yU < y && !isVisited[xU][yU] && field[xU][yU]) {
					queue.add(new int[] {xU, yU});
					isVisited[xU][yU] = true;
				}

			}

		}

	}
}
