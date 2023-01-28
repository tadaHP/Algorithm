package Programmers.Programmers42628;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class AnswerSheet {

    static final String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; // answer {0,0}
    static final String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; // answer {333, -45}

//    static final String[] operations3 = {"I 1", "I 3", "I 5", "I 7", "I 9", "D -1", "D -1", "D 1", "I 2", "D 1", "D 1"}; // answer {2, 2}

    static final String[] operations4 = {"I 1", "I 2", "I 3", "I 4", "D -1", "D 1", "D -1"};// answer{3, 3}

    static final String[] operations5 = {"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1", "I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1"};
    //answer {8,3}

    static final String[] operations6 = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};//answer {6,5}

    public static void main(String[] args) {
        int[] solution = solution(operations6);

        System.out.println("max = " + solution[0] + ", min = " + solution[1]);
    }

    static int[] solution(String[] operations) {

        int[] answer = {};
        Queue<Integer> queue = new PriorityQueue<>();

        for (String i : operations) {
            if (i.charAt(0) == 'I') {
                queue.add(Integer.parseInt(i.substring(1).trim()));
            }
            else if (queue.size() > 0 && i.equals("D 1")) {
                Object[] arr = queue.toArray();
                Arrays.sort(arr);
                int max = (int) arr[arr.length - 1];
                queue.remove(max);
            }
            else if (queue.size() > 0 && i.equals("D -1")) {
                queue.remove();
            }
        }



        if(queue.size() == 0) {
            answer = new int[]{0, 0};
        }
        else {
            Object[] arr = queue.toArray();
            Arrays.sort(arr);
            int max = (int) arr[arr.length - 1];
            int min = (int) arr[0];
            answer = new int[]{max, min};
        }

        return answer;

    }

}
