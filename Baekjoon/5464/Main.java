import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nm[0];
        int m = nm[1];

        Map<Integer, Integer> priceMap = new HashMap<>();
        PriorityQueue<Integer> availableSpotsQueue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            int price = Integer.parseInt(reader.readLine());
            priceMap.put(i, price);
            availableSpotsQueue.add(i);
        }

        Map<Integer, Integer> carWeightMap = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            int carWeight = Integer.parseInt(reader.readLine());
            carWeightMap.put(i, carWeight);
        }


        long totalPrice = 0;

        Queue<Integer> waitingCarQueue = new LinkedList<>();
        Map<Integer, Integer> parkingInfoMap = new HashMap<>();

        for (int i = 0; i < 2 * m; i++) {
            int info = Integer.parseInt(reader.readLine());

            if (info > 0) {
                waitingCarQueue.add(info);
            } else {
                int carToLeave = Math.abs(info);
                int freedSpot = parkingInfoMap.get(carToLeave);
                parkingInfoMap.remove(carToLeave);
                availableSpotsQueue.add(freedSpot);
            }

            while (!availableSpotsQueue.isEmpty() && !waitingCarQueue.isEmpty()) {
                int spotToPark = availableSpotsQueue.poll();
                int carToPark = waitingCarQueue.poll();

                parkingInfoMap.put(carToPark, spotToPark);
                totalPrice += carWeightMap.get(carToPark) * priceMap.get(spotToPark);
            }
        }

        writer.write(String.valueOf(totalPrice));
        writer.flush();

        reader.close();
        writer.close();
    }
}