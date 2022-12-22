package Programmers.Programmers_42583;

import java.util.LinkedList;
import java.util.Queue;


public class Answer {




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
        //weight 상관없이 최소 이동시간 + load 로 인한 지연시간만큼 더하기

        Queue<Integer> waitingQueue = new LinkedList<>();
        for(int i : truck_weights) {//add everyData in Queue
            waitingQueue.offer(i);
        }


        int time = bridge_length;//set time to Bridge Length


        Queue<Integer> runningQueue = new LinkedList<>();//tempQ in checking Truck which on Bridge
        int bridgeWeight = 0;//load in bridge


        while (!waitingQueue.isEmpty()) {
            int queuePoll = 0;
            if(runningQueue.isEmpty()) {//there is no Truck on bridge
                queuePoll = waitingQueue.poll();//
                runningQueue.offer(queuePoll); //move data in queue to tempQ
                bridgeWeight += queuePoll;//add bridgeLoad
            } else {
                if(runningQueue.size() == bridge_length) {//if car arrived
                    bridgeWeight -= runningQueue.poll();//remove truck
                }
                if(weight >= bridgeWeight + waitingQueue.peek()) {//if not overload
                    queuePoll = waitingQueue.poll();//add data in tempQ(bridge)and add bridgeLoad
                    runningQueue.offer(queuePoll);
                    bridgeWeight += queuePoll;
                } else {//if overload
                    if(bridgeWeight > weight) {
                        bridgeWeight -= runningQueue.poll();
                    } else {//if overload then add 0 length
                        runningQueue.offer(0);
                    }
                }
            }
            time++;
        }

        System.out.println(time);

    }

}
