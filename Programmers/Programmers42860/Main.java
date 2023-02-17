package Programmers.Programmers42860;

import javax.swing.*;

public class Main {

    static String name1 = "JAZ";
    static String name2 = "JEROEN";
    static String name3 = "JAN";
    static String name5 = "ABABAAAAABA";



    public static void main(String[] args) {
        int solution = solution(name5);
        System.out.println(solution);
    }

    static int solution(String name) {
        int answer = 0;
        int minMove = name.length() - 1;
        int indexA = 0;

        //최소이동으로 알파벳 검색
        for (int i = 0; i < name.length(); i++) {
            char selectedChar = name.charAt(i);
            if(selectedChar != 'A'){
                answer += Math.min(selectedChar - 'A', 'Z' - selectedChar + 1);
            }

            indexA = i;
            try {
                while (name.charAt(indexA) == 'A') {
                    indexA++;
                }
            } catch (Exception e) {

            }

            if (i == 0) {
                minMove = Math.min(minMove, name.length() - indexA);// 전 후진 상관없이 시작이 A이면 뒤로도는게 빠르다
            } else {
                minMove = Math.min(minMove, 2 * (i - 1) + name.length() - indexA);// 전진일 때, i가 A를 가르킬 때, 앞으로 한칸가서(i-1) *2해주고(왕복) 전체길이에서 a까지 빼줌(뒤로 이동)

                // 후진일 때, 한칸 뒤로 간 후(i-1, i가 A를 가르킬때가 기준이기때문에 먼저 뒤로 가준다. 이 조건은 후진하다 돌아오는게 기준이기 때문에 i-1을 더한다) 전체길이에서 indexA까지 빼준후 *2를 해준다(뒤로가다가 A를 만나 다시 턴한경우)
                minMove = Math.min(minMove, i - 1 + (name.length() - indexA) * 2);
            }
        }

        answer += minMove;

        return answer;
    }
}
