package Baekjoon.Baekjoon_5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testSize = Integer.parseInt(br.readLine());

		for (int i = 0; i < testSize; i++) {
			String[] command = br.readLine().split("");
			boolean isNaturalOrder = true;
			boolean isError = false;
			int dataSize = Integer.parseInt(br.readLine());
			Deque<String> deque = convertDataToDeque(br.readLine(), dataSize);


			for (String c : command) {
				if (c.equals("R")) {
					isNaturalOrder = !isNaturalOrder;
				} else {
					if (deque.isEmpty()) {
						sb.append("error").append("\n");
						isError = true;
						break;
					}
					if (isNaturalOrder) {
						deque.removeFirst();
					} else {
						deque.removeLast();
					}
				}
			}
			if (!isError) {
				sb.append("[").append(convertDequeToAnswer(deque, isNaturalOrder)).append("]").append("\n");
			}
		}

		System.out.println(sb);
	}

	private static String convertDequeToAnswer(Deque<String> deque, boolean isNaturalOrder) {
		StringBuilder sb = new StringBuilder();
		if (isNaturalOrder) {
			while (!deque.isEmpty()) {
				sb.append(deque.removeFirst()).append(",");
			}
		} else {
			while (!deque.isEmpty()) {
				sb.append(deque.removeLast()).append(",");
			}
		}

		String answerString = sb.toString();
		if (answerString.isEmpty()) {
			return answerString;
		}
		return answerString.substring(0, answerString.length() - 1);
	}

	private static Deque<String> convertDataToDeque(String data, int dataSize) {
		String removeBracket = data.substring(1, data.length() - 1);
		String[] splitData = removeBracket.split(",");
		Deque<String> deque = new ArrayDeque<>();
		for (int i = 0; i < dataSize; i++) {
			deque.add(splitData[i]);
		}
		return deque;
	}
}
