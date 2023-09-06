package Baekjoon.Baekjoon_11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		Queue<Integer> queue = new LinkedList<>();

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		for (int i = 0; i < n; i++) {
			queue.add(i + 1);
		}

		sb.append("<");

		while (queue.size() != 1) {
			for (int i = 1; i < k; i++) {
				queue.add(queue.remove());
			}
			sb.append(queue.remove()).append(", ");

		}
		sb.append(queue.remove()).append(">");

		System.out.println(sb);

	}
}
