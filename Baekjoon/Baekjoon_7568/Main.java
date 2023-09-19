package Baekjoon.Baekjoon_7568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());

		ArrayList<Man> men = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			String[] split = br.readLine().split(" ");
			men.add(new Man(split[0], split[1]));
		}

		for (int i = 0; i < size - 1; i++) {
			for (int j = i; j < size; j++) {
				Man manA = men.get(i);
				int x = manA.getWeight();
				int y = manA.getHeight();
				Man manB = men.get(j);
				int p = manB.getWeight();
				int q = manB.getHeight();

				if (x > p && y > q) {
					manB.addRank();
				} else if (p > x && q > y) {
					manA.addRank();
				}
			}
		}

		for (Man man : men) {
			sb.append(man.getRank()).append(" ");
		}

		System.out.println(sb);

	}

	static class Man {

		private int height;
		private int weight;
		private int rank;
		public Man(String height, String weight) {
			this.height = Integer.parseInt(height);
			this.weight = Integer.parseInt(weight);
			this.rank = 1;
		}

		public int getHeight() {
			return height;
		}

		public int getWeight() {
			return weight;
		}

		public int getRank() {
			return rank;
		}

		public void addRank() {
			rank++;
		}

	}
}
