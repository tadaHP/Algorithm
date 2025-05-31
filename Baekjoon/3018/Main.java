import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main{

    public final static int SEON_YEONG = 1;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int participantCount = Integer.parseInt(reader.readLine());
        int days = Integer.parseInt(reader.readLine());

        char newSong = 'a' - 1;
        int newSongSize = 0;

        HashMap<Integer, Set<Character>> attendeeKnowSongList = new HashMap<>();

        for(int i = 0;i <days;i++){
            int[] input = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] participantArray = Arrays.stream(input).skip(1).toArray();
            OptionalInt isSeonYeong = Arrays.stream(participantArray).filter(in -> in == SEON_YEONG).findFirst();

            // 선영이가 있으면 = 새로운 노래 생성
            // 선영이가 없으면 = 기존 노래 참석자들 공유
            if(isSeonYeong.isPresent()){
                newSong++;
                newSongSize++;
                for (int participant : participantArray) {
                    Set<Character> knownSongList = attendeeKnowSongList.getOrDefault(participant, new HashSet<>());
                    knownSongList.add(newSong);
                    attendeeKnowSongList.put(participant, knownSongList);
                }
            }else{
                // 모든 노래 취합
                Set<Character> tempSet = new HashSet<>();

                for (int key : participantArray) {
                    Set<Character> targetSet = attendeeKnowSongList.getOrDefault(key, new HashSet<>());
                    tempSet.addAll(targetSet);
                }

                for (int key : participantArray) {
                    Set<Character> targetSet = attendeeKnowSongList.getOrDefault(key, new HashSet<>());
                    targetSet.addAll(tempSet);
                    attendeeKnowSongList.put(key, targetSet);
                }

            }

        }

        Set<Integer> keySet = attendeeKnowSongList.keySet();
        for (Integer integer : keySet) {
            Set<Character> set = attendeeKnowSongList.getOrDefault(integer, new HashSet<>());
            if(set.size() == newSongSize){
                writer.append(String.valueOf(integer));
                writer.append("\n");
            }
        }

        writer.flush();

        reader.close();
        writer.close();
    }
}