import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int truckLength = init[0];
        int bridgeLength = init[1];
        int bridgeWeightApply = init[2];

        int[] trucks = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<Truck> queue = new LinkedList<>();
        int currentBridgeWeight = 0;

        int truckIndex = 0;
        int time = 0;

        while (true) {
            // queue가 비어있고, 트럭이 더이상 없으면 종료
            if (queue.isEmpty() && truckIndex >= truckLength) {
                time++;
                break;
            }

            // 큐에 트럭 추가가능한지 확인
            // 1. 허용 다리 하중보다, 다음 트럭의 크기가 작거나 같을때
            // 큐에 트럭을 추가
            if (truckIndex < truckLength && currentBridgeWeight + trucks[truckIndex] <= bridgeWeightApply) {
                queue.add(new Truck(trucks[truckIndex]));
                currentBridgeWeight+=trucks[truckIndex];
                truckIndex++;
            }

            // 이후에 트럭을 이동시키기
            queue.forEach(Truck::move);
            // 이때, 트럭의 위치가 bridgeLength와 같거나크면 Queue에서 제거
            if (!queue.isEmpty() && queue.peek().getPosition() >= bridgeLength) {
                currentBridgeWeight -= queue.peek().getWeight();
                queue.poll();
            }

            time++;
        }

        writer.write(String.valueOf(time));
        writer.flush();

        reader.close();
        writer.close();
    }

    public static class Truck{
        private int position;
        private int weight;

        public Truck(int weight) {
            this.position = 0;
            this.weight = weight;
        }

        public int getPosition() {
            return position;
        }

        public int getWeight() {
            return weight;
        }

        public void move() {
            this.position++;
        }
    }
}
