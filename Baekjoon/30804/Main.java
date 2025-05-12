import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());
        int[] fruits = Stream.of(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        
        Map<Integer, Integer> fruitsCountMap = new HashMap<Integer, Integer>();
        int result = 0;
        int left = 0;

        for (int right = 0; right < size; right++){
            fruitsCountMap.put(fruits[right], fruitsCountMap.getOrDefault(fruits[right], 0) + 1);

            while(fruitsCountMap.size() > 2){
                fruitsCountMap.put(fruits[left], fruitsCountMap.get(fruits[left]) -1);
                if(fruitsCountMap.get(fruits[left]) == 0){
                    fruitsCountMap.remove(fruits[left]);
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.close();
    }

}