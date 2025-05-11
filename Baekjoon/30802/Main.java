// 30802

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalCount = Integer.parseInt(reader.readLine());
        
        Stream<String> shirtSizeStream = Stream.of(reader.readLine().split(" "));

        String[] tAndP = reader.readLine().split(" ");
        int t = Integer.parseInt(tAndP[0]);
        int p = Integer.parseInt(tAndP[1]);


        int requiredShirtSet = shirtSizeStream.mapToInt(Integer::parseInt)
            .map(shirtSize -> {
                if(shirtSize == 0){
                    return 0;
                }
                int shirtSet = shirtSize / t;
                boolean needMore = shirtSize % t > 0;
                if(needMore) {
                    shirtSet++;
                }
                return shirtSet;
            }).sum();

        int requiredPenSet = totalCount / p;
        int requiredUniquePen = totalCount % p;

        writer.write(String.valueOf(requiredShirtSet) + "\n");
        writer.flush();
        
        writer.write(requiredPenSet + " " + requiredUniquePen);
        writer.flush();
        writer.close();
        reader.close();

        return;
    }
}