package Baekjoon.Baekjoon_1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int[] changeX = {0, 0, 1, 1};
	private static final int[] changeY = {0, 1, 0, 1};
	private static int lastValue;
	private static int targetX;
	private static int targetY;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		targetX = Integer.parseInt(split[1]);
		targetY = Integer.parseInt(split[2]);
		int pow = (int)Math.pow(2, n);
		lastValue = 0;

		solve(n, pow);

	}

	private static void solve(int n, int blockSize) {
		int half = blockSize / 2;
		// escape state
		if (n == 1) {
			if (targetX < half && targetY < half) {// 왼쪽 위
				System.out.println(lastValue);
			} else if (targetX < half) { //오른쪽 위
				System.out.println(lastValue + 1);
			} else if (targetY < half) { // 왼쪽 아래
				System.out.println(lastValue + 2);
			} else { // 오른쪽 아래
				System.out.println(lastValue + 3);
			}
			return;
		}

		// recursion state
		int pow = (int)Math.pow(4, n - 1);
		if (targetX < half && targetY < half) {// 왼쪽 위
			solve(n - 1, blockSize / 2);
		} else if (targetX < half) { //오른쪽 위
			lastValue += pow;
			targetY -= half;
			solve(n - 1, blockSize / 2);
		} else if (targetY < half) { // 왼쪽 아래
			lastValue += pow * 2;
			targetX -= half;
			solve(n - 1, blockSize / 2);
		} else { // 오른쪽 아래
			lastValue += pow * 3;
			targetX -= half;
			targetY -= half;
			solve(n - 1, blockSize / 2);
		}

	}
}