package Baekjoon.Baekjoon_10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<String> deque = new ArrayDeque<>();


		for (int i = 0; i < size; i++) {
			String[] split = br.readLine().split(" ");
			if (split[0].equals("push_front")) {
				deque.addFirst(split[1]);
			} else if (split[0].equals("push_back")) {
				deque.addLast(split[1]);
			} else if (split[0].equals("pop_front")) {
				if (deque.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(deque.remove()).append("\n");
				}
			} else if (split[0].equals("pop_back")) {
				if (deque.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(deque.removeLast()).append("\n");
				}
			} else if (split[0].equals("size")) {
				sb.append(deque.size()).append("\n");
			} else if (split[0].equals("empty")) {
				if (deque.isEmpty()) {
					sb.append("1").append("\n");
				}else{
					sb.append("0").append("\n");
				}
			} else if (split[0].equals("front")) {
				if (deque.isEmpty()) {
					sb.append("-1").append("\n");
				}else{
					sb.append(deque.getFirst()).append("\n");
				}
			} else if (split[0].equals("back")) {
				if (deque.isEmpty()) {
					sb.append("-1").append("\n");
				}else{
					sb.append(deque.getLast()).append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}
