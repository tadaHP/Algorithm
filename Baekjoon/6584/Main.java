import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int[] init = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            if(init[0] == 0 && init[1] == 0) {
                break;
            }

            int numberOfNode = init[0];
            int numberOfEdge = init[1];
            int answer = -1;

            // 그래프를 객체? 기준으로 만들어야 할것으로 보임 가능한지는 미지수
            // LinkedList 형식으로 객체를 만들고, 방문하면서 진행, 무방문시에는 방문처리

            HashMap<Integer, Node> graphMap = new HashMap<>();
            for(int i = 0; i < numberOfNode; i++) {
                graphMap.put(i, new Node(i));
            }

            // numberOfEdge 만큼의 간선 정보를 입력해야함
            for(int i = 0 ; i < numberOfEdge; i++) {
                int[] edgeInfo = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
                int a = edgeInfo[0];
                int b = edgeInfo[1];
                Node nodeA = graphMap.get(a);
                Node nodeB = graphMap.get(b);
                Main.Edge edge = new Edge(List.of(nodeA, nodeB));
                nodeA.getEdges().add(edge);
                nodeB.getEdges().add(edge);
            }

            for(Node node : graphMap.values()) {
                int dfs = dfs(node);
                answer = Math.max(answer, dfs);
            }
            
            writer.write(String.valueOf(answer - 1));
            writer.newLine();
        }
        
        writer.flush();

        reader.close();
        writer.close();
    }

    public static int dfs(Node node) {
        int max = 0;

        for (Edge edge : node.getEdges()) {
            if (!edge.used) {
                edge.used = true;
                for(Node nextNode : edge.getTo()){
                    if (nextNode != node) {
                        max = Math.max(max, dfs(nextNode));
                    }
                }
                edge.used = false;
            }
        }

        return max + 1;
    }

    public static class Node{
        private int number;
        List<Edge> edges;

        public Node(int number) {
            this.number = number;
            this.edges = new ArrayList<>();
        }

        public int getNumber() {
            return number;
        }
        public List<Edge> getEdges() {
            return edges;
        }
    }

    public static class Edge {
        List<Node> to;
        boolean used;

        public Edge(List<Node> to) {
            this.to = to;
            this.used = false;
        }

        public List<Node> getTo() {
            return to;
        }
        public boolean isUsed() {
            return used;
        }
        public void setUsed(boolean used) {
            this.used = used;
        }
    }
}
