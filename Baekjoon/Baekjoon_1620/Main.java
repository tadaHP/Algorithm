package Baekjoon.Baekjoon_1620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, String> a = new HashMap<>();
		Map<String, Integer> b = new HashMap<>();

		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);

		for (int i = 0; i < n; i++) {
			String value = br.readLine();
			a.put(i + 1, value);
			b.put(value, i + 1);
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			boolean isNumber = false;
			int v = 0;
			try {
				v = Integer.parseInt(s);
				isNumber = true;
			} catch (Exception e) {
			}
			if (isNumber) {
				sb.append(a.get(v));
			} else {
				Integer i1 = b.get(s);
				sb.append(i1);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
