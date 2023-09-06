package Baekjoon.Baekjoon_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static StringBuilder stringBuilder;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		stringBuilder = new StringBuilder();

		for (int i = 0; i < size; i++) {
			solve(br);
		}

		System.out.println(stringBuilder);

	}

	private static void solve(BufferedReader br) throws IOException {
		Queue<PrintInfo> queue = new LinkedList<>();
		int outPosition = -1;
		int count = 0;

		String[] question = br.readLine().split(" ");
		int documentSize = Integer.parseInt(question[0]);
		int requestDocument = Integer.parseInt(question[1]);

		String[] data = br.readLine().split(" ");

		for (int i = 0; i < documentSize; i++) {
			queue.add(new PrintInfo(i, Integer.parseInt(data[i])));
		}

		while (outPosition != requestDocument) {
			int priority = queue.peek().getPriority();
			for (PrintInfo printInfo : queue) {
				if (priority < printInfo.getPriority()) {
					priority = printInfo.getPriority();
				}
			}

			if (priority == queue.peek().getPriority()) {
				outPosition = queue.remove().getPosition();
				count++;
			} else {
				queue.add(queue.remove());
			}

		}

		stringBuilder.append(count).append("\n");

	}

	private static class PrintInfo {
		private int position;
		private int priority;

		public PrintInfo(int position, int priority) {
			this.position = position;
			this.priority = priority;
		}

		public int getPosition() {
			return position;
		}

		public int getPriority() {
			return priority;
		}
	}


}
