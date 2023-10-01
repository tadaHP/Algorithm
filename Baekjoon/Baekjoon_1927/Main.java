package Baekjoon.Baekjoon_1927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(br.readLine());
			if (value == 0) {
				if (minHeap.isEmpty()) {
					sb.append("0").append("\n");
				} else {
					sb.append(minHeap.remove()).append("\n");
				}
				continue;
			}
			minHeap.add(value);
		}

		System.out.println(sb);
	}
}
