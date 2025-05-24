import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] size = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean [][] grid = new boolean[size[0]][size[1]];// [가로][세로]
        boolean [][] isVisited = new boolean[size[0]][size[1]];

        for(int i = 0 ; i < size[1]; i++){
            int[] line = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < size[0]; j++){
                grid[j][i] = line[j] == 1;
            }
        }
        writer.flush();;

        // 깊이우선탐색, 깊이를 return하면 됨
        // 실패시 -1 리턴
        // 하나라도 성공하면 바로 리턴
        // x, y 좌표를 0으로 두고 시작, 상 하 좌 우로 이동
        // 방문한곳을 확인하면서 진행, 방문했으면 더이상 진행 X
        boolean result = dfs(0,0,grid, isVisited);

        if(result){
            writer.write("Yes");
        } else {
            writer.write("No");
        }

        writer.flush();
        reader.close();
        writer.close();
    }

    public static boolean dfs(int x, int y, boolean[][] grid, boolean[][] isVisited) {
        isVisited[x][y] = true;
        if(x == grid.length-1 && y == grid[0].length-1){
            return true;
        }

        // 하 -> y++
        if( (y+1) < grid[1].length && grid[x][y+1] && !isVisited[x][y+1]) {
            boolean result = dfs(x, y+1, grid, isVisited);
            if(result) return result;
        }
        // 우 -> x++
        if( (x+1) < grid.length && grid[x+1][y] && !isVisited[x+1][y]) {
            boolean result = dfs(x+1, y, grid, isVisited);
            if(result) return result;
        }
        return false;
    }

}