package Baekjoon.Baekjoon_20529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			int testSize = Integer.parseInt(br.readLine());
			BigInteger sum = new BigInteger("0");
			for (int j = 0; j < testSize; j++) {
				sum = sum.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
			}

			if (sum.compareTo(BigInteger.ZERO) == 1) {
				sb.append("+").append("\n");
			} else if (sum.compareTo(BigInteger.ZERO) == -1) {
				sb.append("-").append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);

	}
}
