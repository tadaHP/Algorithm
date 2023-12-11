package Baekjoon.Baekjoon_1389;

import java.io.*;
import java.util.*;

public class Main {
	private static int[][] nodes;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");

		int nodeCount = Integer.parseInt(split[0]);
		int edgeCount = Integer.parseInt(split[1]);

		nodes = new int[nodeCount + 1][nodeCount + 1];

		for (int i = 1; i < nodeCount + 1; i++) {
			for (int j = 1; j < nodeCount + 1; j++) {
				if (i != j) {
					nodes[i][j] = 5001;
				}
			}
		}

		for (int i = 0; i < edgeCount; i++) {
			int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			nodes[data[0]][data[1]] = 1;
			nodes[data[1]][data[0]] = 1;
		}

		floydWarshall(nodeCount);

		int min = Integer.MAX_VALUE;
		int answer = -1;
		for (int i = 1; i < nodeCount + 1; i++) {
			int sum = 0;
			for (int j = 1; j < nodeCount + 1; j++) {
				sum += nodes[i][j];
			}

			if (min > sum) {
				min = sum;
				answer = i;
			}
		}

		System.out.println(answer);

	}

	private static void floydWarshall(int nodeCount) {
		for (int i = 1; i < nodeCount + 1; i++) {
			for (int j = 1; j < nodeCount + 1; j++) {
				for (int k = 1; k < nodeCount + 1; k++) {
					nodes[j][k] = Math.min(nodes[j][k], nodes[j][i] + nodes[i][k]);
				}
			}
		}
	}

}