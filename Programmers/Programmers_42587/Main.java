package Programmers.Programmers_42587;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) {
        int[] priorities = {2,1,3,2};
        int location = 2;
        
        // int[] priorities = {1,1,9,1,1,1};
        // int location = 0;
        // int[] priorities = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        // int location = 1;

        int answer = 0;
        int temp;
        

        ////start        
        Queue<Integer> queue = new LinkedList<>();
        for(int i : priorities){
            queue.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length -1;


        while(!queue.isEmpty()){
            temp = queue.poll();

            if(Integer.compare(temp, priorities[size - answer])==0){ // print
                answer++;
                location--;
                if(location<0)  break; // answer printed
            }else{ // delay
                queue.add(temp);
                location--;
                if(location<0)
                    location = queue.size()-1;
            }
        }
        System.out.println(answer);
    }
}