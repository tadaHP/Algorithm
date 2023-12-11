package Baekjoon.Baekjoon_3190;

import java.io.*;
import java.util.*;

public class Main {
	private static final int[] dy = {1, 0, -1, 0};
	private static final int[] dx = {0, 1, 0, -1};
	private static int boardSize;
	private static boolean[][] board;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Position> queue = new LinkedList<>();

		boardSize = Integer.parseInt(br.readLine());

		board = new boolean[boardSize + 1][boardSize + 1];

		int appleCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < appleCount; i++) {
			int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			board[position[0]][position[1]] = true;
		}

		int rotationCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < rotationCount; i++) {
			String[] data = br.readLine().split(" ");
			queue.add(new Position(Integer.parseInt(data[0]), data[1]));
		}

		solve(queue);

	}

	private static void solve(Queue<Position> rotateQueue) {
		int xNow = 1;
		int yNow = 1;
		int time = 0;
		int direction = 0;
		boolean isFinished = true;
		Deque<Snake> snakes = new LinkedList<>();
		Position remove = null;
		int second;
		String rotate = null;

		snakes.add(new Snake(xNow, yNow));

		while (isFinished) {
			if (!rotateQueue.isEmpty()) {
				remove = rotateQueue.remove();
				second = remove.second;
				rotate = remove.rotate;
			} else {
				second = 101;
			}

			for (; time < second; ++time) {
				int newX = xNow + dx[direction];
				int newY = yNow + dy[direction];

				if (isFinished(newX, newY, snakes)) {
					isFinished = false;
					break;
				}

				if (board[newX][newY]) { // 사과 있으면
					board[newX][newY] = false;
				} else {
					snakes.removeFirst();
				}
				snakes.add(new Snake(newX, newY));
				xNow = newX;
				yNow = newY;
			}

			direction = rotate(direction, rotate);
		}

		System.out.println(time + 1);


	}

	private static int rotate(int direction, String rotate) {
		if (rotate.equals("L")) {
			direction = direction - 1;
			if (direction == -1) {
				return 3;
			}
			return direction;
		}

		direction = direction + 1;
		if (direction == 4) {
			return 0;
		}
		return direction;

	}

	private static boolean isFinished(int x, int y, Queue<Snake> snakes) {
		if (x < 1 || y < 1 || x > boardSize || y > boardSize) {
			return true;
		}
		for (Snake snake : snakes) {
			int snakeX = snake.x;
			int snakeY = snake.y;
			if (x == snakeX && y == snakeY) {
				return true;
			}
		}
		return false;
	}

	public static class Snake {
		int x;
		int y;

		Snake(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Position {
		String rotate;
		int second;

		Position(int second, String rotate) {
			this.second = second;
			this.rotate = rotate;
		}
	}
}
