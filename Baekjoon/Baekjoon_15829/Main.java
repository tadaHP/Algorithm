package Baekjoon.Baekjoon_15829;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int r = 31;
	static final int m = 1234567891;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long sum = 0;
		long pow = 1;

		int size = Integer.parseInt(br.readLine());
		String string = br.readLine();

		for (int i = 0; i < size; i++) {
			sum += ((string.charAt(i) - 96) * pow);
			pow = (pow * r) % m;
		}
		System.out.print(sum % m);
	}
}