package Baekjoon.Baekjoon_1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static class Node {
		int visit;
		int beforeWeightSum;

		public Node(int visit, int beforeWeightSum) {
			this.visit = visit;
			this.beforeWeightSum = beforeWeightSum;
		}
	}

	private static int[] nodeData;
	private static int[][] graph;
	private static int nodeCount;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		nodeCount = Integer.parseInt(split[0]);
		int edgeCount = Integer.parseInt(split[1]);

		graph = new int[nodeCount + 1][nodeCount + 1];
		nodeData = new int[nodeCount + 1];

		for (int i = 0; i < edgeCount; i++) {
			split = br.readLine().split(" ");
			int nodeA = Integer.parseInt(split[0]);
			int nodeB = Integer.parseInt(split[1]);
			int weight = Integer.parseInt(split[2]);
			graph[nodeA][nodeB] = weight;
			graph[nodeB][nodeA] = weight;
		}

		split = br.readLine().split(" ");
		int visitNodeA = Integer.parseInt(split[0]);
		int visitNodeB = Integer.parseInt(split[1]);

		int toA = dijkstra(1, visitNodeA, 0);
		int aToB = dijkstra(visitNodeA, visitNodeB, toA);
		int a = dijkstra(visitNodeB, nodeCount, aToB);

		int toB = dijkstra(1, visitNodeB, 0);
		int bToA = dijkstra(visitNodeB, visitNodeA, toB);
		int b = dijkstra(visitNodeA, nodeCount, bToA);

		int answer = Math.min(a, b);
		if (answer == 200000001) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static int dijkstra(int start, int end, int startWeight) {
		Arrays.fill(nodeData, 200000001);
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, startWeight));
		nodeData[start] = startWeight;

		while (!queue.isEmpty()) {
			Node visit = queue.remove();
			int visitNow = visit.visit;
			int[] data = graph[visitNow];

			for (int i = 1; i < nodeCount + 1; i++) {
				if (data[i] != 0 && nodeData[i] > nodeData[visitNow] + data[i]) {
					nodeData[i] = nodeData[visitNow] + data[i];
					queue.add(new Node(i, nodeData[i]));
				}
			}
		}
		return nodeData[end];
	}

}
