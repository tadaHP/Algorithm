import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] fsgud = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int f = fsgud[0]; // total Building floor
        int g = fsgud[2]; // target Building floor
        int s = fsgud[1]; // current Building floor

        int upTo = fsgud[3];
        int downTo = fsgud[4];

        boolean success = false;
        boolean[] isVisited = new boolean[f + 1];

        Queue<Visit> queue = new LinkedList<>();
        queue.add(new Visit(s, 0));
        isVisited[s] = true;


        while (!queue.isEmpty()) {
            Visit visit = queue.poll();
            int vf = visit.floor;
            int vc = visit.count;

            if(vf == g){
                success = true;
                writer.write(String.valueOf(vc));
                break;
            }

            // 방문
            if(visit.floor+upTo <= f && !isVisited[visit.floor + upTo]){
                isVisited[visit.floor + upTo] = true;
                queue.add(new Visit(visit.floor + upTo, vc + 1));
            }
            if(visit.floor - downTo > 0 && !isVisited[visit.floor - downTo]){
                isVisited[visit.floor - downTo] = true;
                queue.add(new Visit(visit.floor - downTo, vc + 1));
            }
        }

        if(!success){
            writer.write("use the stairs");
        }
        
        writer.flush();

        reader.close();
        writer.close();
    }


    public static class Visit{
        final int floor;
        final int count;
        public Visit(int floor, int count){
            this.floor = floor;
            this.count = count;
        }
    }

}