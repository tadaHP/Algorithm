package Baekjoon.Baekjoon_10773;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();

		int sum = 0;
		int size = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++) {
			int read = Integer.parseInt(br.readLine());
			if (read == 0) {
				stack.pop();
			} else {
				stack.push(read);
			}
		}

		for (Integer i : stack) {
			sum += i;
		}

		System.out.println(sum);
	}
}
