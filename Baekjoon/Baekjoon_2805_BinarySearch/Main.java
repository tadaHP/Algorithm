package Baekjoon.Baekjoon_2805_BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int meter;
        int treeNum = 0;
        int end;
        int average=0;
        int answer = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        treeNum = Integer.parseInt(stringTokenizer.nextToken());            
        meter = Integer.parseInt(stringTokenizer.nextToken());
        
        int[] treeSize = new int[treeNum];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0 ; i < treeNum ; i ++)  treeSize[i] = Integer.parseInt(stringTokenizer.nextToken());

        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        

        Arrays.sort(treeSize);
        end = treeSize[treeSize.length-1];

        // System.out.println("answer is : " + BinarySearch(treeSize, meter, 0, end, end/2));
        bufferedWriter.write(Integer.toString(BinarySearch(treeSize, meter, 0, end, end/2)));
        bufferedWriter.close();
        
    }

    public static int BinarySearch(int[] array, int target, int start, int end, int mid){
        if(start> end){
            return -1;
        }
        int answerSum=0;
        for(int i : array){        
            if(i - mid > 0){
                answerSum += (i - mid);
            }
        }
        
        if(Integer.compare(answerSum, target)==0){
            return mid;
        }
        if(Integer.compare(answerSum, target)>0){
            return BinarySearch(array, target, mid, end, ((mid+end)/2));
        }else {
            return BinarySearch(array, target, start, mid, ((mid+start)/2));
        }
              

    }
    
}