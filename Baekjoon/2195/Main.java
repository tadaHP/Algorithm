import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = reader.readLine();
        String p = reader.readLine();

        int pointer = 0;
        int answer = 0;
        for (int i = 0; i < p.length(); i++) {
            if(s.indexOf(p.substring(pointer, i+1)) != -1){
                continue;
            }
            answer++;
            pointer = i;
        }

        writer.write(String.valueOf(answer + 1));
        writer.flush();

        reader.close();
        writer.close();
    }
}