import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.stream.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean toBeContinue = true;

        while (toBeContinue) {
            String line = reader.readLine();
            if(line.equals("#")){
                toBeContinue = false;
                continue;
            }

            String lowerCase = line.toLowerCase();

            Pattern vowelPattern = Pattern.compile("[aeiou]");
            Matcher matcher = vowelPattern.matcher(lowerCase);

            int vowelCount = 0;
            while (matcher.find()) {
                vowelCount++;
            }

            writer.write(String.valueOf(vowelCount));
            writer.write("\n");
            
        }

        writer.flush();

        reader.close();
        writer.close();
    }
}