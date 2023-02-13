package Programmers.Programmers87946;

public class Main {

    static final int k1 = 80;
    static final int[][] dungeons1 = {{80, 20}, {50, 40}, {30, 10}};
    public static void main(String[] args) {

        System.out.println(solution(k1, dungeons1));

    }

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        int dungeonSize = dungeons.length;
        boolean visited[] = new boolean[dungeonSize];

        answer = backTrackingSolution(dungeons, visited, dungeonSize, k, 0);


        return answer;
    }

    static int backTrackingSolution(int[][] dungeons, boolean[] visited, int size,int fatigue, int round) {// 던전, 방문지역, 던전크기, 깊이, 피로도, 라운드(정답)
        int returnRound = 0;

        for (int i = 0; i < size; i++) {
            int calRound = 0;
            int presentRound = 0;
            if (!visited[i] && fatigue - dungeons[i][0] >= 0) {//방문하지 않았는데 피로도가 충족한다면
                visited[i] = true; //방문
                calRound = backTrackingSolution(dungeons, visited, size,fatigue-dungeons[i][1], round+1); //다음 계산

                visited[i] = false;
            }

            for (boolean b : visited) { // 현재 방문 몇개했는지 계산
                if (b) {
                    presentRound++;
                }
            }

            returnRound = Math.max(returnRound, Math.max(calRound, presentRound));


        }
        // req, use
        // [80,20] f
        // [50,40] f
        // [30,10] f


        return returnRound;

    }
}
