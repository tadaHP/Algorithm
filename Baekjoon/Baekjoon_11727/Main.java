package Baekjoon.Baekjoon_11727;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] data = new int[1000];
		data[0] = 1;
		data[1] = 3;
		data[2] = 5;

		for (int i = 3; i < size; i++) {
			data[i] = (data[i - 1] + (data[i - 2] * 2)) % 10007;
		}
		System.out.println(data[size - 1]);
	}
}