import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main{

    static List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'h');
    static List<String> targetList = Arrays.asList("c", "j", "n", "m", "t", "s", "l", "d", "qu");


    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String phrase = reader.readLine();

        //1. 띄어쓰기, - 기준으로 분리
        String[] splited = phrase.split("[\\s-]+");
        List<String> wordsWithApostrophe = Arrays.stream(splited)
            .filter(word -> word.contains("'"))
            .collect(Collectors.toList());

        int addedCount = 0;

        for(String word : wordsWithApostrophe){
            String[] split = word.split("'");
            String front = split[0];
            String back = split[1];
            if(targetList.contains(front)){
                // 뒤 단어가 모음으로 시작하는지 확인
                if(vowelList.contains(back.charAt(0))){
                    addedCount++;
                }
            }
        }

        addedCount += splited.length;

        writer.write(String.valueOf(addedCount));

        reader.close();
        writer.close();
    }
}