import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] infoArray = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int n = infoArray[0];
        int m = infoArray[1];

        int[][] matrix = new int[n][m];
        LinkedList<Vector> vectorList = new LinkedList<>();
        int time = 0;
        int icebergCount = 0;

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = row[j];
                if (matrix[i][j] > 0) {
                    vectorList.add(new Vector(i, j));
                }
            }
        }
        icebergCount = visit(vectorList, matrix, n, m);
        while(1 == icebergCount){
            matrix = meltIce(vectorList, matrix, n, m);
            time++;
            icebergCount = visit(vectorList, matrix, n, m);
        }

        if(icebergCount == 0) {
            time = 0;
        }

        writer.write(String.valueOf(time));
        writer.flush();

        reader.close();
        writer.close();
    }

    public static class Vector {
        int x;
        int y;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int visit(LinkedList<Vector> vectorList, int[][] matrix , int n, int m) {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (Vector vector : vectorList) {
            if (!visited[vector.x][vector.y] && matrix[vector.x][vector.y] > 0) {
                count++;
                dfs(matrix, visited, vector.x, vector.y);
            }
        }
        return count;
    }

    public static void dfs(int[][] matrix, boolean[][] visited, int startX, int startY) {
        if(startX < 0 || startY < 0 || startX >= matrix.length || startY >= matrix[0].length || visited[startX][startY] || matrix[startX][startY] <= 0) {
            return;
        }
        visited[startX][startY] = true;
        dfs(matrix, visited, startX - 1, startY); // 위
        dfs(matrix, visited, startX + 1, startY); // 아래
        dfs(matrix, visited, startX, startY - 1); // 왼쪽
        dfs(matrix, visited, startX, startY + 1); // 오른쪽
    }

    public static int[][] meltIce(LinkedList<Vector> vectorList, int[][] matrix, int n, int m) {
        int[][] newMatrix = Arrays.stream(matrix)
                    .map(int[]::clone)
                    .toArray(int[][]::new);

        Iterator<Main.Vector> vectorIterator = vectorList.iterator();
        while (vectorIterator.hasNext()) {
            Vector vector = vectorIterator.next();
            int x = vector.x;
            int y = vector.y;
            if (matrix[x][y] > 0) {
                // 상하 좌우 검증해서, 기존 값이 0 이면 나의 값을 빼고
                // 내가 0일시, // vectorList에서 제거
                int meltCount = 0;
                if (x > 0 && matrix[x - 1][y] == 0) meltCount++;
                if (x < n - 1 && matrix[x + 1][y] == 0) meltCount++;
                if (y > 0 && matrix[x][y - 1] == 0) meltCount++;
                if (y < m - 1 && matrix[x][y + 1] == 0) meltCount++;

                newMatrix[x][y] = Math.max(0, matrix[x][y] - meltCount);

                if (newMatrix[x][y] == 0) {
                    vectorIterator.remove();
                }
            }
        }

        return newMatrix;
    }

}