package Programmers.Programmers_42839;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        int size = input.length();
        int[] numArray = new int[size];
        ArrayList<Integer> permutationArrayList = new ArrayList<>();
        HashSet<Integer> filterDuplication = new HashSet<Integer>();

        
        int answer=0;

        for(int i = 0 ; i < size ; i++)  numArray[i] = Character.getNumericValue(input.charAt(i));

        for(int i = 0 ; i < size +1 ; i++)
            permutation(numArray,size,0,i, permutationArrayList);
        
        Collections.sort(permutationArrayList);
        
        boolean[] isPrime = eratosthenes(permutationArrayList.get(permutationArrayList.size()-1)+1);
        
        
        

        for(int i =0 ; i<permutationArrayList.size() ; i++){
            if(!isPrime[permutationArrayList.get(i)]) {
                filterDuplication.add(permutationArrayList.get(i));
                System.out.println(permutationArrayList.get(i));
            }
        }
        
        for(int i : filterDuplication) answer++;
        
        
        stringBuilder.append(answer);
        bufferedWriter.write("answer: " + stringBuilder.toString());

        bufferedWriter.close();

    }

    public static void permutation(int[] arr, int size, int start, int length, ArrayList<Integer> arrayList){
        if(start == length){
            StringBuilder tempBuilder = new StringBuilder();
            for (int i = 0; i < length; i++)  tempBuilder.append(arr[i]);
            
            try {
                arrayList.add(Integer.parseInt(tempBuilder.toString()));
            } catch (Exception e) {
                
            }
            tempBuilder.setLength(0);
        }
        else{
            for(int i = start ; i < size ; i ++){
                swap(arr, start, i);
                permutation(arr, size, start+1, length, arrayList);
                swap(arr, start, i);
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static boolean[] eratosthenes(int size){

        boolean[] prime = new boolean[size];
        prime[0] = true; prime[1]=true;

        for(int i = 2 ; i < size ; i++){
            if(!prime[i]){
                //prime[i] = false
                for(int j = i* i ; j < size ; j += i){
                    prime[j] = true;
                }
            }
        }
        return prime;
    }


}