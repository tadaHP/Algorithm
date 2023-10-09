package Baekjoon.Baekjoon_11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static boolean[] isVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int nodeCount = Integer.parseInt(split[0]);
		int edgeCount = Integer.parseInt(split[1]);

		int count = 0;

		graph = new ArrayList[nodeCount + 1];
		isVisit = new boolean[nodeCount + 1];

		for (int i = 1; i < nodeCount + 1; i++) {
			graph[i] = new ArrayList<>();
			isVisit[i] = false;
		}

		for (int i = 0; i < edgeCount; i++) {
			String[] data = br.readLine().split(" ");
			int nodeA = Integer.parseInt(data[0]);
			int nodeB = Integer.parseInt(data[1]);

			graph[nodeA].add(nodeB);
			graph[nodeB].add(nodeA);
		}

		for (int i = 1; i < nodeCount + 1; i++) {
			if (!isVisit[i]) {
				count++;
				solve(i);
			}
		}

		System.out.println(count);

	}

	private static void solve(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		while (!queue.isEmpty()) {
			int visit = queue.remove();

			ArrayList<Integer> connection = graph[visit];

			for (Integer i : connection) {
				if (!isVisit[i]) {
					queue.add(i);
					isVisit[i] = true;
				}
			}
		}
	}


}
