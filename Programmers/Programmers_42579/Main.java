package Programmers.Programmers_42579;

import java.util.*;

public class Main { //priority 1. genres, 2. mostPlayed, 3. earlier

    static String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
    static int[] plays1 = {500, 600, 150, 800, 2500};
    //answer 4,1,3,0

    public static void main(String[] args) {

        int[] solution = solution(genres1, plays1);

        System.out.println("answer ");
        for (int i : solution) {
            System.out.println(i);
        }


    }

    static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int count = genres.length;
        ArrayList<Integer> answerArray = new ArrayList<>();

        HashMap<String, Integer> genresCount = new HashMap<>();


        for (int i = 0; i < count; i++) {
            genresCount.put(genres[i], genresCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> genreKeyList = new ArrayList<>(genresCount.keySet());

        genreKeyList.sort((o1, o2) -> genresCount.get(o2).compareTo(genresCount.get(o1)));

        for (String key : genreKeyList) {
            Map<Integer, Integer> temp = new HashMap<>();

            for (int i = 0; i < plays.length; i++) {
                if (key.equals(genres[i])) {
                    temp.put(i, plays[i]);// 몇번째곡 + 시간
                }
            }


            ArrayList<Integer> genreNumberArray = new ArrayList<>(temp.keySet());

            genreNumberArray.sort((o1, o2) -> (temp.get(o2).compareTo(temp.get(o1))));

            if (genreNumberArray.size() > 1) {//두개 이상일때
                if (temp.get(genreNumberArray.get(0)).equals(temp.get(genreNumberArray.get(1)))) {//길이가 같을때
                    if (genreNumberArray.get(0) > genreNumberArray.get(1)) {
                        answerArray.add(genreNumberArray.get(1));
                        answerArray.add(genreNumberArray.get(0));
                    } else {
                        answerArray.add(genreNumberArray.get(0));
                        answerArray.add(genreNumberArray.get(1));
                    }
                } else {//길이가 다를때
                    answerArray.add(genreNumberArray.get(0));
                    answerArray.add(genreNumberArray.get(1));
                }
            } else {//하나일때
                answerArray.add(genreNumberArray.get(0));
            }

        }

        answer = new int[answerArray.size()];
        for (int i = 0; i < answerArray.size(); i++) {
            answer[i] = answerArray.get(i);
        }


        return answer;
    }


}