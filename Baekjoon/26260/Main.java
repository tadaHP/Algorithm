import java.util.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] input = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int newNumber = Integer.parseInt(reader.readLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            if(input[i] == -1){
                array[i] = newNumber;
            } else {
                array[i] = input[i];
            }
        }

        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        postOrder(array, n / 2, (n + 1) / 4, sb);


        writer.write(sb.toString());
        writer.flush();
        
        reader.close();
        writer.close();
    }

    static void postOrder(int[] array, int n, int d, StringBuilder sb) throws IOException {
        if (d == 0) {
            sb.append(array[n]).append(" ");
            return;
        }

        postOrder(array, n - d, d / 2, sb);
        postOrder(array, n + d, d / 2, sb);
        sb.append(array[n]).append(" ");
    }
}