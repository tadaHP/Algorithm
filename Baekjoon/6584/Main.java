import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) continue;

            String[] init = line.split(" ");
            int numberOfNode = Integer.parseInt(init[0]);
            int numberOfEdge = Integer.parseInt(init[1]);

            if (numberOfNode == 0 && numberOfEdge == 0) break;

            Map<Integer, Node> graph = new HashMap<>();
            for (int i = 0; i < numberOfNode; i++) {
                graph.put(i, new Node(i));
            }

            for (int i = 0; i < numberOfEdge; i++) {
                String[] edgeInfo = reader.readLine().split(" ");
                int a = Integer.parseInt(edgeInfo[0]);
                int b = Integer.parseInt(edgeInfo[1]);

                Node nodeA = graph.get(a);
                Node nodeB = graph.get(b);
                Edge edge = new Edge(nodeA, nodeB);

                nodeA.addEdge(edge);
                nodeB.addEdge(edge);
            }

            int longest = 0;
            for (Node node : graph.values()) {
                longest = Math.max(longest, node.findLongestPath());
            }

            writer.write(String.valueOf(longest - 1));
            writer.newLine();
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    static class Node {
        private final int number;
        private final List<Edge> edges = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
        }

        public int findLongestPath() {
            int max = 0;
            for (Edge edge : edges) {
                if (!edge.isUsed()) {
                    edge.markUsed();
                    Node next = edge.getOtherNode(this);
                    max = Math.max(max, next.findLongestPath());
                    edge.unMarkUsed();
                }
            }
            return max + 1;
        }
    }

    static class Edge {
        private final Node nodeA;
        private final Node nodeB;
        private boolean used;

        public Edge(Node a, Node b) {
            this.nodeA = a;
            this.nodeB = b;
            this.used = false;
        }

        public Node getOtherNode(Node from) {
            return from == nodeA ? nodeB : nodeA;
        }

        public boolean isUsed() {
            return used;
        }

        public void markUsed() {
            used = true;
        }

        public void unMarkUsed() {
            used = false;
        }
    }
}