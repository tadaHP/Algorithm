package Programmers.Programmers_42576;

import java.util.HashMap;
import java.util.Set;

public class Main {

//    static String[] participant = {"leo", "kiki", "eden"};
//    static String[] completion = {"eden", "kiki"};
    //leo

    //    static String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"}
//    static String[] completion = {"josipa", "filipa", "marina", "nikola"};
    //vinko

    static String[] participant = {"mislav", "stanko", "mislav", "ana","mislav"};
    static String[] completion = {"stanko", "ana", "mislav","mislav"};



    public static void main(String[] args) {

        String answer = "";
        HashMap<String, Integer> participantHashMap = new HashMap<>();


        for (String temp : participant) {
            participantHashMap.put(temp, participantHashMap.getOrDefault(temp, 0) + 1);
        }



        for (String temp : completion) {
            participantHashMap.replace(temp, participantHashMap.get(temp) - 1);
        }

        Set<String> stringSet = participantHashMap.keySet();

        for (String i : stringSet) {
            if (participantHashMap.get(i) > 0) {
                answer = i;
            }
        }


        System.out.println(answer);

    }
}
