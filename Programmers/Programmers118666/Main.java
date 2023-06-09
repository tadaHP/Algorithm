package Programmers.Programmers118666;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		// String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
		// int[] choice1 = {5, 3, 2, 7, 5};
		String[] survey1 = {"TR", "RT", "TR"};
		int[] choice1 = {7, 1, 3};
		//TCMA

		solution(survey1,choice1);
	}
	public static void solution(String[] survey, int[] choices) {
		String answer = "";
		int[] indicators = new int[8];
		//RTCFJMAN

		StringBuilder sb = new StringBuilder();

		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("R", 0);
		hashMap.put("T", 1);
		hashMap.put("C", 2);
		hashMap.put("F", 3);
		hashMap.put("J", 4);
		hashMap.put("M", 5);
		hashMap.put("A", 6);
		hashMap.put("N", 7);

		for (int i = 0; i < survey.length; i++) {
			String[] split = survey[i].split("");
			int choice = choices[i];

			if (choice < 4) {
				indicators[hashMap.get(split[0])] += 4 - choices[i];
			} else if (choice > 4) {
				indicators[hashMap.get(split[1])] += choices[i] - 4;
			}
			System.out.println();
		}

		for (int indicator : indicators) {
			System.out.println(indicator);
		}


		if (indicators[0] - indicators[1] >= 0) {
			sb.append("R");
		} else {
			sb.append("T");
		}
		if (indicators[2] - indicators[3] >= 0) {
			sb.append("C");
		} else {
			sb.append("F");
		}
		if (indicators[4] - indicators[5] >= 0) {
			sb.append("J");
		} else {

			sb.append("M");
		}
		if (indicators[6] - indicators[7] >= 0) {
			sb.append("A");
		} else {
			sb.append("N");
		}

		System.out.println(sb.toString());

	}
}
