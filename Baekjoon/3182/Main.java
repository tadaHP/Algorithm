import java.util.*;
import java.io.*;
import java.util.stream.Stream;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputSize = Integer.parseInt(reader.readLine());

        int answer = -1;
        int answerCount = -1;
        int arr[][] = new int[2][inputSize + 1];

        for(int i = 1; i <= inputSize; i++){
            arr[0][i] = Integer.parseInt(reader.readLine());
            arr[1][i] = i;
        }

        for(int i = 1; i <= inputSize; i++){
            boolean[] isVisited =  new boolean[inputSize+1];

            isVisited[i] = true;
            boolean flag = true;
            int visit = i;
            int count = 0;

            while(flag){
                int newVisit = arr[0][visit];
                flag = !isVisited[newVisit];
                isVisited[newVisit] = true;
                visit = newVisit;
                count++;
            }

            if(answerCount < count ){
                answerCount = count;
                answer = i;
            }
        }



        writer.write(String.valueOf(answer));
        writer.flush();
        reader.close();
        writer.close();
    }
}