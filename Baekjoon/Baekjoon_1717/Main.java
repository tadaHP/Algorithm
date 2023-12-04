package Baekjoon.Baekjoon_1717;

import java.io.*;
import java.util.*;

public class Main {
	private static final String YES = "YES";
	private static final String NO = "NO";
	private static int[] data;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int countOfCalculation = init[0];
		int countOfLine = init[1];

		data = new int[countOfCalculation + 1];
		for (int i = 1; i < countOfCalculation + 1; i++) {
			data[i] = i;
		}

		for (int i = 0; i < countOfLine; i++) {
			int[] read = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int v1 = read[1];
			int v2 = read[2];
			if (read[0] == 0) { // 입력
				int v1Parents = findParents(v1);
				int v2Parents = findParents(v2);
				if (v1Parents > v2Parents) {
					data[v1Parents] = v2Parents;
				} else {
					data[v2Parents] = v1Parents;
				}
			} else { // 확인
				int parents1 = findParents(v1);
				int parents2 = findParents(v2);
				if (parents1 == parents2) {
					sb.append(YES).append("\n");
				} else {
					sb.append(NO).append("\n");
				}
			}
		}
		System.out.println(sb);

	}

	private static int findParents(int target) {

		if (target == data[target]) {
			return target;
		}

		return data[target] = findParents(data[target]);
	}

}
