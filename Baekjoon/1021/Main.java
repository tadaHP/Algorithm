import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] firstLine = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int queueSize = firstLine[0];
        int requestNumberSize = firstLine[1];

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= queueSize; i++) {
            deque.add(i);
        }

        int count = 0;
        int[] requestNumberArray = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < requestNumberArray.length; i++) {
            int requestNumber = requestNumberArray[i];
            int requestNumberIndex = deque.indexOf(requestNumber);

            final int dequeMiddle;
            if(deque.size() % 2 == 0) {
				dequeMiddle = deque.size() / 2 - 1;
			}
			else {
				dequeMiddle = deque.size() / 2;
			}

            if(requestNumberIndex <= dequeMiddle){
                for (int j = 0; j < requestNumberIndex; j++) {
                    rotateLeft(deque);
                    count++;
                }
            }else{
                for (int j = 0; j < deque.size() - requestNumberIndex; j++) {
                    rotateRight(deque);
                    count++;
                }
            }

            deque.removeFirst();
        }

        writer.write(String.valueOf(count));
        writer.flush();

        reader.close();
        writer.close();
    }


    private static void rotateRight(Deque<Integer> deque){
        int last = deque.removeLast();
        deque.addFirst(last);
    }


    private static void rotateLeft(Deque<Integer> deque){
        int first = deque.removeFirst();
        deque.addLast(first);
    }

}