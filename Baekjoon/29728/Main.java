import java.util.*;
import java.io.*;
import java.util.stream.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());

        Deque<Character> deque = new ArrayDeque<>();
        boolean[] primeChecker = new boolean[size + 1];
        boolean isLeft = true; // 위치, false면 오른쪽에 입력

        // 최초 1일때
        deque.add('B');

        for (int i = 2; i <= size; i++) {
            if(primeChecker[i]){ // 소수가 아닌경우
                if (isLeft) {
                    deque.addFirst('B');
                } else {
                    deque.addLast('B');
                }
            }else{ // 소수인경우
                checkIsNotPrime(i, primeChecker); //소수 판별 가능하게 숫자 입력
                // 위치에 따라 전에값 peek해서 보고, S로 바꾸기, 이후에 S입력
                if (isLeft) {
                    Character peekLeft = deque.peekFirst();
                    if(peekLeft == 'B'){
                        deque.removeFirst();
                        deque.addFirst('S');    
                    }
                    deque.addFirst('S');
                    isLeft = !isLeft;
                }else{
                    Character peekRight = deque.peekLast();

                    if(peekRight == 'B'){
                        deque.removeLast();
                        deque.addLast('S');
                    }
                    deque.addLast('S');
                    isLeft = !isLeft;
                }
            }
            
        }

        int sCount = 0;
        int bCount = 0;
        // deque을 돌면서, S랑 B를 카운트
        while(deque.isEmpty() == false){
            Character c = deque.pollFirst();
            if(c == 'S'){
                sCount++;
            }else{
                bCount++;
            }
        }

        writer.write(String.valueOf(bCount));
        writer.write(" ");
        writer.write(String.valueOf(sCount));

        writer.flush();

        reader.close();
        writer.close();
    }

    private static void checkIsNotPrime(int value, boolean[] primeChecker) {
        int i = 1;
        int v = value;
        while (v < primeChecker.length) {
            primeChecker[v] = true;
            i++;
            v = value * i;
        }

    }
}