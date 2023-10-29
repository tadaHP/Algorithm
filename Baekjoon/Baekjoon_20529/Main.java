package Baekjoon.Baekjoon_20529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int minValue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		for (int i = 0; i < size; i++) {
			int caseSize = Integer.parseInt(br.readLine());
			String[] data = br.readLine().split(" ");
			if (caseSize > 32) {
				sb.append("0\n");
			} else {
				solve(caseSize, data);
				sb.append(minValue).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void solve(int caseSize, String[] data) {
		int count = 0;
		minValue = Integer.MAX_VALUE;
		for (int i = 0; i < caseSize - 2; i++) {
			String select1 = data[i];
			for (int j = i + 1; j < caseSize - 1; j++) {
				String select2 = data[j];
				for (int k = j + 1; k < caseSize; k++) {
					String select3 = data[k];

					String[] split1 = select1.split("");
					String[] split2 = select2.split("");
					String[] split3 = select3.split("");
					for (int l = 0; l < 4; l++) {
						if (!split1[l].equals(split2[l])) {
							count++;
						}
						if (!split1[l].equals(split3[l])) {
							count++;
						}
						if (!split2[l].equals(split3[l])) {
							count++;
						}
					}
					minValue = Math.min(minValue, count);
					count = 0;
				}
			}
		}
	}
}
