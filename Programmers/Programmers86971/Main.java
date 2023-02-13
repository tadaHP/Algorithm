package Programmers.Programmers86971;

public class Main {

    static int n1 = 9;
    static int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
    //answer 3

    public static void main(String[] args) {
        int solution = solution(n1, wires1);
        System.out.println(solution);
    }

    static int solution(int n, int[][] wires) { //wires 는 처음은 그래프의 번호, 두번째는 연결된 그래프로 이루어져 있다.
        int answer = Integer.MAX_VALUE;
        int[][] newWires = new int[n - 1][];
        /**
         * 무조건 node 0번(1번)부터 순회를 시켜서, 둘사이의 차이를 구함.
         * visited가 true인 것의 개수와 visited가 false인 것의 개수차이
         */

        for (int i = 0; i < n - 1; i++) {
            System.out.println();
            boolean visited[] = new boolean[n];
            int trueAnswer = 0;
            int falseAnswer = 0;

            // 와이어를 하나씩 끊어서 연결
            for (int j = 0; j < n - 1; j++) {
                newWires[j] = wires[j];
                if (i == j) {
                    newWires[j] = new int[]{-1}; // i번째 wires 는 연결 안함
                }
            }
            if (newWires[0][0] == -1) {
                dfs(newWires, visited, 1);
            } else {
                dfs(newWires, visited, 0);
            }

            for (boolean visit : visited) {
                if (visit) {
                    trueAnswer++;
                } else {
                    falseAnswer++;
                }
            }

            if (answer > Math.abs(trueAnswer - falseAnswer)) {
                answer = Math.abs(trueAnswer - falseAnswer);
            }




        }


        return answer;
    }

    static void dfs(int[][] wires, boolean[] visited, int index) {
        if(!visited[index]){
            visited[index] = true; //현재 방문처리

            for (int[] wire : wires) {
                if (wire[0] < 0) continue; // if null

                if (wire[0] - 1 == index) {//현재 index 와 wire 가 같다면
                    dfs(wires,visited,wire[1] - 1);
                } else if (wire[1] - 1 == index) {
                    dfs(wires,visited,wire[0] - 1);
                }
            }
        }
    }
}
