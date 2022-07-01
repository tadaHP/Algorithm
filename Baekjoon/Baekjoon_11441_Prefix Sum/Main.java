import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        int numCount;//N
        int numSection;//M
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        numCount = Integer.parseInt(bufferedReader.readLine());

        int[] arrayDefault = new int[numCount];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0 ; i < numCount ; i ++)
            arrayDefault[i] = Integer.parseInt(stringTokenizer.nextToken());

        numSection = Integer.parseInt(bufferedReader.readLine());

        int[][] section = new int[numSection][2];

        for(int i = 0 ; i < numSection ; i ++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            section[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            section[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        bufferedReader.close();

        int[] arrayPrefixSum = Arrays.copyOf(arrayDefault, arrayDefault.length);

        for(int i = 1 ; i < numCount ; i ++){
            arrayPrefixSum[i] += arrayPrefixSum[i-1];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < numSection ; i++){
            if(section[i][0]!=1){
                sb.append((arrayPrefixSum[section[i][1]-1] - arrayPrefixSum[section[i][0]-2]) + "\n");
            }else{
                sb.append(arrayPrefixSum[section[i][1]-1] + "\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        


    }
}
