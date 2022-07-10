package Baekjoon.Baekjoon_2609_Euclid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        
        int[] num = new int[2];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        bufferedReader.close();
        for(int i = 0 ; i < 2 ; i++){
            num[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(num);
        int gcd = getGCD(num[1], num[0]);
        int lcm = num[0]*num[1]/gcd;

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(gcd) + "\n");
        bufferedWriter.write(String.valueOf(lcm));
        bufferedWriter.flush();
        bufferedWriter.close();
        

    }

    public static int getGCD(int big, int small){

        if(Integer.compare(small, 0)==0)
            return big;
        return getGCD(small,big%small);
    }


}
