package Baekjoon.Baekjoon_1389;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	private static ArrayList<Integer>[] nodes;
	private static boolean[] isVisited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");

		int nodeCount = Integer.parseInt(split[0]);
		int edgeCount = Integer.parseInt(split[1]);

		nodes = new ArrayList[nodeCount + 1];
		isVisited = new boolean[nodeCount + 1];

		for (int i = 1; i < nodeCount + 1; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCount; i++) {
			String[] data = br.readLine().split(" ");
			int a = Integer.parseInt(data[0]);
			int b = Integer.parseInt(data[1]);

			nodes[a].add(b);
			nodes[b].add(a);
		}

		solve(nodeCount);

	}

	private static void solve(int nodeCount) {
		int[] answerList = new int[nodeCount + 1];

		for (int i = 1; i < nodeCount + 1; i++) {
			int sum = 0;
			for (int j = 1; j < nodeCount + 1; j++) {
				if (i == j) {
					continue;
				}
				sum += bacon(i, j) - 1;
			}
			answerList[i] = sum;
		}

		int answer = 0;
		int min = 10000;
		for (int i = 1; i < nodeCount + 1; i++) {
			if (min > answerList[i]) {
				answer = i;
				min = answerList[i];
			}
		}
		System.out.println(answer);
	}

	private static int bacon(int vNode, int target) {
		if (vNode == target) {
			return 1;
		}
		int returnVal = 10000;
		isVisited[vNode] = true;
		for (Integer i : nodes[vNode]) {
			if (!isVisited[i]) {
				returnVal = Math.min(bacon(i, target), returnVal);
			}
		}
		isVisited[vNode] = false;

		return ++returnVal;
	}
}