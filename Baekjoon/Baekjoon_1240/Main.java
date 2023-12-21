package Baekjoon.Baekjoon_1240;

import java.io.*;
import java.util.*;

public class Main {
	private static int[][] nodes;
	private static boolean[] isVisit;
	private static int nodeCount;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] lines = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		nodeCount = lines[0];
		int questionCount = lines[1];

		nodes = new int[nodeCount + 1][nodeCount + 1];

		for (int i = 0; i < nodeCount - 1; i++) {
			int[] conn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			nodes[conn[0]][conn[1]] = conn[2];
			nodes[conn[1]][conn[0]] = conn[2];
		}

		for (int i = 0; i < questionCount; i++) {
			int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			calculate(line[0], line[1]);
		}

	}

	private static void calculate(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		isVisit = new boolean[nodeCount + 1];
		int[] distance = new int[nodeCount + 1];

		isVisit[start] = true;
		queue.add(start);


		while (!queue.isEmpty()) {
			int now = queue.remove();

			for (int i = 1; i < nodeCount + 1; i++) {
				if (nodes[now][i] != 0 && !isVisit[i]) {
					distance[i] = distance[now] + nodes[now][i];

					if (i == end) {
						System.out.println(distance[i]);
						return;
					}

					queue.add(i);
					isVisit[i] = true;
				}
			}

		}

	}
}
