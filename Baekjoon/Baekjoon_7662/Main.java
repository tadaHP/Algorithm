package Baekjoon.Baekjoon_7662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
	private static final String D = "D";
	private static final String I = "I";
	private static final String EMPTY = "EMPTY";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int size = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();

			for (int j = 0; j < size; j++) {
				String[] data = br.readLine().split(" ");
				int intData = Integer.parseInt(data[1]);
				switch (data[0]) {
					case D:
						int temp;
						if (treeMap.isEmpty()) {
							break;
						}
						if (intData == 1) {
							temp = treeMap.lastKey();
						} else {
							temp = treeMap.firstKey();
						}
						if (treeMap.put(temp, treeMap.get(temp) - 1) == 1) {
							treeMap.remove(temp);
						}
						break;
					case I:
						treeMap.put(intData, treeMap.getOrDefault(intData, 0) + 1);
				}
			}

			if (treeMap.isEmpty()) {
				sb.append(EMPTY).append("\n");
			} else {
				sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
