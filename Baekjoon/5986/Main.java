import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    private static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());

        boolean[][][] threeDimensionMap = new boolean[n][n][n];
        boolean[][][] isVisited = new boolean[n][n][n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String line = reader.readLine();
                for (int k = 0; k < line.length(); k++) {
                    threeDimensionMap[i][j][k] = line.charAt(k) == '*';
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!isVisited[i][j][k] && threeDimensionMap[i][j][k]){
                        visit(threeDimensionMap, isVisited, i, j, k);
                        answer++;
                    }
                }
            }
        }

        writer.write(String.valueOf(answer));

        reader.close();
        writer.close();
    }

    public static void visit(boolean[][][] threeDimensionMap, boolean[][][] isVisited, int x, int y, int z){
        if(x < 0 || x >= n || y < 0 || y >= n || z < 0 || z >= n || isVisited[x][y][z] || !threeDimensionMap[x][y][z]){
            return;
        }

        isVisited[x][y][z] = true;

        // 전부 탐색
        visit(threeDimensionMap, isVisited, x + 1, y, z);
        visit(threeDimensionMap, isVisited, x - 1, y, z);
        visit(threeDimensionMap, isVisited, x, y + 1, z);
        visit(threeDimensionMap, isVisited, x, y - 1, z);
        visit(threeDimensionMap, isVisited, x, y, z + 1);
        visit(threeDimensionMap, isVisited, x, y, z - 1);

    }
}