package Baekjoon.Baekjoon_1043;

public class UnionFind {
	static int[] parent;

	// union 연산
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x == y) return false;

		if(x <= y) parent[y] = x;
		else parent[x] = y;
		return true;
	}

	// find 연산
	public static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}

	public static void main(String[] args) {
		int n = 4;
		parent = new int[n + 1];
		// 부모 노드 초기화
		for (int i = 0; i < parent.length; i++) parent[i] = i;

		//위의 예제 실행
		union(1, 2);
		union(3, 4);
		union(1, 4);

	}
}
