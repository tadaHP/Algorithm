package Baekjoon.Baekjoon_11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		ArrayList<Coordinates> coordinates = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			String[] split = br.readLine().split(" ");
			coordinates.add(new Coordinates(split[0], split[1]));
		}

		coordinates.sort(new Comparator<Coordinates>() {
			@Override
			public int compare(Coordinates c1, Coordinates c2) {
				int xVal = c1.x - c2.x;
				if (xVal == 0) {
					return c1.y - c2.y;
				}
				return xVal;
			}
		});

		for (Coordinates coordinate : coordinates) {
			sb.append(coordinate.toString());
		}

		System.out.println(sb);
	}

	private static class Coordinates {
		private int x;
		private int y;

		public Coordinates(String x, String y) {
			this.x = Integer.parseInt(x);
			this.y = Integer.parseInt(y);
		}

		@Override
		public String toString() {
			return x + " " + y + "\n";
		}
	}

}
