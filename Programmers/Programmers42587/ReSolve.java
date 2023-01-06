package Programmers.Programmers42587;

import java.util.HashMap;

public class ReSolve {
    static String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

    static String[][] tempType = {{"yellow_hat", "a"}, {"blue_sunglasses", "a"}, {"green_turban", "a"}, {"adf", "b"}, {"adef", "b"},};

    public static void main(String[] args) {
        System.out.println(Solution(clothes1));
    }

    static int Solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] clothe : clothes) {
            hashMap.put(clothe[1], hashMap.getOrDefault(clothe[1],0)+1);
        }

        for (String s : hashMap.keySet()) {
            answer *= (hashMap.get(s) + 1);
        }

        answer -= 1;

        return answer;
    }
}
