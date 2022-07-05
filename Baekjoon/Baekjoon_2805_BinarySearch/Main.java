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

        bufferedWriter.write(Integer.toString(BinarySearch(treeSize, meter, 0, end, end/2)));
        bufferedWriter.close();
        
    }

    public static int BinarySearch(int[] array, int target, int start, int end, int mid){
        if(start> end){
            return mid;
        }
        long answerSum=0;
        for(long i : array){        
            if(i - mid > 0){
                answerSum += (i - mid);
            }
            
        }
        
        if(Long.compare(answerSum, target)==0){
            return mid;
        }
        if(Long.compare(answerSum, target)>0){            
            return BinarySearch(array, target, mid+1, end, ((mid+1+end)/2));
        }else {
            return BinarySearch(array, target, start, mid-1, ((mid-1+start)/2));
        }
              

    }
    
}