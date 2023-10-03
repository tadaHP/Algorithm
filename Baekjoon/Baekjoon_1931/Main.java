package Baekjoon.Baekjoon_1931;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		ArrayList<TimeTable> meetings = new ArrayList<>();
		int count = 0;
		int lastTime = 0;

		for (int i = 0; i < size; i++) {
			meetings.add(new TimeTable(br.readLine()));
		}
		meetings.sort(new Comparator<TimeTable>() {
			@Override
			public int compare(TimeTable o1, TimeTable o2) {
				if (o1.end == o2.end) {
					return o1.start - o2.start;
				}
				return o1.end - o2.end;
			}
		});

		for (TimeTable meeting : meetings) {
			if (lastTime <= meeting.getStart()) {
				lastTime = meeting.getEnd();
				count++;
			}
		}
		System.out.println(count);
	}

	private static class TimeTable {
		private final int start;
		private final int end;

		public TimeTable(String times) {
			String[] split = times.split(" ");
			this.start = Integer.parseInt(split[0]);
			this.end = Integer.parseInt(split[1]);
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}
	}
}
