import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int size = nk[0];
        int length = nk[1];

        String[] infoArray = reader.readLine().split("");
        Queue<Integer> people = new LinkedList<>();
        Queue<Integer> burgers = new LinkedList<>();

        for (int i = 0; i < infoArray.length; i++) {
            if (infoArray[i].equals("P")) {
                people.add(i);
            } else if (infoArray[i].equals("H")) {
                burgers.add(i);
            }
        }

        int answer = 0;
        Integer personPosition = people.poll();
        Integer burgerPosition = burgers.poll();

        while(!people.isEmpty() && !burgers.isEmpty()) {
            if (Math.abs(burgerPosition - personPosition) <= length) {
                answer++;
                personPosition = people.poll();
                burgerPosition = burgers.poll();
            } else {
                if (burgerPosition < personPosition) {
                    burgerPosition = burgers.poll();
                } else {
                    personPosition = people.poll();
                }
            }
        }

        while(personPosition!=null && burgerPosition!=null) {
            if (Math.abs(burgerPosition - personPosition) <= length) {
                answer++;
                personPosition = people.poll();
                burgerPosition = burgers.poll();
            } else {
                if (burgerPosition < personPosition) {
                    burgerPosition = burgers.poll();
                } else {
                    personPosition = people.poll();
                }
            }
        }
        

        writer.write(String.valueOf(answer));
        writer.flush();
        reader.close();
        writer.close();
    }
}