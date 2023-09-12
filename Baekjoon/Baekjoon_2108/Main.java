package Baekjoon.Baekjoon_2108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
	static int size;
	static int[] values;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		size = Integer.parseInt(br.readLine());
		values = new int[size];

		for (int i = 0; i < size; i++) {
			values[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(values);

		sb.append(arithmeticMean()).append("\n")
			.append(centerValue()).append("\n")
			.append(mode()).append("\n")
			.append(range());

		System.out.println(sb);


	}

	private static int arithmeticMean() {
		double sum = 0;
		for (int value : values) {
			sum += value;
		}

		return (int)Math.round(sum / size);
	}

	private static int centerValue() {
		return values[size/2];
	}

	private static int mode() {
		HashMap<Integer, Integer> data = new HashMap<>();
		int max = Integer.MIN_VALUE;
		ArrayList<Integer> returnKeys = null;// = new ArrayList<>();

		for (int value : values) {
			Integer v = data.getOrDefault(value, 0);
			data.put(value, v + 1);
		}

		for (Integer key : data.keySet()) {
			Integer val = data.get(key);
			if (val == max) {
				returnKeys.add(key);
			} else if (val > max) {
				returnKeys = new ArrayList<>();
				max = val;
				returnKeys.add(key);
			}
		}

		if (returnKeys.size() == 1) {
			return returnKeys.get(0);
		}
		returnKeys.sort(Comparator.naturalOrder());

		return returnKeys.get(1);
	}

	private static int range() {
		return values[size-1] - values[0];
	}
}
