package Baekjoon.Baekjoon_18870;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		int[] data = new int[size];

		String[] stringData = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			data[i] = Integer.parseInt(stringData[i]);
		}
		int[] copyData = Arrays.copyOf(data, data.length);
		Arrays.sort(copyData);
		Map<Integer, Integer> rankMap = new HashMap<>();

		int count = 0;
		for (int i = 0; i < size; i++) {
			if (!rankMap.containsKey(copyData[i])) {
				rankMap.put(copyData[i], count++);
			}
		}

		for (int i = 0; i < size; i++) {
			sb.append(rankMap.get(data[i])).append(" ");
		}

		System.out.println(sb);

	}
}
