package Baekjoon.Baekjoon_4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> map = new HashMap<>();
		map.put("(", ")");
		map.put("[", "]");
		String line = br.readLine();

		while (!line.equals(".")) {
			Stack<String> stack = new Stack<>();


			String[] split = line.split("");
			for (String s : split) {
				if (s.equals("(") || s.equals("[")) {
					stack.push(s);
				} else if (s.equals(")") || s.equals("]")) {
					if (stack.isEmpty()) {
						stack.push("1");
						break;
					}
					if (map.get(stack.peek()).equals(s)) {
						stack.pop();
					} else {
						break;
					}
				}
			}
			if (stack.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
			line = br.readLine();
		}
		System.out.println(sb);
	}
}

