package Programmers.Programmers_42839;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        int[] num = new int[input.length()];
        boolean[] visited = new boolean[input.length()];
        
        int answer=0;

        for(int i = 0 ; i < input.length() ; i++)  num[i] = Character.getNumericValue(input.charAt(i));
        

    
        // boolean[] prime = new boolean[biggestNum];
        // prime[0] = true; prime[1]=true;

        // for(int i = 2 ; i < biggestNum ; i++){
        //     if(!prime[i]){
        //         for(int j = i* i ; j < biggestNum+1 ; j += i){
        //             prime[j] = true;
        //         }
        //     }
        // }

        
        stringBuilder.append(answer);
        bufferedWriter.write(stringBuilder.toString());

        bufferedWriter.close();

    }

}