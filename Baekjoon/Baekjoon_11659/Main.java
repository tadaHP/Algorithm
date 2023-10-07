package Baekjoon.Baekjoon_11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] firstInfo = br.readLine().split(" ");
		int n = Integer.parseInt(firstInfo[0]);
		int m = Integer.parseInt(firstInfo[1]);

		String[] nData = br.readLine().split(" ");
		int[][] data = new int[n][2];
		for (int i = 0; i < n; i++) {
			data[i][0] = Integer.parseInt(nData[i]);
		}

		data[0][1] = data[0][0];

		for (int i = 1; i < n; i++) {
			data[i][1] = data[i - 1][1] + data[i][0];
		}

		for (int i = 0; i < m; i++) {
			String[] targetData = br.readLine().split(" ");
			int startPoint = Integer.parseInt(targetData[0]);
			int endPoint = Integer.parseInt(targetData[1]);

			if (startPoint == 1) {
				sb.append(data[endPoint - 1][1]).append("\n");
			} else {
				sb.append(data[endPoint - 1][1] - data[startPoint-2][1]).append("\n");
			}
		}

		System.out.println(sb);


	}
}
