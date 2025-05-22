import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int balance = 0;
        int answer = 0;

        int size = Integer.parseInt(reader.readLine());
        String[] request = reader.readLine().split("");

        for (int i = 0 ; i < size ; i ++ ){
            String input = request[i];

            if(input.equals("(")){
                balance ++;
            }else{
                balance --;
            }

            if(Math.abs(balance)>answer){
                answer = Math.abs(balance);
            }
        }

        if(balance == 0){
            writer.write(String.valueOf(answer));
            writer.flush();
        }else{
            writer.write("-1");
            writer.flush();
        }

        reader.close();
        writer.close();
    }

}