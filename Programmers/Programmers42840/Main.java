package Programmers.Programmers42840;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final int[] answer1 = {1, 2, 3, 4, 5};//1

    static final int[] answer2 = {1,3,2,4,2};//1,2,3

    public static void main(String[] args) {
        int[] solution = solution(answer1);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int[] answers) {
        int[] answer;
        int max = -1;

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] correct = new int[3];

        correct[0] = calculator(answers, p1);
        correct[1] = calculator(answers, p2);
        correct[2] = calculator(answers, p3);

        List<Integer> answerList = new ArrayList<>();

        for (int i : correct) {
            if (max < i) {
                max = i;
            }
        }
        for (int i = 0; i < correct.length; i++) {
            if (correct[i] == max) {
                answerList.add(i + 1);
            }
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }



        return answer;
    }

    static int calculator(int[] answer, int[] sheet) {
        int returnValue = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == sheet[i % sheet.length]) {
                returnValue++;
            }
        }

        return returnValue;
    }


}
