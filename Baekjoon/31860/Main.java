import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] nmk = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int n = nmk[0];
        int m = nmk[1];
        int k = nmk[2];


        PriorityQueue<Work> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int priority = Integer.parseInt(reader.readLine());
            Work work = new Work(i, priority);
            priorityQueue.add(work);
        }

        int satisfaction = 0;
        int count = 0;

        List<Integer> satisfactionList = new ArrayList<>();

        while(!priorityQueue.isEmpty()){
            Work highestWork = priorityQueue.poll();

            if(highestWork.priority < k) {
                continue;
            }

            // statisfaction = 기존값 / 2 (소숫점 내림) + 오늘 일의 중요도
            satisfaction = (satisfaction / 2) + highestWork.priority;
            satisfactionList.add(satisfaction);

            highestWork.priority -= m;

            if(highestWork.priority > k) {
                priorityQueue.add(highestWork);
            }
            count++;
        }

        writer.write(String.valueOf(count));
        writer.newLine();
        for(int satisfactionValue : satisfactionList) {
            writer.write(String.valueOf(satisfactionValue));
            writer.newLine();
        }


        reader.close();
        writer.close();
    }

    private static class Work implements Comparable<Work> {
        int id;
        int priority;

        public Work(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        @Override
        public int compareTo(Work other){
            return Integer.compare(other.priority, this.priority);
        }
    }
}

