import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int n = nk[0];
        int k = nk[1];


        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 1 ; i < nk[0] ; i++){
            int[] aToB = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int a = aToB[0];
            int b = aToB[1];

            map.computeIfAbsent(a, x -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, x -> new ArrayList<>()).add(a);
        }

        int[] nodeArray = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int targetNodeIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nodeArray[i] == k) {
                targetNodeIndex = i;
                break;
            }
        }

        Queue<Visit> queue = new LinkedList<>();
        queue.add(new Visit(0, 0));

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int answer = 0;

        while (!queue.isEmpty()) {
            Visit visitNode = queue.remove();
            int deep = visitNode.deep;
            int visit = visitNode.visit;

            if (visit == targetNodeIndex) {
                answer = deep;
                break;
            }

            List<Integer> connectedNode = map.get(visit);
            if (connectedNode == null) continue;

            for (int next : connectedNode) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Visit(deep + 1, next));
                }
            }
        }

        writer.write(String.valueOf(answer));
        writer.flush();

        reader.close();
        writer.close();
    }

    public static class Visit{
        int deep;
        int visit;
        Visit(int deep, int visit){
            this.deep = deep;
            this.visit = visit;
        }
    }

}