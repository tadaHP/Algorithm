package Programmers.Programmers_42862;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // int n = 5;
        // int[] lost = {2, 4};
        // int[] reserve ={1,3,5};

        // int[] lost = {2, 4};
        // int[] reserve ={3};

        int n = 3;
        int[] lost = {3};
        int[] reserve ={1};

        boolean[] isBorrow = new boolean[n];
        int answer=n-lost.length;

        for(int i =0; i<lost.length ;i++){
            for(int j: reserve){
                if(Integer.compare(lost[i]-1, j)==0 && !isBorrow[lost[i]-2]){ //lost-1 == reserve
                    answer++;
                    isBorrow[lost[i]-2] = true;
                    break;
                }
                if(Integer.compare(lost[i]+1, j)==0 && !isBorrow[lost[i]]){ //lost+1 == reserve
                    answer++;
                    isBorrow[lost[i]] = true;
                }
            }
        }
        System.out.println("answer: " + answer);

    }
}
