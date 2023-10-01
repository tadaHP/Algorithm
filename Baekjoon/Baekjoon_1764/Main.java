package Baekjoon.Baekjoon_1764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] split = br.readLine().split(" ");

		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);

		HashSet<String> aSet = new HashSet<>();
		HashSet<String> bSet = new HashSet<>();
		LinkedList<String> duplicatedList = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			aSet.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			bSet.add(br.readLine());
		}

		for (String s : aSet) {
			if (bSet.contains(s)) {
				duplicatedList.add(s);
			}
		}
		sb.append(duplicatedList.size()).append("\n");

		duplicatedList.sort(Comparator.naturalOrder());
		for (String s : duplicatedList) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);

	}
}
