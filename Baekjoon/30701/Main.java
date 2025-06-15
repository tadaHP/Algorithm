import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] initNumbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int roomCount = initNumbers[0];
        long attackAbility = (long)initNumbers[1];
        int answer = 0;

        ArrayList<Integer> armorList = new ArrayList<>();
        ArrayList<Integer> enemyList = new ArrayList<>();

        for(int i = 0; i < roomCount; i++) {
            int[] attackNumbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int type = attackNumbers[0];
            int targetNumber = attackNumbers[1];

            if(type == 1) {
                enemyList.add(targetNumber);
            } else if(type == 2) {
                armorList.add(targetNumber);
            }
        }

        Collections.sort(armorList);
        Collections.sort(enemyList);

        Queue<Integer> armorQueue = new LinkedList<>(armorList);
        Queue<Integer> enemyQueue = new LinkedList<>(enemyList);

        while(!enemyQueue.isEmpty()){
            int enemy = enemyQueue.poll();
            while(attackAbility <= enemy && !armorQueue.isEmpty()) {
                int armor = armorQueue.poll();
                attackAbility *= armor;
                answer++;
            }
            if(attackAbility > enemy) {
                attackAbility += enemy;
                answer++;
            } else {
                break;
            }
        }

        while(!armorQueue.isEmpty()) {
            armorQueue.poll();
            answer++;
        }

        writer.write(String.valueOf(answer));
        writer.flush();

        reader.close();
        writer.close();
    }
}
