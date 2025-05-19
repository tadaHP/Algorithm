import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class MainStack {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String initString = reader.readLine();
        for(int i = 0 ; i < initString.length(); i++){
            leftStack.add(initString.charAt(i));
        }

        int size = Integer.parseInt(reader.readLine());


        for (int i = 0; i < size; i++) {

            String request = reader.readLine();
            char order = request.charAt(0);
            

            switch (order) {
                case 'P':
                    leftStack.add(request.charAt(2));
                    break;
                case 'B':
                    if(leftStack.size()>0){
                        leftStack.pop();
                    }
                    break;
                case 'D':
                    if(rightStack.size()>0){
                        Character right = rightStack.pop();
                        leftStack.add(right);
                    }
                    break;
                case 'L':
                    if(leftStack.size()>0){
                        rightStack.add(leftStack.pop());
                    }
                    break;
            }
        }

        while (leftStack.size() > 0) {
            rightStack.add(leftStack.pop());
        }

        while (rightStack.size() > 0) {
            writer.write(rightStack.pop());
        }

        writer.flush();

        reader.close();
        writer.close();
    }
}
