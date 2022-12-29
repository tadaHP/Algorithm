package SandBox;

import java.util.HashMap;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        HashMap<Integer, String> temp = new HashMap<>();


        temp.put(1, "test");
        temp.put(2, "test1");
        temp.put(3, "test2");

        Set<Integer> keySet = temp.keySet();

        for (int i : keySet) {
            System.out.println(i);
        }


    }
}
