package Baekjoon.Baekjoon_1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int visit;
	int weight;

	public Node(int visit, int weight) {
		this.visit = visit;
		this.weight = weight;
	}

	@Override
	public int compareTo( Node o) {
		return weight - o.weight;
	}
}


public class Main {
	private static int[][] graph;
	private static int cityCount;
	private static int[] minDistance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		cityCount = Integer.parseInt(br.readLine());
		int busCount = Integer.parseInt(br.readLine());

		graph = new int[cityCount + 1][cityCount + 1];

		minDistance = new int[cityCount + 1];

		for (int i = 1; i < cityCount + 1; i++) {
			minDistance[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < cityCount + 1; i++) {
			for (int j = 0; j < cityCount + 1; j++) {
				graph[i][j] = 100001;
			}
		}

		for (int i = 0; i < busCount; i++) {
			String[] split = br.readLine().split(" ");
			int startCity = Integer.parseInt(split[0]);
			int targetCity = Integer.parseInt(split[1]);
			int cost = Integer.parseInt(split[2]);
			graph[startCity][targetCity] = Math.min(cost, graph[startCity][targetCity]);
		}

		String[] split = br.readLine().split(" ");
		int start = Integer.parseInt(split[0]);
		int end = Integer.parseInt(split[1]);

		System.out.println(dijkstra(start, end));
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Node(start, 0));
		minDistance[start] = 0;

		while (!priorityQueue.isEmpty()) {
			Node visit = priorityQueue.remove();
			int now = visit.visit;
			int[] data = graph[now];

			for (int i = 1; i < cityCount + 1; i++) {
				if (data[i] != 100001 && minDistance[i] > minDistance[now] + data[i]) {
					minDistance[i] = minDistance[now] + data[i];
					priorityQueue.add(new Node(i, minDistance[i]));
				}
			}


		}
		return minDistance[end];
	}
}
