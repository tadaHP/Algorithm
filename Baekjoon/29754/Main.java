import java.util.*;
import java.io.*;
import java.time.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // <버튜버이름, <주차, 방송시간>> 으로 구성
        Map<String, HashMap<Integer, Duration>> broadcastTimeDataMap = new HashMap<>();
        Map<String, HashMap<Integer, Integer>> broadcastCountDataMap = new HashMap<>();
        // <버튜버이름, <주차, 방송횟수>> 으로 구성

        int[] requestSize = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int dataSize = requestSize[0];
        int daySize = requestSize[1];
        int totalWeek = daySize / 7 ;
        boolean isAnswered = false;

        for (int i = 0; i < dataSize; i++) {
            String[] input = reader.readLine().split(" ");
            String name = input[0];
            int day = Integer.parseInt(input[1]);
            int targetWeek = (day - 1) / 7;

            String[] startTime = input[2].split(":");
            int startHour = Integer.parseInt(startTime[0]);
            int startMinute = Integer.parseInt(startTime[1]);

            String[] endTime = input[3].split(":");
            int endHour = Integer.parseInt(endTime[0]);
            int endMinute = Integer.parseInt(endTime[1]);

            HashMap<Integer, Duration> broadCastInfoMap = broadcastTimeDataMap.getOrDefault(name, new HashMap<>());
            Duration broadCastTime = broadCastInfoMap.getOrDefault(targetWeek, Duration.ofSeconds(0));
            broadCastTime = broadCastTime.plusHours(endHour - startHour).plusMinutes(endMinute - startMinute);
            broadCastInfoMap.put(targetWeek, broadCastTime);
            broadcastTimeDataMap.put(name, broadCastInfoMap);

            HashMap<Integer, Integer> broadCastCountInfoMap = broadcastCountDataMap.getOrDefault(name, new HashMap<>());
            int broadCastCount = broadCastCountInfoMap.getOrDefault(targetWeek, 0);
            broadCastCount++;
            broadCastCountInfoMap.put(targetWeek, broadCastCount);
            broadcastCountDataMap.put(name, broadCastCountInfoMap);

        }

        Set<String> keySet = broadcastTimeDataMap.keySet();
        List<String> sortedKeySet = new ArrayList<>(keySet);
        sortedKeySet.sort(String::compareTo);

        for (String vTuberName : sortedKeySet) {
            HashMap<Integer, Duration> streamingTimeMap = broadcastTimeDataMap.getOrDefault(vTuberName, new HashMap<>());
            HashMap<Integer, Integer> streamingCountMap = broadcastCountDataMap.getOrDefault(vTuberName, new HashMap<>());
            boolean isPass = true;
            for(int w = 0 ; w < totalWeek; w++){
                Duration duration = streamingTimeMap.getOrDefault(w, Duration.ofSeconds(0));
                Integer count = streamingCountMap.getOrDefault(w, 0);
                
                if(duration.toHours() < 60 || count < 5){
                    isPass = false;
                    break;
                }
            }
            if(isPass){
                isAnswered = true;
                writer.write(vTuberName + "\n");
            }
        }

        if(!isAnswered){
            writer.write("-1");
        }

        writer.flush();

        reader.close();
        writer.close();
    }
}