import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int minHeight = Integer.MAX_VALUE;
        int minWidth = Integer.MAX_VALUE;
        int maxHeight = -1;
        int maxWidth = -1;

        int[] gridInfoArray = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        boolean[][] grid = new boolean[gridInfoArray[0]][gridInfoArray[1]];
        boolean[][] futureGrid = new boolean[gridInfoArray[0]][gridInfoArray[1]];

        for (int i = 0; i < grid.length; i++) {
            String line = reader.readLine();
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = (line.charAt(j) == 'X');
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    int count = 0;
                    if(i > 0){
                        if(!grid[i - 1][j]) count++;
                    }else{
                        count++;
                    }
                    if (i < grid.length - 1) {
                        if (!grid[i + 1][j]) count++;
                    } else {
                        count++;
                    }

                    if(j > 0){
                        if(!grid[i][j - 1]) count++;
                    } else{
                        count++;
                    }

                    if(j < grid[i].length - 1) {
                        if (!grid[i][j + 1]) count++;
                    } else {
                        count++;
                    }

                    if(count < 3){
                        minHeight = Math.min(minHeight, i);
                        minWidth = Math.min(minWidth, j);
                        maxHeight = Math.max(maxHeight, i);
                        maxWidth = Math.max(maxWidth, j);
                    }

                    futureGrid[i][j] = (count < 3);
                }
            }
        }

        for (int i = minHeight; i <= maxHeight; i++) {
            for (int j = minWidth; j <= maxWidth; j++) {
                if (futureGrid[i][j]) {
                    writer.write("X");
                } else {
                    writer.write(".");
                }
            }
            writer.newLine();
        }

        writer.flush();

        reader.close();
        writer.close();
    }
}