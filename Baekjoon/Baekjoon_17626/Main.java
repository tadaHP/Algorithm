package Baekjoon.Baekjoon_17626;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int[] data = new int[50000 + 1];

		data[1] = 1;

		for (int i = 2; i <= number; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, data[i - j * j]);
			}
			data[i] = min + 1;
		}
		System.out.println(data[number]);
	}
}