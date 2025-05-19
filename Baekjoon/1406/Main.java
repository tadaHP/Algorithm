import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> linkedList = new LinkedList<>();

        String initString = reader.readLine();

        for(int i = 0 ; i < initString.length(); i++){
            linkedList.add(initString.charAt(i));
        }

        ListIterator<Character> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }

        
        int size = Integer.parseInt(reader.readLine());

        for (int i = 0; i < size; i++) {

            String request = reader.readLine();
            char order = request.charAt(0);
            

            switch (order) {
                case 'P':
                    listIterator.add(request.charAt(2));
                    break;
                case 'B':
                    if(listIterator.hasPrevious()){
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                case 'D':
                    if(listIterator.hasNext()){
                        listIterator.next();
                    }
                    break;
                case 'L':
                    if(listIterator.hasPrevious()){
                        listIterator.previous();
                    }
                    break;
            }
            
        }

        for(Character character : linkedList){
            writer.write(character);
        }

        writer.flush();

        reader.close();
        writer.close();
    }
}