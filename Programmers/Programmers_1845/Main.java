package Programmers.Programmers_1845;

import java.util.HashSet;

public class Main {

        static int[] nums = {3, 1, 2, 3}; //answer 2
//    int[] nums = {3, 3, 3, 2, 2, 4}; //answer 3
//    int[] nums = {3,3,3,2,2,2}; //answer 2
//    static int[] nums = {1, 2, 3, 4, 5, 6}; // answer 3


    public static void main(String[] args) {

        int answer = 0;
        int halfSize = nums.length / 2;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int temp : nums) {
            hashSet.add(temp);
        }

        if (hashSet.size() > halfSize) {
            answer = halfSize;
        } else {
            answer = hashSet.size();
        }

        System.out.println(answer);








    }
}
