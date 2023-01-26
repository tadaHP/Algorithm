package Programmers.Programmers42626;

import java.util.PriorityQueue;

public class Main {

    static int[] scoville1 = {9, 10, 12,1, 2, 3};
    static int k1 = 7;

    static int[] scoville2 = {1,1};
    static int k2 = 3;
    //1

    /**
     *매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
     * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     */
    public static void main(String[] args) {

        System.out.println(solution(scoville1, k1));

        System.out.println(solution(scoville2, k2));


    }

    static int solution(int[] scoville, int K) {
        int answer = 0;
        int minimunScoville;
        int secondMinScoville;
        int newScoville;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : scoville) {
            minHeap.add(i);
        }

        while (minHeap.peek() < K) {
            minimunScoville = minHeap.remove();
            secondMinScoville = minHeap.remove();


            newScoville = minimunScoville + (secondMinScoville * 2);

            minHeap.add(newScoville);
            answer++;
            if (minHeap.size()<2) {
                if (minHeap.poll() > (K-1)) {
                    break;
                }
                answer = -1;
                break;
            }
        }

//        for (Integer integer : minHeap) {
//            System.out.println(integer);
//        }



        return answer;
    }

}
