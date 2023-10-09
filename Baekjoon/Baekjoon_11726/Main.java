package Baekjoon.Baekjoon_11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int V1 = 1;
	private static final int V2 = 2;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n + 1];
		data[1] = V1;
		if (n > 1) {
			data[2] = V2;
		}
		for (int i = 3; i < n + 1; i++) {
			data[i] = (data[i - 1] + data[i - 2]) % 10007;
		}
		System.out.println(data[n]);
	}
}
