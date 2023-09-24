package Baekjoon.Baekjoon_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static StringBuilder sb;
	private static boolean[] isVisited;
	private static boolean[][] nodesList;

	private static int nodeCount;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] split = br.readLine().split(" ");
		nodeCount = Integer.parseInt(split[0]);
		int edgeCount = Integer.parseInt(split[1]);
		int startPoint = Integer.parseInt(split[2]);
		nodesList = new boolean[nodeCount + 1][nodeCount + 1];

		for (int i = 0; i < edgeCount; i++) {
			String[] data = br.readLine().split(" ");
			nodesList[Integer.parseInt(data[0])][Integer.parseInt(data[1])] =true;
			nodesList[Integer.parseInt(data[1])][Integer.parseInt(data[0])] =true;
		}

		isVisited = new boolean[nodeCount + 1];
		bfs(startPoint, 0);

		sb.append("\n");

		isVisited = new boolean[nodeCount + 1];
		dfs(startPoint);

		System.out.println(sb);


	}

	public static void bfs(int visit, int count) {
		if (count == nodeCount - 1) {
			return;
		}
		isVisited[visit] = true;
		sb.append(visit).append(" ");

		for (int i = 1; i < nodeCount + 1; i++) {
			if (nodesList[visit][i] && !isVisited[i]) {
				bfs(i, count++);
			}
		}
	}

	public static void dfs(int visit) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(visit);
		isVisited[visit] = true;
		sb.append(visit).append(" ");

		while (!queue.isEmpty()) {
			Integer remove = queue.remove();
			for (int i = 1; i < nodeCount + 1; i++) {
				if (nodesList[remove][i] && !isVisited[i]) {
					queue.add(i);
					isVisited[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
	}
}
