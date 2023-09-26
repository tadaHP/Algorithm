package Baekjoon.Baekjoon_2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		int[] stairs = new int[size + 1];
		int[] data = new int[size + 1];

		for (int i = 1; i < size + 1; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		data[1] = stairs[1];

		if (size >= 2) {
			data[2] = stairs[1] + stairs[2];
		}

		for (int i = 3; i < size + 1; i++) {
			data[i] = Math.max(data[i - 2], data[i - 3] + stairs[i - 1]) + stairs[i];
		}

		System.out.println(data[size]);

	}
}
