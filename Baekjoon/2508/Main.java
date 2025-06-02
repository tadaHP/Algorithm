import java.util.*;
import java.io.*;

class Main{
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final char HORIZON_START_CHAR = '>';
    public static final char HORIZON_END_CHAR = '<';
    public static final char MIDDLE_CHAR = 'o';
    public static final char VERTICAL_START_CHAR = 'v';
    public static final char VERTICAL_END_CHAR = '^';
    
    public static void main(String[] args) throws IOException{
        
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseSize = Integer.parseInt(reader.readLine());

        for(int i = 0; i < testCaseSize; i++){
            // 초기화 시킨후 solve 보내기
            reader.readLine();
            int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            char[][] testCase = createTestCase(size);
            int result = solve(testCase);
            writer.write(String.valueOf(result) + "\n");
        }

        writer.flush();

        reader.close();
        writer.close();
    }

    public static char[][] createTestCase(int[] size) throws IOException{
        char[][] testCase = new char[size[0]][size[1]];
        for (int i = 0; i <testCase.length ; i++) {
            String line = reader.readLine();
            for (int j = 0; j < testCase[i].length; j++) {
                testCase[i][j] = line.charAt(j);
            }
        }

        return testCase;
    }



    public static int solve(char[][] testCase){
        int result = 0;

        for(int i = 0; i < testCase.length; i++){
            for(int j = 0; j < testCase[i].length; j++){
                if(testCase[i][j]==HORIZON_START_CHAR){
                    if(j+2 < testCase[i].length && testCase[i][j+1] == MIDDLE_CHAR && testCase[i][j+2] == HORIZON_END_CHAR){
                        result++;
                    }
                }
                if(testCase[i][j]==VERTICAL_START_CHAR){
                    if(i+2 < testCase.length && testCase[i+1][j] == MIDDLE_CHAR && testCase[i+2][j] == VERTICAL_END_CHAR){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
