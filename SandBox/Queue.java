package SandBox;

import java.util.LinkedList;

public class Queue {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");

        for (String s : queue) {
            System.out.print(s + " ");
        }
        System.out.println();

        queue.removeLast();
        for (String s : queue) {
            System.out.print(s + " ");
        }

    }
}

