package Programmers.Programmers_12906;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        
        int []arr = {1,1,3,3,0,1,1};
        // int []arr = {4,4,4,3,3};
        int before = -1;

        Queue<Integer> answerQueue = new LinkedList<>();

        for(int i : arr){
            if(before != i ){
                answerQueue.add(i);
            }
            before = i;
        }

        int [] answer = answerQueue.stream().mapToInt(i -> i).toArray();

        for(int i : answer)
            System.out.println(i);

    }

}
