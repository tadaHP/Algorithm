import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] mnkx = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int cityCount = mnkx[0]; // nodeCount
        int roadCount = mnkx[1]; // edgeCount
        int lengthInfo = mnkx[2];
        int startCityNumber = mnkx[3];

        HashMap<Integer, Node> nodeMap = new HashMap<>();
        int[] length = new int[cityCount+1];
        Arrays.fill(length, Integer.MAX_VALUE);

        for (int i = 1; i <= cityCount; i++) {
            Node node = new Node(i);
            nodeMap.put(i, node);
        }

        for (int i = 0; i < roadCount; i++) {
            int[] roadInfo = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int startCity = roadInfo[0];
            int endCity = roadInfo[1];
            Edge edge = new Edge(endCity);
            nodeMap.get(startCity).addEdge(edge);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(nodeMap.get(startCityNumber));
        length[startCityNumber] = 0;

        while (queue.isEmpty() == false) {
            Node currentNode = queue.poll();
            
            if (currentNode.time > length[currentNode.number]) { // 방문했는데 그 길이가 더 길면 무스
                continue;
            }
            if(currentNode.time == lengthInfo) { // 목적지에 도달하면 종료
                continue; 
            }
            
            for (Edge edge : currentNode.edges) {
                Node nextNode = nodeMap.get(edge.to);
                int newTime = currentNode.time + 1;
                if (newTime < length[nextNode.number]) {
                    length[nextNode.number] = newTime;
                    nextNode.setTime(newTime);
                    queue.add(nextNode);
                }
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 1; i < cityCount+1; i++) {
            if (length[i] == lengthInfo) {
                answerList.add(i);
            }
        }

        if(answerList.isEmpty()) {
            writer.write("-1");
        } else {
            Collections.sort(answerList);
            String answer = answerList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
            writer.write(String.valueOf(answer));
        }
        
        writer.flush();

        reader.close();
        writer.close();
    }
    
    public static class Node implements Comparable<Node>{
        int number;
        int time = 0;
        List<Edge> edges;

        public Node(int number) {
            this.number = number;
            this.edges = new ArrayList<>();
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
        }

        public void setTime(int time){
            this.time = time;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.time, other.time);
        }
    }

    public static class Edge{
        int to;
        public Edge(int to) {
            this.to = to;
        }
    }
}
