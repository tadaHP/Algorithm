package Baekjoon.Baekjoon_16928;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int radderSize = Integer.parseInt(split[0]);
		int snakeSize = Integer.parseInt(split[1]);
		int[] board = new int[100 + 1]; // 방문 count
		boolean[] isVisit = new boolean[100 + 1]; // 방문 여부
		int[] moveInfo = new int[100 + 1]; // snake, ladder

		for (int i = 0; i < radderSize; i++) {
			String[] data = br.readLine().split(" ");
			moveInfo[Integer.parseInt(data[0])] = Integer.parseInt(data[1]);
		}

		for (int i = 0; i < snakeSize; i++) {
			String[] data = br.readLine().split(" ");
			moveInfo[Integer.parseInt(data[0])] = Integer.parseInt(data[1]);
		}

		Queue<Integer> queue = new LinkedList<>();
		isVisit[1] = true;
		board[1] = 0;
		queue.add(1);

		while (!queue.isEmpty()) {
			int now = queue.remove();
			if (now == 100) {
				break;
			}
			isVisit[now] = true;

			if (moveInfo[now] != 0) {
				int before = now;
				now = moveInfo[now];
				isVisit[now] = true;
				board[now] = board[before];
			}

			for (int i = 1; i <= 6; i++) {
				if (now + i > 100 || isVisit[now + i]) {
					continue;
				}
				queue.add(now + i);
				isVisit[now + i] = true;
				board[now + i] = board[now] + 1;
			}
		}
		System.out.println(board[100]);
	}
}
