package Programmers.Programmers42861;

import java.util.*;

public class Main {
    static int[][] costs1 = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};//{a, b ,cost}
    static int n1 = 4;

    public static void main(String[] args) {
        //a에서 b로 가는 길을 찾는데 이때 연결되어있음 거기라고 치고 거기부터 젤 짧은길 찾기

        System.out.println(solution(n1,costs1));


    }

    static int solution(int n, int[][] costs) {
        //init
        int answer = 0;
        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(o1 -> o1[2]));

        //Kruskal

        for (int i = 0; i < costs.length; i++) {

            if (find(parents, costs[i][0]) != find(parents, costs[i][1])) {
                union(parents, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }

        }

        return answer;
    }

    //UnionFind
    static int find(int[] parents, int i) {
        if (parents[i] == i) {//나랑 내부모랑 같은면 내가 부모
            return i;
        }

        return find(parents, parents[i]);
    }

    static void union(int[] parents, int a, int b) {
        int aParents = find(parents, a);
        int bParents = find(parents, b);

        if (aParents < bParents) {
            parents[bParents] = aParents;
        } else {
            parents[aParents] = bParents;
        }
    }


}
