package Baekjoon.Baekjoon_11399;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int caseSize = Integer.parseInt(br.readLine());
		int[] data = new int[caseSize];
		int sum = 0;
		int temp = 0;

		String[] values = br.readLine().split(" ");

		for (int i = 0; i < caseSize; i++) {
			data[i] = Integer.parseInt(values[i]);
		}
		Arrays.sort(data);

		for (int i = 0; i < caseSize; i++) {
			temp += data[i];
			sum += temp;
		}

		System.out.println(sum);
	}
}
