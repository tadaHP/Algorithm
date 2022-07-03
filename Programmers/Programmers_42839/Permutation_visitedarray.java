package Programmers.Programmers_42839;

public class Permutation_visitedarray {
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int length) {
        if (depth == length) {
            print(output, length);
            return;
        }
     
        for (int i=0; i<arr.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, length);
                visited[i] = false;;
            }
        }
    }

    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
//https://bcp0109.tistory.com/14