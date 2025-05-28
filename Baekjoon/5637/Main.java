import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // [^xy]
        int max = 0;
        String answer = "";

        boolean isContinue = true;

        while (isContinue) {
            String[] split = reader.readLine().trim().split(" ");

            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].replaceAll("[^a-zA-Z-]", " ").trim();
                String[] target = split[i].split(" ");

                for (int j = 0; j < target.length; j++) {
                    if (target[j].equals("E-N-D")) {
                        isContinue = false;
                        break;
                    }

                    if (target[j].length() > max) {
                        max = target[j].length();
                        answer = target[j].toLowerCase();
                    }
                }
            }
        }

        writer.write(answer + "\n");

        reader.close();
        writer.close();
    }
}
