package Baekjoon.Baekjoon_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> intArray = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			intArray.add(i + 1);
		}

		int calculate = calculate(intArray);
		System.out.println(calculate);

	}

	private static int calculate(Queue<Integer> list) {

		if (list.size() == 1) {
			return list.remove();
		}
		list.remove();


		int temp = list.remove();
		list.add(temp);

		return calculate(list);

	}

}
