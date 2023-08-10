package SandBox;

public class PowerSet {
	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		boolean[] isVisited = new boolean[3];

		for (int i = 0; i <= 3; i++) {
			combinationBacktracking(array, isVisited, 0, 3, i);
		}
		for (int i = 0; i <= 3; i++) {
			combinationRecursion(array, isVisited, 0, 3, i);
		}
	}

	public static void combinationBacktracking(int[] array, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					System.out.print(array[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combinationBacktracking(array, visited, i + 1, n, r - 1);
			visited[i] = false;
		}

	}

	public static void combinationRecursion(int[] array, boolean[] visited, int depth, int n, int r) {
		if (r == 0) {
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					System.out.print(array[i] + " ");
				}
			}
			return;
		}
		if (depth == 0) {
			return;
		}

		visited[depth] = true;
		combinationRecursion(array, visited, depth + 1, n, r - 1);

		visited[depth] = false;
		combinationRecursion(array, visited, depth + 1, n, r);
	}
}
