package Programmers.Programmers84512;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("AAAE"));
    }


    public static int solution(String word) {
        int answer = word.length();

        int[] digit = {781, 156, 31, 6, 1};

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);

        for (int i = 0; i < word.length(); i++) {

            answer += (map.get(word.charAt(i))) * digit[i];

        }


        return answer;
    }

}

