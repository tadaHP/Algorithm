package Baekjoon.Baekjoon_1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		if (n == k) {
			System.out.println(0);
		} else {
			System.out.println(bfs(n, k));
		}

	}

	private static int bfs(int start, int target) {
		int[] visitList = new int[100000 + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visitList[start] = 1;

		while (!queue.isEmpty()) {
			int value = queue.remove();

			for (int i = 0; i < 3; i++) {
				int visit;
				if (i == 0) {
					visit = value + 1;
				} else if (i == 1) {
					visit = value - 1;
				} else {
					visit = value * 2;
				}

				if (visit == target) {
					return visitList[value];
				}

				if (visit >= 0 && visit < visitList.length && visitList[visit] == 0) {
					queue.add(visit);
					visitList[visit] = visitList[value] + 1;
				}
			}
		}
		return -1;
	}
}
