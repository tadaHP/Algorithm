import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = array[0];
        int K = array[1];
        int Q = array[2];

        List<Message> messages = new ArrayList<>();
        HashSet<Character> hashSet = new HashSet<>();

        for(int i = 1; i < N; i++) {
            hashSet.add((char) ('A' + i));
        }

        for (int i = 0; i < K; i++) {
            String[] input = reader.readLine().split(" ");
            int unReadCount = Integer.parseInt(input[0]);
            char person = input[1].charAt(0);
            messages.add(new Message(unReadCount, person));
        }

        Message questionMessage = messages.get(Q-1);

        if (questionMessage.getUnReadCount() == 0) {
            writer.write("-1");
            writer.flush();
            return;
        }

        // 1. 먼저 뒤에서부터,Q까지는 모두 읽음처리
        for (int i = Q - 1; i < messages.size(); i++) {
            Message message = messages.get(i);
            hashSet.remove(message.getPerson());
        }

        // 2. 목표치인 Q (Q-1) 부터 1까지 가면서, 읽은사람의 레벨이 같으면, 그사람도 읽은 사람으로 취급
        for(int i = Q - 1 ; i >= 1; i--) {
            Message currentMessage = messages.get(i);
            Message previousMessage = messages.get(i-1);

            if(currentMessage.getUnReadCount() != previousMessage.getUnReadCount()) {
                break;
            }else {
                hashSet.remove(previousMessage.getPerson());
                hashSet.remove(currentMessage.getPerson());
            }
        }

        if (hashSet.isEmpty()) {
            writer.write("-1");
        }else{
            List<Character> sortedList = new ArrayList<>(hashSet);
            Collections.sort(sortedList);
            String result = sortedList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
            writer.write(result);
        }


        writer.flush();
        reader.close();
        writer.close();
    }
    static class Message {
        private final int unReadCount;
        private final char person;

        public Message(int unReadCount, char person) {
            this.unReadCount = unReadCount;
            this.person = person;
        }

        public int getUnReadCount() {
            return unReadCount;
        }

        public char getPerson() {
            return person;
        }
    }
}