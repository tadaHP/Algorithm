import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 괄호쌍 안에 있는 모든 괄호를 제거하는 방법 (조합)

        // 먼저 괄호의 위치를 찾아서 쌍으로 만들어 둔다
        String line = reader.readLine();

        Stack<Integer> startStack = new Stack<>();
        ArrayList<PositionPair> pairInfo = new ArrayList<>();

        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            if(c == '('){
                startStack.push(i);
            } else if(c == ')'){
                int start = startStack.pop();
                int end = i;
                pairInfo.add(new PositionPair(start, end));
            }
        }

        // 괄호쌍 안에 있는 모든 괄호를 제거 방법 (조합)
        TreeSet<String> resultSet = new TreeSet<>();
        boolean[] visited = new boolean[pairInfo.size()];
        generateCombinations(visited, pairInfo, resultSet, line, 0);

        for (String s : resultSet) {
            writer.write(s);
            writer.newLine();
        }

        writer.flush();
        reader.close();
        writer.close();
    }

    public static void generateCombinations(boolean[] visited, ArrayList<PositionPair> pairInfo, TreeSet<String> resultSet, String originalExpression, int deep) {
    if (deep == pairInfo.size()) {
        boolean hasRemoved = false;
        for (boolean b : visited) {
            if (b) {
                hasRemoved = true;
                break;
            }
        }
        if (hasRemoved) {
            StringBuilder sb = new StringBuilder();
            boolean[] toRemove = new boolean[originalExpression.length()];

            for (int i = 0; i < pairInfo.size(); i++) {
                if (visited[i]) {
                    PositionPair pair = pairInfo.get(i);
                    toRemove[pair.start] = true;
                    toRemove[pair.end] = true;
                }
            }

            for (int i = 0; i < originalExpression.length(); i++) {
                if (!toRemove[i]) {
                    sb.append(originalExpression.charAt(i));
                }
            }
            resultSet.add(sb.toString());
        }
        return;
    }

    visited[deep] = true;
    generateCombinations(visited, pairInfo, resultSet, originalExpression, deep + 1);

    visited[deep] = false;
    generateCombinations(visited, pairInfo, resultSet, originalExpression, deep + 1);
}


    public static class PositionPair{
        int start;
        int end;

        public PositionPair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}