package Baekjoon.Baekjoon_9375;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			int wearSize = Integer.parseInt(br.readLine());
			Map<String, Integer> item = new HashMap<>();
			for (int j = 0; j < wearSize; j++) {
				String[] data = br.readLine().split(" ");
				item.put(data[1], item.getOrDefault(data[1], 0) + 1);
			}
			int multiply = 1;
			for (Integer value : item.values()) {
				multiply *= value + 1;
			}

			sb.append(multiply - 1).append("\n");
		}
		System.out.println(sb);
	}
}