package Baekjoon.Baekjoon_1676;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		int count = 0;

		BigInteger big = new BigInteger("1");
		for (int i = 1; i <= input; i++) {
			big = big.multiply(BigInteger.valueOf(i));
		}
		String string = big.toString();
		for (int i = string.length()-1; i >= 0 ; i--) {
			if (string.charAt(i) == '0') {
				count++;
			} else {
				break;
			}
		}
		System.out.println(count);
	}
}
