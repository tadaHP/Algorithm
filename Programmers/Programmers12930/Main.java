package Programmers.Programmers12930;

public class Main {
	public static void main(String[] args) {
		String s = "  TRy HElLo  WORLD ";
		System.out.println(solution(s));
	}
	public static String solution(String s) {
		StringBuilder answer = new StringBuilder();
		String lowerString = s.toLowerCase();
		String upperString = s.toUpperCase();
		String[] lowerSplit = lowerString.split("");
		String[] upperSplit = upperString.split("");

		boolean isUpper = true;

		for (int i = 0; i < lowerSplit.length; i++) {
			if (isUpper) {
				answer.append(upperSplit[i]);
			} else {
				answer.append(lowerSplit[i]);
			}
			isUpper = !isUpper;
			if (lowerSplit[i].equals(" ")) {
				isUpper = true;
			}
		}
		return answer.toString();
	}
}
