package Programmers.Programmers42628;

import java.util.*;
import java.util.stream.Stream;


public class Main {
    static final String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; // answer {0,0}
    static final String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; // answer {333, -45}

//    static final String[] operations3 = {"I 1", "I 3", "I 5", "I 7", "I 9", "D -1", "D -1", "D 1", "I 2", "D 1", "D 1"}; // answer {2, 2}

    static final String[] operations4 = {"I 1", "I 2", "I 3", "I 4", "D -1", "D 1", "D -1"};// answer{3, 3}

    static final String[] operations5 = {"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1", "I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1"};
    //answer {8,3}

    static final String[] operations6 = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};//answer {6,5}

    static final String[] operations_test = {"I -45", "I 653","I -80", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; // answer {333, -45}

    public static void main(String[] args) throws Exception {


        int[] solution = solution(operations1);

        System.out.println("max = " + solution[0] + ", min = " + solution[1]);


    }

    static int[] solution(String[] operations) {
        int[] answer;


        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (String operation : operations) {

            String[] split = operation.split(" ");

            String function = split[0];
            int param = Integer.parseInt(split[1]);

            if (function.equals("I")) {//insert
                queue.add(param);
            } else if (function.equals("D") && queue.size() > 0) {
                if (param > 0) {// remove MaxValue
//                    Integer maxVal = Collections.max(queue);
                    Object[] queueToArray = queue.stream().sorted().toArray();
                    int maxVal = (int) queueToArray[queueToArray.length - 1];
                    queue.remove(maxVal);
                } else { //remove MinValue
                    queue.remove();
                }
            }
        }

        if (queue.size() == 0) {
            answer = new int[]{0, 0};
        } else{
            Object[] queueToArray = queue.stream().sorted().toArray();
            int max = (int) queueToArray[queueToArray.length - 1];
            int min = (int) queueToArray[0];
            answer = new int[]{max, min};
        }

        return answer;
    }
}

