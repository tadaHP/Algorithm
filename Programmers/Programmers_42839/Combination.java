package Programmers.Programmers_42839;

public class Combination {
    static void combination(int[] arr, boolean[] visited, int start, int size, int  length) {
        if (length == 0) {
            print(arr, visited, size);
            return;
        }
        for (int i = start; i < size; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, size, length - 1);
            visited[i] = false;
            
        }
    }

    static void print(int[] arr, boolean[] visited, int size) {
        for (int i = 0; i < size; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}

// https://bcp0109.tistory.com/15