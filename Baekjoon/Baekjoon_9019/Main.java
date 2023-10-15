package Baekjoon.Baekjoon_9019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		for (int i = 0; i < size; i++) {
			String[] split = br.readLine().split(" ");
			int numA = Integer.parseInt(split[0]);
			int numB = Integer.parseInt(split[1]);
			sb.append(solve(numA, numB)).append("\n");
		}
		System.out.println(sb);
	}

	private static String solve(int numA, int target) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] isVisit = new boolean[10000];
		String[] commands = new String[10000];

		queue.add(numA);
		isVisit[numA] = true;
		commands[numA] = "";

		while (!queue.isEmpty() && !isVisit[target]) {
			int now = queue.remove();

			int d = functionD(now);
			int s = functionS(now);
			int l = functionL(now);
			int r = functionR(now);

			if (!isVisit[d]) {
				queue.add(d);
				isVisit[d] = true;
				commands[d] = commands[now] + "D";
			}
			if (!isVisit[s]) {
				queue.add(s);
				isVisit[s] = true;
				commands[s] = commands[now] + "S";
			}
			if (!isVisit[l]) {
				queue.add(l);
				isVisit[l] = true;
				commands[l] = commands[now] + "L";
			}
			if (!isVisit[r]) {
				queue.add(r);
				isVisit[r] = true;
				commands[r] = commands[now] + "R";
			}

		}

		return commands[target];
	}

	private static int functionD(int num) {
		return (num * 2) % 10000;
	}

	private static int functionS(int num) {
		return num == 0 ? 9999 : num - 1;
	}

	private static int functionL(int num) {
		return ((num % 1000) * 10) + (num / 1000);
	}

	private static int functionR(int num) {
		return (num / 10) + ((num % 10) * 1000);
	}

}
