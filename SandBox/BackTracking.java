package SandBox;

public class BackTracking {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

        combination(arr, visited, 0, n, 2);
    }

    static void combination(int[] arr, boolean[] visited, int start, int end, int r) {
        if (r == 0) {
//            print(arr,visited,end);
            for (int i = 0; i < end; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < end; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, end, r - 1);
            visited[i] = false;
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
