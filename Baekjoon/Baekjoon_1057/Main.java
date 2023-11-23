package Baekjoon.Baekjoon_1057;

import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		int participantCount = Integer.parseInt(split[0]);
		int myNumber = Integer.parseInt(split[1]);
		int competitionNumber = Integer.parseInt(split[2]);

		int count = 0;

		while (myNumber != competitionNumber) {
			count++;
			if (myNumber % 2 == 1) { //홀수
				myNumber = myNumber / 2 + 1;
			} else { //짝수
				myNumber = myNumber / 2;
			}

			if (competitionNumber % 2 == 1) {
				competitionNumber = competitionNumber / 2 + 1;
			} else {
				competitionNumber = competitionNumber / 2;
			}

		}
		System.out.println(count);
	}
}

