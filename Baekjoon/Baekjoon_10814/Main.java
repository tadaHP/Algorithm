package Baekjoon.Baekjoon_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		LinkedList<User> users = new LinkedList<>();

		for (int i = 0; i <size; i++) {
			String[] readline = br.readLine().split(" ");
			int age = Integer.parseInt(readline[0]);
			String name = readline[1];
			users.add(new User(age, name));
		}

		users.sort(new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				return u1.age - u2.age;
			}
		});
		StringBuilder sb = new StringBuilder();

		for (User user : users) {
			sb.append(user.toString());
		}
		System.out.println(sb);
	}

	public static class User{
		int age;

		String name;

		public User(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}
