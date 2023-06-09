package Programmers.Programmers181900;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		String str1 = "apporoograpemmemprs";
		int[] indices1 = {1, 16, 6, 15, 0, 10, 11, 3};
		System.out.println(solution(str1,indices1));
	}

	public static String  solution(String my_string, int[] indices) {
		boolean[] isExcept = new boolean[my_string.length()];
		for (int index : indices) {
			isExcept[index] = true;
		}
		String[] tokenString = my_string.split("");

		StringBuilder sb = new StringBuilder();


		for (int i = 0; i < tokenString.length; i++) {
			if (!isExcept[i]) {
				sb.append(tokenString[i]);
			}
		}

		return sb.toString();
	}
}
