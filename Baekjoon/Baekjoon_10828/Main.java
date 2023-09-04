package Baekjoon.Baekjoon_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();

		int size = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++) {
			String[] split = br.readLine().split(" ");
			if (split[0].equals("push")) {
				stack.push(split[1]);
			} else if (split[0].equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (split[0].equals("empty")) {
				if (stack.empty()) {
					sb.append("1").append("\n");
				}else{
					sb.append("0").append("\n");
				}
			} else if (split[0].equals("top")) {
				if (stack.empty()) {
					sb.append("-1").append("\n");
				}else{
					sb.append(stack.peek()).append("\n");
				}
			} else if (split[0].equals("pop")) {
				if (stack.empty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
			}
		}

		System.out.println(sb);

	}

}
