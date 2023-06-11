package Programmers.Programmers169199;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
		String[] board2 = {"..R", "...", "...", "..D", "DG."};
		System.out.println(solution(board2));
	}

	public static int solution(String[] board) {
		//데이터 세팅
		String[][] splitBoard = new String[board[0].length()][board.length];
		boolean[][] isVisited = new boolean[board[0].length()][board.length];
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		int[] start = {};

		for (int i = 0; i < board.length; i++) {
			String[] split = board[i].split("");

			for (int j = 0; j < split.length; j++) {
				splitBoard[j][i] = split[j];

				if (split[j].equals("R")) {
					start = new int[] {j, i};
				}
			}
		}

		//탐색

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start[0], start[1], 0});
		isVisited[start[0]][start[1]] =true;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1];
			int count = q[2];

			for (int i = 0; i < 4; i++) {
				int newX = x;
				int newY = y;
				while (true) {
					//이동
					newX += dx[i];
					newY += dy[i];
					//보드 점검
					if (newX < 0 || newY < 0 || newX >= board[0].length() || newY >= board.length) {
						break;
					}
					//위치 점검
					if (splitBoard[newX][newY].equals("D")) {
						newX -= dx[i];
						newY -= dy[i];
						break;
					}
				}

				if (newX < 0 || newY < 0 || newX >= board[0].length() || newY >= board.length) {
					if (i == 0) {
						newX = board[0].length() - 1;
					} else if (i == 1) {
						newX = 0;
					} else if (i == 2) {
						newY = board.length - 1;
					} else {
						newY = 0;
					}
				}
				if (splitBoard[newX][newY].equals("G")) {
					return count + 1;
				}

				if (!isVisited[newX][newY]) {
					queue.add(new int[] {newX, newY, count + 1});
					isVisited[newX][newY] = true;
				}
			}

		}

		return -1;
	}


}
