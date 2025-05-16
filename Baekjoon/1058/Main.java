import java.util.*;
import java.io.*;
import java.util.stream.Stream;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        final int friendSize = Integer.parseInt(reader.readLine());
        final boolean[][] friendInfo = new boolean [friendSize + 1][friendSize + 1];
        int answer = -1;
        boolean[] isVisited;

        // initialize
        for (int i = 1; i <= friendSize; i++) {

            Boolean[] inputArray = Stream.of(reader.readLine().split("")).map(input -> input.equals("Y")).toArray(Boolean[]::new);
            for(int j = 1 ; j <= inputArray.length; j++){
                friendInfo[i][j] = inputArray[j - 1];
            }
        }

        for (int i = 1; i <= friendSize; i++) {
            int count = 0;
            isVisited = new boolean[friendSize + 1];
            isVisited[i] = true;
            noteFirstFriend(i, isVisited, friendInfo);

            for (int j = 1; j < isVisited.length; j++) {
                if(isVisited[j]){
                    count++;
                }
            }
            count--;

            if(count > answer){
                answer = count;
            }
        }

        writer.write(String.valueOf(answer));
        writer.flush();

        reader.close();
        writer.close();
    }

    public static void noteFirstFriend(int visit, boolean[] isVisited, boolean[][] friendInfo){
        for (int i = 1; i < friendInfo.length; i++) {
            if(friendInfo[visit][i]){
                isVisited[i] = true;
                noteSecondFriend(i, isVisited, friendInfo);
            }
        }
    }

    public static void noteSecondFriend(int visit, boolean[] isVisited, boolean[][] friendInfo){
        for (int i = 1; i < friendInfo.length; i++) {
            if(friendInfo[visit][i]){
                isVisited[i] = true;
            }
        }
    }
}