import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] mnv = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] xAndY = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int m = mnv[0];
        int n = mnv[1];
        int v = mnv[2];
        int x = xAndY[0];
        int y = xAndY[1];

        int[][] grid = new int[m + 1][n + 1];
        int[][] lavaTime = new int[m+1][n+1];
        boolean[][] hasVolcano = new boolean[m+1][n+1];
        for (int[] row : lavaTime) Arrays.fill(row, Integer.MAX_VALUE);
        HashMap<Integer, List<Coordinate>> volcanicEruptionInfo = new HashMap<>(); // time, 좌표

        for (int i = 1; i <= m; i++) {
            int[] row = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            for (int j = 1; j <= n; j++) {
                grid[i][j] = row[j - 1];
            }
        }

        for(int i = 0; i < v; i++) {
            int[] volcanoEruptionInput = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            List<Main.Coordinate> orDefault = volcanicEruptionInfo.getOrDefault(volcanoEruptionInput[2], new ArrayList<>());
            orDefault.add(new Coordinate(volcanoEruptionInput[0], volcanoEruptionInput[1]));
            volcanicEruptionInfo.put(volcanoEruptionInput[2], orDefault);
        }



        Queue<LavaInfo> queue = new LinkedList<>();

        for (Map.Entry<Integer, List<Coordinate>> entry : volcanicEruptionInfo.entrySet()) {
            int startTime = entry.getKey();
            for (Coordinate coord : entry.getValue()) {
                int vx = coord.x;
                int vy = coord.y;
                lavaTime[vx][vy] = startTime;
                hasVolcano[vx][vy] = true;
                queue.offer(new LavaInfo(vx, vy, startTime));
            }
        }

        while (!queue.isEmpty()) {
            LavaInfo current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int time = current.time;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
            
                if (nx < 1 || nx > m || ny < 1 || ny > n) continue;
                if (lavaTime[nx][ny] > time + 1) {
                    lavaTime[nx][ny] = time + 1;
                    queue.offer(new LavaInfo(nx, ny, time + 1));
                }
            }
        }

        boolean[][] visited = new boolean[m + 1][n + 1];
        Queue<RescueInfo> q = new LinkedList<>();
        q.offer(new RescueInfo(x, y, 0));
        visited[x][y] = true;

        int maxHeight = grid[x][y];
        int minTime = 0;

        while (!q.isEmpty()) {
            RescueInfo cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int time = cur.time;
        
            int curHeight = grid[cx][cy];
            if (lavaTime[cx][cy] > time) {
                if (curHeight > maxHeight) {
                    maxHeight = curHeight;
                    minTime = time;
                } else if (curHeight == maxHeight && time < minTime) {
                    minTime = time;
                }
            
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];
                
                    if (nx < 1 || nx > m || ny < 1 || ny > n) continue;
                    if (visited[nx][ny]) continue;
                    if (lavaTime[nx][ny] <= time + 1) continue;
                    if (hasVolcano[nx][ny]) continue;
                
                    visited[nx][ny] = true;
                    q.offer(new RescueInfo(nx, ny, time + 1));
                }
            }
        }

        writer.write(maxHeight + " " + minTime);
        writer.flush();

        reader.close();
        writer.close();

    }

    public static class Coordinate{
        final int x;
        final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static class LavaInfo{
        final int x;
        final int y;
        final int time;

        public LavaInfo(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }

    public static class RescueInfo {
        final int x;
        final int y;
        final int time;

        public RescueInfo(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}