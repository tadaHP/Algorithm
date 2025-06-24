import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int n = input[0]; // 수빈이 위치
        int k = input[1]; // 동생 위치

        int[] dist = new int[100_001];
        Arrays.fill(dist, -1);

        dist[n] = 0; // 수빈이 위치에서 시작

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(n, 0));

        while (!queue.isEmpty()) {
            // 큐에서 꺼내서
            Node current = queue.poll();

            // 본인인지 확인하고
            if(current.position == k) {// 본인이라면 종료
                break;
            }

            if(current.position * 2 <= 100_000 && (dist[current.position * 2] == -1 || dist[current.position * 2] > current.time)) {
                dist[current.position * 2] = current.time;
                queue.add(new Node(current.position * 2, current.time));
            }

            if(current.position + 1 <= 100_000 && (dist[current.position + 1] == -1 || dist[current.position + 1] > current.time + 1)) {
                dist[current.position + 1] = current.time + 1;
                queue.add(new Node(current.position + 1, current.time + 1));
            }

            if(current.position - 1 >= 0 && (dist[current.position - 1] == -1 || dist[current.position - 1] > current.time + 1)) {
                dist[current.position - 1] = current.time + 1;
                queue.add(new Node(current.position - 1, current.time + 1));
            }
        }
        

        writer.write(String.valueOf(dist[k]));
        writer.flush();

        reader.close();
        writer.close();
    }

    public static class Node implements Comparable<Node>{
        int position;
        int time;

        Node(int position, int time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.time, other.time);
        }
    }
}