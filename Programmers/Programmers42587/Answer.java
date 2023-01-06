package Programmers.Programmers42587;

import java.util.HashMap;

public class Answer {
    static String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

    static String[][] tempType = {{"yellow_hat", "a"}, {"blue_sunglasses", "a"}, {"green_turban", "a"}, {"adf", "b"}, {"adef", "b"},};
    public static void main(String[] args) {
        System.out.println(solution(clothes1));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        // keySet() : key 값만 출력
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        answer -= 1;
        return answer;
    }
}
