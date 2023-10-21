package Baekjoon.Baekjoon_11279;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

		int size = Integer.parseInt(br.readLine());
		for (int i = 0; i < size; i++) {
			int data = Integer.parseInt(br.readLine());
			if (data == 0) {
				if (queue.isEmpty()) {
					sb.append("0").append("\n");
				} else {
					sb.append(queue.remove()).append("\n");
				}
			} else {
				queue.add(data);
			}
		}
		System.out.println(sb);
	}
}
