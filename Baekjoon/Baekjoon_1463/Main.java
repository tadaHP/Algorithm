package Baekjoon.Baekjoon_1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());

		int[] data = new int[x + 1];
		data[0] = 0;
		data[1] = 0;

		for (int i = 2; i < x + 1; i++) {
			data[i] = data[i - 1] + 1;

			if (i % 2 == 0) {
				data[i] = Math.min(data[i], data[i / 2] + 1);
			}
			if (i % 3 == 0) {
				data[i] =Math.min(data[i], data[i / 3] + 1);
			}
		}

		System.out.println(data[x]);
	}
}
