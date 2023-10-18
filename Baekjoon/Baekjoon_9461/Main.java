package Baekjoon.Baekjoon_9461;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());

		long[] padobanSequence = new long[101];
		padobanSequence[1] = 1;
		padobanSequence[2] = 1;
		padobanSequence[3] = 1;
		padobanSequence[4] = 2;
		padobanSequence[5] = 2;
		padobanSequence[6] = 3;
		padobanSequence[7] = 4;
		padobanSequence[8] = 5;
		padobanSequence[9] = 7;
		padobanSequence[10] = 9;
		for (int i = 11; i < 101; i++) {
			padobanSequence[i] = padobanSequence[i - 1] + padobanSequence[i - 5];
		}

		for (int i = 0; i < size; i++) {
			sb.append(padobanSequence[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
	}
}
