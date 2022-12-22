package Programmers.Programmers_42583;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

//    static int bridge_length = 100;
//    static int weight = 100;
//    static int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
    //return 110

//    static int bridge_length = 100;
//    static int weight = 100;
//    static int[] truck_weights = {10};
    //return 101

    static int bridge_length = 5;
    static int weight = 5;
    static int[] truck_weights = {2, 2, 2, 2, 1, 1, 1, 1, 1};
    //return 19

//    static int bridge_length = 2;
//    static int weight = 10;
//    static int[] truck_weights = {7,4,5,6};
//    //return 8


    public static void main(String[] args) {

        Queue<Integer> waitingQueue = new LinkedList<>();

        Queue<Integer> crossingQueue = new LinkedList<>();

        int answer = bridge_length;//add bridge length, it means if truck is on  crossingQueue, it's arrive.
        int bridgeLoad = 0;
        int temp = 0;

        for (int i : truck_weights) {//line up the trucks
            waitingQueue.add(i);
        }
        System.out.println(waitingQueue.size());

        while (!waitingQueue.isEmpty()) {

            if (crossingQueue.isEmpty()) {//first condition
                temp = waitingQueue.remove();
                crossingQueue.add(temp);
                bridgeLoad += temp;
            } else {
                //it is not first condition
                if (bridge_length == crossingQueue.size()) {//if first truck arrived and another arrived too
                    bridgeLoad -= crossingQueue.remove();//remove bridgeLoad
                }
                if (weight >= bridgeLoad + waitingQueue.peek()) {//not overLoad
                    temp = waitingQueue.remove();
                    crossingQueue.add(temp);
                    bridgeLoad += temp;
                } else{//overLoad
                    crossingQueue.add(0);
                }
            }
            answer++;
        }
        System.out.println("answer: " + answer);
    }
}
