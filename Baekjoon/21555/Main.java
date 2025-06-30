import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int number = nk[0];
        int changeCost = nk[1];

        int[] dragCostArray = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] holdCostArray = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        long[] dpDrag = new long[number];
        long[] dpHold = new long[number];
        
        dpDrag[0] = dragCostArray[0];
        dpHold[0] = holdCostArray[0];

        for (int i = 1; i < number; i++) {
            dpDrag[i] = Math.min(dpDrag[i - 1] + dragCostArray[i], dpHold[i - 1] + changeCost + dragCostArray[i]);
            dpHold[i] = Math.min(dpHold[i - 1] + holdCostArray[i], dpDrag[i - 1] + changeCost + holdCostArray[i]);
        }

        long answer = Math.min(dpDrag[number-1], dpHold[number-1]);
        writer.write(String.valueOf(answer));
        writer.flush();

        reader.close();
        writer.close();
    }
}