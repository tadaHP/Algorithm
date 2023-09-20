package Baekjoon.Baekjoon_18110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		int size = Integer.parseInt(br.readLine());
		if (size == 0) {
			System.out.println(0);
			return;
		}
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		int truncation = Math.round((float)size / 100 * 15);

		Arrays.sort(array);

		for (int i = truncation; i < size - truncation; i++) {
			sum += array[i];
		}

		System.out.println(Math.round((float)sum / (size - (2 * truncation))));

	}

}
