import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2470_twoPointer {

    

    public static void main(String[] args) throws IOException {
        int size;
        int[] array;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        array = new int[size];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < size ; i ++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        br.close();

        int min = Integer.MAX_VALUE;
        int frontPointer = 0;
        int rearPonter = size-1;
        int sum;
        int value1 = 0, value2 = 0;

        Arrays.sort(array);

        while(frontPointer < rearPonter){
            
            sum = array[frontPointer] + array[rearPonter];
            if(Math.abs(sum)<Math.abs(min)) {
                min = sum;
                value1 = frontPointer;
                value2 = rearPonter;
            }
            if(sum>0)rearPonter--;
            else frontPointer++;
        
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append(array[value1]);
        sb.append(" ");
        sb.append(array[value2]);
        bw.write(sb.toString());
        bw.close();
       
    }

}
