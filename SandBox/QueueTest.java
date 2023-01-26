package SandBox;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(7);

        for (Integer integer : queue) {
            System.out.print(integer +", ");
        }
        System.out.println();

        queue.remove();

        for (Integer integer : queue) {
            System.out.print(integer +", ");
        }
        System.out.println();

        queue.add(1);
        queue.add(5);

        for (Integer integer : queue) {
            System.out.print(integer +", ");
        }
        System.out.println();

    }
}

