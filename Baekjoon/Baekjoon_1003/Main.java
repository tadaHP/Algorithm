package Baekjoon.Baekjoon_1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static Integer[] array;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());
		array = new Integer[41];
		array[0] = 0;
		array[1] = 1;
		for (int i = 0; i < size; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				sb.append("1 0\n");
			} else if (n == 1) {
				sb.append("0 1\n");
			} else {
				sb.append(fibonacci(n - 1)).append(" ").append(fibonacci(n)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static int fibonacci(int n) {
		if (array[n] == null) {
			array[n] = fibonacci(n - 1) + fibonacci(n - 2);
		}
		return array[n];

	}
}
