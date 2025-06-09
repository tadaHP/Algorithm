import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());

        for (int i = n; i > 0; i--) {
            writer.write(String.valueOf(i));
            writer.newLine();
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}
