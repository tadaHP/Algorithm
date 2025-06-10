import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int[] array = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            int x = array[0];
            int y = array[1];

            if(x == 0 && y == 0) {
                break;
            }

            boolean[][] matrix = new boolean[y + 1][x + 1];
            boolean[][] isVisited = new boolean[y + 1][x + 1];

            for(int i = 1; i <= y; i++) {
                int[] matrixInput = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

                for(int j = 1; j <= x; j++) {
                    matrix[i][j] = (matrixInput[j - 1] == 1);
                }
            }

            int result = 0;

            for(int i = 1; i <= y; i++) {
                for(int j = 1; j <= x; j++) {
                    if(matrix[i][j] && !isVisited[i][j]) {
                        search(matrix, isVisited, j, i);
                        result++;
                    }
                }
            }

            writer.write(String.valueOf(result));
            writer.newLine();

        }
        writer.flush();

        reader.close();
        writer.close();
    }

    public static void search(boolean[][] matrix, boolean[][] isVisited, int x, int y){
        if(x < 1 || y < 1 || x >= matrix[0].length || y >= matrix.length || !matrix[y][x] || isVisited[y][x]) {
            return;
        }
        
        isVisited[y][x] = true;
        search(matrix, isVisited, x + 1, y);
        search(matrix, isVisited, x - 1, y);
        search(matrix, isVisited, x, y + 1);
        search(matrix, isVisited, x, y - 1);
        search(matrix, isVisited, x + 1, y + 1);
        search(matrix, isVisited, x - 1, y - 1);
        search(matrix, isVisited, x + 1, y - 1);
        search(matrix, isVisited, x - 1, y + 1);
    }

}