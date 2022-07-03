package Programmers.Programmers_42839;
public class Permutation_swap {
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }
     
        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
     
    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
//https://bcp0109.tistory.com/14