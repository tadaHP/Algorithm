package Baekjoon.Baekjoon_16953;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long answer = -1;

		String[] split = br.readLine().split(" ");
		int startPoint = Integer.parseInt(split[0]);
		int target = Integer.parseInt(split[1]);

		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(startPoint, 1));

		while (!queue.isEmpty()) {
			Info visit = queue.remove();
			long now = visit.now;
			int count = visit.count;

			if (now == target) {
				answer = count;
				break;
			}

			long makeDouble = now * 2;
			long addNumber = now * 10 + 1;

			if (makeDouble <= target) {
				queue.add(new Info(makeDouble, count + 1));
			}

			if (addNumber <= target) {
				queue.add(new Info(addNumber, count + 1));
			}

		}

		System.out.println(answer);

	}

	static class Info {
		private final long now;
		private final int count;

		public Info(long now, int count) {
			this.now = now;
			this.count = count;
		}
	}

}
