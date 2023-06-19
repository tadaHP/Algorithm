package Programmers.Programmers120889;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] sides1 = {1, 2, 3};
		int[] sides2 = {3, 6, 2};
		int[] sides3 = {199, 72, 222};
		System.out.println(solution(sides3));
	}

	public static int solution(int[] sides) {
		int others = 0;
		Arrays.sort(sides);
		int biggestVal = sides[sides.length - 1];
		for (int i = 0; i < sides.length - 1; i++) {
			others += sides[i];
		}

		if (others > biggestVal) {
			return 1;
		} else {
			return 2;
		}
	}
}
