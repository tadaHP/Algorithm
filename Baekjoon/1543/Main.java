import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = reader.readLine();

        String target = reader.readLine();

        Pattern pattern = Pattern.compile(Pattern.quote(target));
        Matcher matcher = pattern.matcher(line);

        int answer = 0;
        int index = 0;
        while (matcher.find(index)) {
            answer++;
            index = matcher.end();
        }

        writer.write(String.valueOf(answer));
        writer.flush();

        reader.close();
        writer.close();
    }
    
}