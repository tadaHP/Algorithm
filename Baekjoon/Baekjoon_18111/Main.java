package Baekjoon.Baekjoon_18111;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		int b = Integer.parseInt(split[2]);

		int min = 0;
		int max = 501;

		int[][] dataSet = new int[x][y];

		int time = Integer.MAX_VALUE;
		int height = 0;


		for (int i = 0; i < x; i++) {
			String[] data = br.readLine().split(" ");
			for (int j = 0; j < y; j++) {
				int now = Integer.parseInt(data[j]);
				dataSet[i][j] = now;
				if (now < min) {
					min = now;
				}
				if (now > max) {
					max = now;
				}
			}
		}

		for (int i = min; i <= max; i++) {
			int timeCount = 0;
			int block = b;
			for (int j = 0; j < x; j++) {
				for (int k = 0; k < y; k++) {
					if (i < dataSet[j][k]) {
						timeCount += (dataSet[j][k] - i) * 2;
						block += dataSet[j][k] - i;
					} else {
						timeCount += i - dataSet[j][k];
						block -= i - dataSet[j][k];
					}
				}
			}
			if (block < 0) {
				break;
			}
			if (time >= timeCount) {
				time = timeCount;
				height = i;
			}
		}

		System.out.println(time + " " + height);
	}
}
