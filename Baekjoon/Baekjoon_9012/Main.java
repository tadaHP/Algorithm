package Baekjoon.Baekjoon_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	private static StringBuilder sb = new StringBuilder();

	private static String yes = "YES\n";
	private static String no = "NO\n";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dataSize = Integer.parseInt(br.readLine());

		for (int i = 0; i < dataSize; i++) {
			String[] line = br.readLine().split("");
			solve(line);
		}
		System.out.println(sb);
	}

	private static void solve(String[] line) {

		Stack<String> stack = new Stack<>();

		for (String s : line) {
			if (s.equals("(")) {
				stack.push(s);
			} else if (s.equals(")")) {
				if (stack.size() == 0) {
					sb.append(no);
					return;
				}
				stack.pop();
			}
		}

		if (stack.size() == 0) {
			sb.append(yes);
		} else {
			sb.append(no);
		}
	}
}
