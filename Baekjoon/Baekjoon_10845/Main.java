package Baekjoon.Baekjoon_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<String> queue = new LinkedList<>();
		String lastVal = null;


		for (int i = 0; i < size; i++) {
			String[] split = br.readLine().split(" ");
			if (split[0].equals("push")) {
				queue.add(split[1]);
				lastVal = split[1];
			} else if (split[0].equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (split[0].equals("empty")) {
				if (queue.isEmpty()) {
					sb.append("1").append("\n");
				}else{
					sb.append("0").append("\n");
				}
			} else if (split[0].equals("front")) {
				if (queue.isEmpty()) {
					sb.append("-1").append("\n");
				}else{
					sb.append(queue.peek()).append("\n");
				}
			} else if (split[0].equals("back")) {
				if (queue.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(lastVal).append("\n");
				}
			} else if (split[0].equals("pop")) {
				if (queue.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			}
		}

		System.out.println(sb);

	}
}
