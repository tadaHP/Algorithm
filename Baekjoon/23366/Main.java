import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] initFirstLine = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int n = initFirstLine[0]; // number of country
        int m = initFirstLine[1]; // number of borders

        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] initSecondLine = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int startCountryNumber = initSecondLine[0]; // 시작점
        int endCountryNumber = initSecondLine[1]; // 끝점
        int numberOfCandy = initSecondLine[2]; // 사탕의 수

        for (int i = 0; i < m; i++) {
            int[] borderInfo = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            int startCountryPoint = borderInfo[0]; // 시작점
            int endCountryPoint = borderInfo[1]; // 끝점
            int taxPercentage = borderInfo[2]; // 세금 퍼센트

            graph.get(startCountryPoint).add(new Edge(taxPercentage, endCountryPoint));
            graph.get(endCountryPoint).add(new Edge(taxPercentage, startCountryPoint));
        }

        int result = solve(n, graph, startCountryNumber, endCountryNumber, numberOfCandy);
        writer.write(String.valueOf(result));
        writer.flush();

        reader.close();
        writer.close();
    }

    public static int solve(int n, Map<Integer, List<Edge>> graph, int start, int target, int initCandy){

        int[] candyStatus = new int[n + 1];
        Arrays.fill(candyStatus, -1);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        candyStatus[start] = initCandy;
        queue.offer(new Node(start, initCandy));

        while (!queue.isEmpty()) {
            Node visit = queue.poll();

            if (visit.countryNumber == target) {
                return visit.candy;
            }
            if (candyStatus[visit.countryNumber] > visit.candy) {
                continue;
            }

            for (Edge edge : graph.get(visit.countryNumber)) {
                long total = (long)visit.candy * edge.taxPercentage;
                int taxToPay = (int)((total + 99) / 100);
                int nextCandy = visit.candy - taxToPay;
                if (nextCandy > candyStatus[edge.nextNode]) {
                    candyStatus[edge.nextNode] = nextCandy;
                    queue.offer(new Node(edge.nextNode, nextCandy));
                }
            }
        }
        return 0;
    }

    public static class Node implements Comparable<Node>{
        int countryNumber;
        int candy;

        public Node(int countryNumber, int candy) {
            this.countryNumber = countryNumber;
            this.candy = candy;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.candy, this.candy);
        }
    }

    public static class Edge{
        int taxPercentage;
        int nextNode;

        public Edge(int taxPercentage, int nextNode) {
            this.taxPercentage = taxPercentage;
            this.nextNode = nextNode;
        }
    }
}
