import java.util.*;
import java.io.*;
import java.util.stream.Stream;

class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = reader.readLine().split(" ");
        String kingsPosition = split[0];
        String otherPosition = split[1];
        
        char kingX = kingsPosition.charAt(0);
        char kingY = kingsPosition.charAt(1);
        char otherX = otherPosition.charAt(0);
        char otherY = otherPosition.charAt(1);
        int count = Integer.parseInt(split[2]);

        // 이동 가능한지 확인
        // 1. 해당위치에 돌 놓을수 있는지
        // 2. 해당위치에 돌이 있는지 - 있다면 돌도 이동 가능한지

        for(int i = 0; i < count; i++){
            String[] request = reader.readLine().split("");
            for(int j = 0 ; j < request.length; j++){
                switch (request[j]) {
                    case "R": // X++
                        kingX++;
                        break;
                    case "L": // X --
                        kingX--;
                        break;
                    case "B":
                        kingY--;
                        break;
                    case "T":
                        kingY++;
                        break;
                }
            }

            // 왕의 위치가 합리적인지
            if(kingX >= 'A' && kingX <= 'H' && kingY >= '1' && kingY <= '8'){
            }else{
                for(int j = 0 ; j < request.length; j++){
                    switch (request[j]) {
                        case "R":
                            kingX--;
                            break;
                        case "L":
                            kingX++;
                            break;
                        case "B":
                            kingY++;
                            break;
                        case "T":
                            kingY--;
                            break;
                    }
                }
                continue;
            }
            // 왕이 돌과 부딪혔는지 확인
            if(kingX == otherX && kingY == otherY){
                // 돌도 위치 이동 및 확인
                for(int j = 0 ; j < request.length; j++){
                    switch (request[j]) {
                        case "R":
                            otherX++;
                            break;
                        case "L":
                            otherX--;
                            break;
                        case "B":
                            otherY--;
                            break;
                        case "T":
                            otherY++;
                            break;
                    }
                }
            }

            // 돌의 위치가 합리적인지
            if(otherX >= 'A' && otherX <= 'H' && otherY >= '1' && otherY <= '8'){
            }else{
                for(int j = 0 ; j < request.length; j++){
                    switch (request[j]) {
                        case "R":
                            kingX--;
                            break;
                        case "L":
                            kingX++;
                            break;
                        case "B":
                            kingY++;
                            break;
                        case "T":
                            kingY--;
                            break;
                    }
                }

                for(int j = 0 ; j < request.length; j++){
                    switch (request[j]) {
                        case "R":
                            otherX--;
                            break;
                        case "L":
                            otherX++;
                            break;
                        case "B":
                            otherY++;
                            break;
                        case "T":
                            otherY--;
                            break;
                    }
                }
            }

        }
    
        writer.write(kingX);
        writer.write(kingY);
        writer.write("\n");

        writer.write(otherX);
        writer.write(otherY);
        writer.write("\n");
        writer.flush();

        reader.close();
        writer.close();
    }

}