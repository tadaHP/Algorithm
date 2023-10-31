package Baekjoon.Baekjoon_9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int count = 0;
	private static int chessSize;
	private static int[] chessTable;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		chessSize= Integer.parseInt(br.readLine());
		chessTable = new int[chessSize];

		for (int i = 0; i < chessSize; i++) {
				chessTable[0] = i;
				dfs(1);
		}

		System.out.println(count);
	}

	private static void dfs(int x) {
		if (x == chessSize) {
			count++;
			return;
		}

		for (int i = 0; i < chessSize; i++) {
			if (isPossible(x, i)) {
				chessTable[x] = i;
				dfs(x + 1);
			}
		}
	}

	private static boolean isPossible(int x, int visit) {

		for (int i = 0; i < x; i++) {
			if (chessTable[i] == visit || Math.abs(i - x) == Math.abs(chessTable[i] - visit)) {
				return false;
			}
		}
		return true;
	}
}

