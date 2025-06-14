import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());
        boolean[][] map = new boolean[size][size];
        boolean[][] isVisited = new boolean[size][size];
        int answer = 0;
        

        for(int i = 0; i < size; i++){
            String line = reader.readLine();
            for(int j = 0; j < size; j++){
                map[i][j] = line.charAt(j) == '*';
            }
        }

        for(int i = 0; i < size ; i ++){
            for(int j = 0; j < size; j++){
                if(map[i][j]&& !isVisited[i][j]){
                    visit(map, isVisited, i, j);
                    answer++;
                }
            }
        }

        writer.write(String.valueOf(answer));
        writer.flush();

        reader.close();
        writer.close();
    }

    public static void visit(boolean[][] map, boolean[][] isVisited, int x, int y){
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length || isVisited[x][y] || !map[x][y]){
            return;
        }

        isVisited[x][y] = true;

        visit(map, isVisited, x - 1, y);
        visit(map, isVisited, x + 1, y);
        visit(map, isVisited, x, y - 1);
        visit(map, isVisited, x, y + 1);
    }

}
