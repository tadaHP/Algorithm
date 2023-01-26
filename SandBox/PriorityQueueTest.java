package SandBox;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int temp;
        for (int i = 0; i < 2; i++) {
            temp = (int) (Math.random() * 100000) % 100;
            temp++;
            System.out.print(temp+", ");
            priorityQueue.add(temp);
        }
        System.out.println();
        System.out.println("----------------");

//        for (Integer integer : priorityQueue) {
//            System.out.println(integer);
//        }

        System.out.println(priorityQueue.size());

    }
}
