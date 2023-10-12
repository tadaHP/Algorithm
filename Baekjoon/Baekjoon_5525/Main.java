package Baekjoon.Baekjoon_5525;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iCount = Integer.parseInt(br.readLine());
		int length = Integer.parseInt(br.readLine());
		String data = br.readLine();
		char[] charData = data.toCharArray();

		int count = 0;
		int answer = 0;
		for (int i = 1; i < length - 1; ) {
			if (charData[i] == 'O' && charData[i + 1] == 'I') {
				count++;
				if (count == iCount) {
					if (charData[i - (count * 2) + 1] == 'I') {
						answer++;
					}
					count--;
				}
				i += 2;
			} else {
				count = 0;
				i++;
			}
		}
		System.out.println(answer);
	}
}
