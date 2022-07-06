package Programmers.Programmers_42862;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        
        int[] lost = {2, 4};
        int[] reserve ={3, 1};

        boolean[] isBorrow = new boolean[n];
        int answer=n-lost.length;

        Arrays.sort(reserve);

        for(int i =0; i<lost.length ;i++){
            for(int j: reserve){
                if(Integer.compare(lost[i]-1, j)==0 && !isBorrow[lost[i]-2]){ //lost-1 == reserve
                    answer++;
                    isBorrow[lost[i]-2] = true;
                    break;
                }
                if(Integer.compare(lost[i], j)==0 && !isBorrow[lost[i]-1]){
                    answer++;
                    isBorrow[lost[i]-1] = true;
                    break;
                }
                if(Integer.compare(lost[i]+1, j)==0 && !isBorrow[lost[i]]){ //lost+1 == reserve
                    answer++;
                    isBorrow[lost[i]] = true;
                    break;
                }
            }
        }
        System.out.println("answer: " + answer);
    }
}