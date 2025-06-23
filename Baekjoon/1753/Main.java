import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(reader.readLine().split(" "))
              .mapToInt(Integer::parseInt)
              .toArray();
        int V = input[0];
        int E = input[1];

        int K = Integer.parseInt(reader.readLine());

        List<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int[] edgeInfo = Arrays.stream(reader.readLine().split(" "))
              .mapToInt(Integer::parseInt)
              .toArray();
            int u = edgeInfo[0];
            int v = edgeInfo[1];
            int w = edgeInfo[2];
            graph[u].add(new Edge(v, w));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.distance > dist[cur.vertex]) { // 현재 노드의 거리가 이미 최단 거리보다 크면 무시
                continue;
            }
            for (Edge e : graph[cur.vertex]) {
                int next = e.to;
                int nd = cur.distance + e.weight;
                if (nd < dist[next]) {
                    dist[next] = nd;
                    queue.offer(new Node(next, nd));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
        writer.write(sb.toString());

        reader.close();
        writer.close();
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}