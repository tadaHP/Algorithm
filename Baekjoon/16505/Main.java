import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{
    private static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(reader.readLine());

        boolean[][] field = new boolean[(int)Math.pow(2,n)][(int)Math.pow(2,n)];

        recur(0, 0, 0, field);

        for (int i=0; i<(int)Math.pow(2,n); i++) {
            for (int j=0; j<(int)Math.pow(2,n)-i; j++) {
                if(field[i][j]){
                    writer.write('*');
                }else{
                    writer.write(' ');
                }
            };
            if (i!=(int)Math.pow(2,n)-1){
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
    }

    static void recur(int depth, int x, int y, boolean[][] field){
        if (depth==n){
            field[y][x] = true;
            return;
        }
        int d = (int)Math.pow(2, depth);
        recur(depth+1, x, y, field);
        recur(depth+1, x+d, y, field);
        recur(depth+1, x, y+d, field);
    }
}
