package Baekjoon.Baekjoon_9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testSize = Integer.parseInt(br.readLine());

		for (int i = 0; i < testSize; i++) {
			int target = Integer.parseInt(br.readLine());
			int temp = 0;
			for (int j = 3; j > 0; j--) {
				temp += solve(target, j);
			}
			sb.append(temp).append("\n");
		}
		System.out.println(sb);
	}

	private static int solve(int target, int now) {
		//4, 1
		int returnVal = 0;
		int rest = target - now;
		if (rest > 3) {
			for (int i = 3; i > 0; i--) {
				returnVal += solve(target, now + i);
			}
		}else{
			if (rest == 0) {
				return 1;
			} else if (rest < 0) {
				return 0;
			}

			for (int i = rest; i > 0; i--) {
				returnVal += solve(target, now + i); // 4, 3, 2
			}
		}

		return returnVal;
	}
}
