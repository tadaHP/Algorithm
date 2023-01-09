package Programmers.Programmers_42579;

import java.util.*;

public class Answer {

    static String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
    static int[] plays1 = {500, 600, 150, 800, 2500};

    public static void main(String[] args) {

        int[] solution = solution(genres1, plays1);


        for (int i : solution) {
            System.out.println(i);
        }


    }

    static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        //정답을 담는 리스트
        ArrayList<Integer> result = new ArrayList<>();

        //장르, 재생수
        Map<String, Integer> count = new HashMap<>();

        //징르마다 재생횟수 계산
        for (int i = 0 ; i < genres.length; i++) {
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
        }

        //장르값을 key list 로 가져옴
        List<String> keySetList = new ArrayList<>(count.keySet());

        //장르별 재생횟수(value)만큼 내림차순 정렬
        // object1, object2 두개를 비교하는 방법을 람다식으로 우측에 정의함
        keySetList.sort((o1, o2) -> (count.get(o2).compareTo(count.get(o1))));

        for(String key : keySetList){
            //곡번호, 재생수
            Map<Integer, Integer> temp = new HashMap<>();
            for(int i = 0; i < plays.length; i++){
                if(key.equals(genres[i])){
                    temp.put(i, plays[i]);
                }
            }

            //해당 장르에 대해 길이별 sort 같을경우 자동으로 원위치
            List<Integer> genrekeys = new ArrayList<>(temp.keySet());
            genrekeys.sort((o1, o2) -> (temp.get(o2).compareTo(temp.get(o1))));

            if(genrekeys.size() >= 2){//일반적인경우
                if(temp.get(genrekeys.get(0)).equals(temp.get(genrekeys.get(1)))){//두 곡의 재생수가 같은경우
                    if (genrekeys.get(0) > genrekeys.get(1)) {//키 번호를 비교
                        result.add(genrekeys.get(1));
                        result.add(genrekeys.get(0));
                    }
                }
                else{
                    result.add(genrekeys.get(0));
                    result.add(genrekeys.get(1));
                }
            }
            else{//장르 곡이 하나인 경우
                result.add(genrekeys.get(0)); //어차피 0번 말고 없음
            }
        }

        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }


        return answer;
    }


}
