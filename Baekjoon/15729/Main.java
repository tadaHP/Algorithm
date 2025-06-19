import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());
        List<Boolean> booleanList = Arrays.stream(reader.readLine().split(" "))
            .map(s -> s.equals("1"))
            .collect(Collectors.toList());

        boolean[] requiredBooleanArray = new boolean[booleanList.size()];
        boolean[] currentStatusArray = new boolean[booleanList.size()];
        for (int i = 0; i < booleanList.size(); i++) {
            requiredBooleanArray[i] = booleanList.get(i);
        }

        int count = 0;

        for(int i = 0; i < size; i++) {
            if(requiredBooleanArray[i] != currentStatusArray[i]){
                count++;
                currentStatusArray[i] = !currentStatusArray[i];
                if(i + 1 < size) {
                    currentStatusArray[i+1] = !currentStatusArray[i+1];
                    if(i + 2 < size) {
                        currentStatusArray[i+2] = !currentStatusArray[i+2];
                    }
                }
            }
        }

        writer.write(String.valueOf(count));
        writer.flush();

        reader.close();
        writer.close();
    }
}