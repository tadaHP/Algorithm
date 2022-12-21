package Programmers.Programmers_120585;

public class Main {
//    static int[] array = {149, 180, 192, 170};
//    static int height = 167;

        static int[] array = {180, 120, 140};
        static int height = 190;

    public static void main(String[] args) {

        int answer = 0;
        for(int i : array){
            if (i>height) answer++;
        }

        System.out.println(answer);

    }
}
