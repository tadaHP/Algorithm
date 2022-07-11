package Programmers.Programmers_42587;

import java.lang.reflect.Array;
import java.lang.Object;

public class Main{
    public static void main(String[] args) {
        int[] priorities = {2,1,3,2};
        int location = 2;
        
        // int[] priorities = {1,1,9,1,1,1};
        // int location = 0;
        int temp;
        boolean isBig = false;

        System.out.println("start");
        while(true){
            isBig = false;
            temp = priorities[0];
            for(int i = 1 ;i<priorities.length ; i++){
                if(priorities[i]>temp) isBig = true;
            }

            if(isBig) {
                swap_array(priorities, temp);
                continue; // there is big priority then pass this
            }
            //TODO:RemoveElement form priorites array

        }

    }

    public static void swap_array(int[] array, int temp){
        for(int i = 0 ; i < array.length-1 ; i ++){
            array[i] = array[i+1];
        }
        array[array.length-1] = temp;
    }

}