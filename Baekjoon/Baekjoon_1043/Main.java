package Baekjoon.Baekjoon_1043;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	private static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int personCount = Integer.parseInt(split[0]);
		int partyCount = Integer.parseInt(split[1]);
		int count = 0;

		parents = new int[personCount + 1];
		boolean[] truthPeople = new boolean[personCount + 1];
		Set<Integer>[] party = new HashSet[partyCount + 1];

		for (int i = 1; i < partyCount + 1; i++) {
			party[i] = new HashSet<>();
		}
		for (int i = 1; i < personCount + 1; i++) {
			parents[i] = i;
		}


		String[] truthData = br.readLine().split(" ");
		int truthCount = Integer.parseInt(truthData[0]);
		for (int i = 1; i < truthCount + 1; i++) {
			truthPeople[Integer.parseInt(truthData[i])] = true;
		}

		for (int i = 1; i < partyCount + 1; i++) {
			String[] data = br.readLine().split(" ");
			int attendCount = Integer.parseInt(data[0]);
			if (attendCount == 1) {
				party[i].add(Integer.parseInt(data[1]));
			}
			for (int j = 1; j < attendCount; j++) {
				int now = Integer.parseInt(data[j]);
				int next = Integer.parseInt(data[j + 1]);
				int nowParent = find(now);
				int nextParent = find(next);
				if (nowParent != nextParent) {
					//excahnge
					exchange(now, next);
				}
				party[i].add(now);
				party[i].add(next);
			}
		}

		for (int i = 1; i < personCount + 1; i++) {
			if (truthPeople[i]) {
				int rootValue = find(i);
				for (int j = 1; j < personCount + 1; j++) {
					if (find(j) == rootValue) {
						truthPeople[j] = true;
					}
				}
			}
		}

		for (int i = 1; i < partyCount + 1; i++) {
			boolean isUnknown = true;
			for (int person : party[i]) {
				if (truthPeople[person]) {
					isUnknown = false;
					break;
				}
			}
			if (isUnknown) {
				count++;
			}
		}


		System.out.println(count);
	}

	private static int find(int num) {
		if (parents[num] == num) {
			return num;
		}
		return find(parents[num]);
	}

	private static void exchange(int now, int next) {
		if (parents[next] != next) {
			exchange(now, parents[next]);
		}
		parents[next] = now;
	}

}