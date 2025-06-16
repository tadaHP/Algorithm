import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    private static StringBuilder sb = new StringBuilder();
    private static Deque<Integer> deque = new LinkedList<>();
    private static int n = -1;
    private static int max = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        max = input[1];

        boolean[] isVisited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                solve(isVisited, i, 1);
            }
        }

        writer.write(sb.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    public static void solve(boolean[] isVisited, int visit, int depth){
        if(isVisited[visit]){
            return;
        }

        isVisited[visit] = true;
        deque.addLast(visit);

        if(depth == max){
            // deque 순서대로 뽑아서 sb에 출력후
            sb.append(deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")))
                .append("\n");
            // 마지막에 넣은거 다시 빼고 출력
            isVisited[visit] = false;
            deque.removeLast();
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!isVisited[i]){
                solve(isVisited, i, depth + 1);
            }
        }

        isVisited[visit] = false;
        deque.removeLast();

    }
}
