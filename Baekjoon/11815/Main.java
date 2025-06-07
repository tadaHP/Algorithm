import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        long[] request = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        for (long number : request) {
            long rootNumber = (long) Math.sqrt(number);
            int answer  = rootNumber * rootNumber == number ? 1 : 0;
            writer.write(String.valueOf(answer));
            writer.write(" ");
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}