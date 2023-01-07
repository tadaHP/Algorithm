package Programmers.Programmers42578;

import java.util.HashMap;

public class Main {
    static String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

    static String[][] tempType = {{"yellow_hat", "a"}, {"blue_sunglasses", "a"}, {"green_turban", "a"}, {"adf", "b"}, {"adef", "b"},};

    public static void main(String[] args) {
//       Solution(clothes1);
        System.out.println(Solution(clothes1));
    }

    public static int Solution(String[][] clothes) {// 0-> clothes, 1-> whereToWear
        int answer = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();
        int[] arr;
        int temp = 0;
        for (String[] clothe : clothes) {
            hashMap.put(clothe[1], hashMap.getOrDefault(clothe[1],0)+1);
        }

        arr = new int[hashMap.size()];

        for (Integer value : hashMap.values()) {
            arr[temp] = value;
            temp++;
        }

        for (int i = 1; i < arr.length+1; i++) {
            answer += backTracking(arr, new boolean[arr.length], 0, arr.length, i, i);
        }



        return answer;
    }
    public static int backTracking(int[] arr,boolean[] visited,int start, int end, int round, int size) {
        int returnValue = 0;
        if (round == 0) {
            returnValue = 1;
            int[] cal = new int[size];
            int calValue = 0;
            for (int i = 0; i < end; i++) {
                if (visited[i]) {
                    cal[calValue] = arr[i];
                    calValue++;
                }
            }
            for (int i : cal) {
                returnValue *= i;
            }
            return returnValue;

        }
        for (int i = start; i < end; i++) {
            visited[i] = true;
            returnValue += backTracking(arr, visited, i + 1, end, round - 1, size);
            visited[i] = false;
        }
        return returnValue;
    }
}
