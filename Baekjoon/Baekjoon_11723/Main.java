package Baekjoon.Baekjoon_11723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private final static String ADD = "add";
	private final static String REMOVE = "remove";
	private final static String CHECK = "check";
	private final static String TOGGLE = "toggle";
	private final static String ALL = "all";
	private final static String EMPTY = "empty";

	private final static boolean[] fullSet = {true, true, true, true, true, true, true, true, true, true, true, true, true,
		true, true, true, true, true, true, true, true};

	private final static boolean[] emptySet = {false, false, false, false, false, false, false, false, false, false, false,
		false, false, false, false, false, false, false, false, false, false};
	private static boolean[] set;

	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		set = Arrays.copyOf(emptySet, emptySet.length);

		for (int i = 0; i < size; i++) {
			String data = br.readLine();
			calculate(data);
		}
		System.out.println(sb);
	}

	private static void calculate(String data) {
		String[] split = data.split(" ");
		String command = split[0];
		int num = 0;
		if (!(command.equals(ALL) || command.equals(EMPTY))) {
			num = Integer.parseInt(split[1]);
		}

		switch (command) {
			case ADD:
				set[num] = true;
				break;
			case REMOVE:
				set[num] = false;
				break;
			case CHECK:
				if (set[num]) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
				break;
			case TOGGLE:
				set[num] = !set[num];
				break;
			case ALL:
				set = Arrays.copyOf(fullSet, fullSet.length);
				break;
			case EMPTY:
				set = Arrays.copyOf(emptySet, emptySet.length);
				break;
		}


	}
}