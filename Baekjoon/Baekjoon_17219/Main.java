package Baekjoon.Baekjoon_17219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] counts = br.readLine().split(" ");
		int dataSize = Integer.parseInt(counts[0]);
		int askSize = Integer.parseInt(counts[1]);
		Map<String, String> values = new HashMap<>();

		for (int i = 0; i < dataSize; i++) {
			String[] data = br.readLine().split(" ");
			values.put(data[0], data[1]);
		}

		for (int i = 0; i < askSize; i++) {
			sb.append(values.get(br.readLine())).append("\n");
		}
		System.out.println(sb);
	}
}
