import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());

        for (int i = 0; i < size; i++) {
            String line = reader.readLine();
            int solved = solved(line);
            // 문자열을 solved기준으로 앞에 문자열을 잘라서 기존 문자열 뒤에 거꾸로 붙이면 될듯
            String sub = line.substring(0, solved);
            StringBuilder sb = new StringBuilder(sub);
            sb.reverse();
            String result = line + sb.toString();
            writer.write(result);
            writer.write("\n");
        }

        writer.flush();
        reader.close();
        writer.close();
    }

    public static int solved(String line){
        for (int i = 0; i < line.length(); i++) {
            boolean isSame = true;
            int newCount = i;
            for (int j = line.length() - 1; newCount <= j; j--) {
                if(line.charAt(newCount) != line.charAt(j)){
                    isSame = false;
                    break;
                }
                newCount++;
            }
            if(isSame){
                return i;
            }
        }

        return line.length() -1;

    }
}