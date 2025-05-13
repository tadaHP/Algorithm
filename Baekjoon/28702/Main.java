import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean isNumber = false;
        int number = -1;
        int iteration = 0;

        for (; iteration < 3; iteration++) {
            String line = reader.readLine();
            char firstCharacter = line.charAt(0);
            if(firstCharacter == 'F' || firstCharacter == 'B'){

            }else{
                isNumber = true;
            }
            if(isNumber){
                number = Integer.parseInt(line);
                iteration++;
                break;
            }
        }

        while(iteration < 3){
            number ++;
            iteration++;
        }

        number++;

        if(number % 3 == 0){
            if(number % 5 == 0){
                writer.write("FizzBuzz");
            }else{
                writer.write("Fizz");
            }
        }else if(number % 5 == 0){
            if(number % 3 == 0){
                writer.write("FizzBuzz");
            }else{
                writer.write("Buzz");
            }
        }else{
            writer.write(String.valueOf(number));
        }
        writer.flush();

        reader.close();
        writer.close();
    }
}