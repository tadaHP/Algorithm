import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] firstLine = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = firstLine[0];
        int n = firstLine[1];
        int size = firstLine[2];

        boolean [][] map = new boolean[n][m];

        List<Integer> blankSize = new ArrayList<>();

        for(int i = 0; i < size; i++){
            int [] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 왼쪽 아래
            int x1 = line[0];
            int y1 = line[1];
            // 오른쪽 위
            int x2 = line[2] -1;
            int y2 = line[3] -1;

                for(int x = x1; x <= x2; x++){
                for(int y = y1; y <= y2; y++){
                    map[x][y] = true;
                }
            }
        }

        // 맵 초기화 이후 돌면서 카운트
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!map[i][j]){
                    int count = circulateMap(map, i, j);
                    blankSize.add(count);
                }
            }
        }

        blankSize.sort(Comparator.naturalOrder());

        writer.write(blankSize.size() + "\n");
        String result = blankSize.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));

        writer.write(result);
        writer.flush();

        reader.close();
        writer.close();
    }

    public static int circulateMap(boolean [][] map, int x, int y){
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y]){
            return 0;
        }

        // 방문 처리
        map[x][y] = true;

        // 상하좌우 탐색
        int count = 1; // 현재 위치도 포함
        count += circulateMap(map, x + 1, y);
        count += circulateMap(map, x - 1, y);
        count += circulateMap(map, x, y + 1);
        count += circulateMap(map, x, y - 1);

        return count;
    }

}
