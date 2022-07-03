package Programmers.Programmers_42839;
public class Permutation_swap {
    static void permutation(int[] arr, int depth, int size, int length) {
        if (depth == length) {
            print(arr, length);
            return;
        }
     
        for (int i=depth; i<size; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, size, length);
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