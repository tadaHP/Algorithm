package Baekjoon.Baekjoon_1373;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		String[] split = br.readLine().split("");

		for (int i = 0; i < split.length; i += 3) {
			int visit = split.length - i - 1;
			int value = 0;

			if (visit - 2 > -1) {
				value += Integer.parseInt(split[visit - 2]) * 4;
			}
			if (visit - 1 > -1) {
				value += Integer.parseInt(split[visit - 1]) * 2;
			}
			value += Integer.parseInt(split[visit]);

			sb.insert(0, value);
		}
		System.out.println(sb);

	}
}
