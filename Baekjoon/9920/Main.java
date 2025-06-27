import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            int[] line = Arrays.stream(reader.readLine().split(" "))
                  .mapToInt(Integer::parseInt)
                  .toArray();
            for (int j = 0; j < size; j++) {
                array[i][j] = line[j];
            }
        }

        int visit = visit(array);

        writer.write(String.valueOf(visit));
        writer.flush();
        
        reader.close();
        writer.close();
    }

    public static int visit(int[][] array) {

        if (isSame(array)) {
            return 2;
        }

        int size = array.length;
        int half = size / 2;

        // array의 좌측상단, 우측상단, 좌측하단, 우측하단으로 분리
        int answer = 1;

        int[][] topLeft = new int[half][half];
        int[][] topRight = new int[half][half];
        int[][] bottomLeft = new int[half][half];
        int[][] bottomRight = new int[half][half];

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                topLeft[i][j] = array[i][j];
                topRight[i][j] = array[i][j + half];
                bottomLeft[i][j] = array[i + half][j];
                bottomRight[i][j] = array[i + half][j + half];
            }
        }

        answer += visit(topLeft);
        answer += visit(topRight);
        answer += visit(bottomLeft);
        answer += visit(bottomRight);

        return answer;
    }

    public static boolean isSame(int[][] array) {
        int size = array.length;
        int first = array[0][0];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (array[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}