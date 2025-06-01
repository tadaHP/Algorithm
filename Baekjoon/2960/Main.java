import java.util.*;
import java.io.*;
import java.util.stream.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        int k = array[1];

        boolean[] isDeleted = new boolean[n + 1];
        int lastP = 2;
        int answer = -1;

        while(k > 0){
            // 현재 lastP 기준으로 배수를 모두 지우기
            int p = lastP;
            int i = 1;
            while(p*i <= n && k > 0){
                if(isDeleted[p * i]){
                    i++;
                    continue;
                }
                isDeleted[p * i] = true;
                answer = p * i;
                i++;
                k--;
            }
            // lastP를 다음 소수로 업데이트 쳐주고
            while(lastP <= n && isDeleted[lastP]){
                lastP++;
            }

        }

        writer.write(String.valueOf(answer));

        reader.close();
        writer.close();
    }
}