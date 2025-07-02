import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static final int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        List<Integer>[] groupArray = init();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= testCase; t++) {
            int[] input = Arrays.stream(reader.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            int n = input[0];
            int m = input[1];

            int result = result(groupArray, n, m);
            writer.write(String.format("Case #%d: %d\n", t, result));
        }

        writer.flush();
        reader.close();
        writer.close();
    }

    public static List<Integer>[] init() {
        List<Integer>[] groups = new ArrayList[MAX + 1];
        for (int i = 2; i < groups.length; i++) {
            groups[i] = new ArrayList<>();
        }

        for (int i = 2; i <= groups.length ; i++) {
            for (int j = 2; j*i < groups.length; j++) {
                groups[j*i].add(i);
            }
        }
        return groups;
    }

    public static int result(List<Integer>[] groupArray, int n, int m) {
        int size = groupArray[n].size();
        int result  = 0;
        for (int j = 2; j < n; j++) {
            if (size==0){
                break;
            }
            if (groupArray[j].size() == size && groupArray[j].get(0)>= m) {
                result++;
            }
        }
        return result;
    }
}