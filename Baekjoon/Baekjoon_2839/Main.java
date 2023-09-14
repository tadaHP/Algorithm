package Baekjoon.Baekjoon_2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = Integer.MAX_VALUE;

		int target = Integer.parseInt(br.readLine());
		int max5 = target / 5;//5

		for (int i = max5; i >=0 ; i--) {
			int last = target - (i * 5);
			if (last % 3 == 0) {
				int sizeOf3 = last / 3;
				int sizeOfSugarBags = sizeOf3 + i;
				if (answer > sizeOfSugarBags) {
					answer = sizeOfSugarBags;
				}
			}
		}
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
