package Baekjoon.Baekjoon_1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		int sum = 0;
		boolean isFirst = false;

		String[] split = string.split("-");

		for (String s : split) {
			int temp = 0;
			String[] plusSplit = s.split("\\+");
			for (String s1 : plusSplit) {
				temp += Integer.parseInt(s1);
			}

			if (!isFirst) {
				sum = temp;
				isFirst = true;
			} else {
				sum -= temp;
			}
		}

		System.out.println(sum);

	}
}
