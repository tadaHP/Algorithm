package Baekjoon.Baekjoon_11651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			String[] split = br.readLine().split(" ");
			list.add(new Point(split[0], split[1]));
		}
		list.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o2.y - o1.y == 0) {
					return o1.x - o2.x;
				}
				return o1.y - o2.y;
			}
		});

		for (Point point : list) {
			sb.append(point.toString());
		}

		System.out.println(sb);

	}

	static class Point {
		private int x;
		private int y;

		public Point(String x, String y) {
			this.x =Integer.parseInt(x);
			this.y = Integer.parseInt(y);
		}

		@Override
		public String toString() {
			return x + " " + y + "\n";
		}
	}
}
