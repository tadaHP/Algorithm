import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = init[0];
        int dataCount = init[1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] isVisited = new boolean[size + 1];

        for(int i = 0 ; i < dataCount; i++){
            int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = data[0];
            int b = data[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        long answer = 1;
        // 그래프 탐색하면서 사이즈 Set에다 담기, 이때 방문 한것들은 재방문 안하기
        for(int i = 1; i<isVisited.length;){
            if(isVisited[i]){
                i++;
                continue;
            }

            isVisited[i] = true;
            int count = visit(i, graph, isVisited);

            answer = (answer * count) % 1_000_000_007;

        }

        writer.write(String.valueOf(answer));
        writer.flush();

        reader.close();
        writer.close();
    }

    public static int visit(int visit, List<List<Integer>> graph, boolean[] isVisited){
        List<Integer>next = graph.get(visit);
        // next 를 돌면서, next가 true이고 isVisited가 false이면 해당 값 가져오기
        int count = 1;

        for(int n : next){
            if(!isVisited[n]){
                isVisited[n] = true;
                count += visit(n, graph, isVisited);
            }
        }
        return count;
    }

}