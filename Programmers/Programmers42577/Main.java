package Programmers.Programmers42577;


import java.util.HashMap;
import java.util.Map;

public class Main {
    static String[] answer1 = {"119", "97674223", "1195524421"}; //false
    static String[] answer2 = {"123","456","789"};//true
    static String[] answer3 = {"12","123","1235","567","88"};//false
    public static void main(String[] args) {
        System.out.println(new Main().Solution(answer1));
//        new Main().Solution(answer2);
    }


    public boolean Solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> hashMap = new HashMap<>();

        for (String s : phone_book) {
            hashMap.put(s, 1);
        }

        for (int i = 0; i < phone_book.length ; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hashMap.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }

        return answer;
    }

}
