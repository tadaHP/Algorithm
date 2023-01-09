package SandBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapSand {
    static String[] genres1 = {"a", "b", "c", "d", "e"};
    static int[] plays1 = {500, 600, 150, 800, 2500};
    public static void main(String[] args) {

        Map<String, Integer> temp = new HashMap<>();

        for (int i = 0; i < genres1.length; i++) {
            temp.put(genres1[i], plays1[i]);
        }



        String o1 = "a";

        String o2 = "b";

        int i = temp.get(o2).compareTo(temp.get(o1));

        System.out.println("i = " + i);

        ArrayList<String> strings = new ArrayList<>(temp.keySet());
        System.out.println("raw string = " + strings);

        Collections.sort(strings, (object1, object2) -> (temp.get(object2).compareTo(temp.get(object1))));

        System.out.println("after string = " + strings);


    }



}
