package Baekjoon.Baekjoon_11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		boolean[] isVisit = new boolean[size];
		int[] temp = new int[size];

		for (int i = 0; i < size; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 1; i < size; i++) {
			String[] data = br.readLine().split(" ");
			int data1 = Integer.parseInt(data[0]) - 1;
			int data2 = Integer.parseInt(data[1]) - 1;
			tree.get(data1).add(data2);
			tree.get(data2).add(data1);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		isVisit[0] = true;
		while (!queue.isEmpty()) {
			int now = queue.remove();
			ArrayList<Integer> visitNow = tree.get(now);
			for (int i : visitNow) {
				if (!isVisit[i]) {
					isVisit[i] = true;
					temp[i] = now;
					queue.add(i);
				}
			}
		}

		for (int i = 1; i < size; i++) {
			sb.append(temp[i] + 1).append("\n");
		}
		System.out.println(sb);
	}
}
