package Baekjoon.Baekjoon_11286;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int absO1 = Math.abs(o1);
				int absO2 = Math.abs(o2);

				if (absO1 == absO2) {
					return o1 - o2;
				}
				return absO1 - absO2;
			}
		});

		int size = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++) {
			int data = Integer.parseInt(br.readLine());
			if (data == 0) {
				if (queue.isEmpty()) {
					sb.append(0).append("\n");
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
