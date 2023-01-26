package Programmers.Programmers42627;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    final static int[][] jobs1 = {{0, 3},{1, 9},{2, 6}};
    //answer 9

    final static int[][] jobs2 = {{7, 8},{3, 5},{8, 6}};
    //answer 8


    public static void main(String[] args) {
        System.out.println(solution(jobs2));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int size = jobs.length;
        int time = 0;

        PriorityQueue<int[]> waitList = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int val = o1[0] - o2[0];
                if (val == 0) {
                    return o1[1] - o2[1];
                } else
                    return val;
            }
        });

        PriorityQueue<int[]> processingList = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        for (int[] job : jobs) {
            waitList.add(job);
        }


        while(!(waitList.isEmpty() && processingList.isEmpty())) {//while every list is empty


            if (processingList.isEmpty()) {
                //addEclipseTime
                int timeRequest = waitList.peek()[0];//time 8
                if (timeRequest > time) { //  8> 3 진입
                    time += timeRequest - time ;
                }
            }
            //add processingList
            try {
                while (waitList.peek()[0] < time + 1) {
                    processingList.add(waitList.remove());
                }
            } catch (Exception e){

            }

//            System.out.println("ProcessingList");
//            for (int[] ints : processingList) {
//                System.out.println(ints[0] + ", " + ints[1]);
//            }

            int[] processing = processingList.remove();

            time += processing[1];

            answer += time - processing[0];

//            System.out.println("removed");
//            System.out.println(processing[0] + ", " + processing[1]);
//            System.out.println("time = " + time);
//            System.out.println("ProcessingTime = " + (time - processing[0]));
//
//            System.out.println();


        }
        answer /= size;
        return answer;
    }

}
