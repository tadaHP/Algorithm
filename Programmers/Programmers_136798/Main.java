package Programmers.Programmers_136798;

public class Main {
//    static int number = 5;
//    static int limit = 3;
//    static int power = 2;

    static int number = 10;
    static int limit = 3;
    static int power = 2;

    public static void main(String[] args) {

        int answer = 1;
        int sqrt;
        int measure;
        int biggestMeasure = 1;

        for (int i = 2; i < number + 1; i++) {
            sqrt = (int) Math.sqrt(i);//have to check
            measure = 0;

            for (int j = 1; j < sqrt + 1; j++) { //get measure and add 2
                if (i % j == 0) {//if it is measure
                    measure += 2;
                    biggestMeasure = j;
                }
            }

            if((biggestMeasure*biggestMeasure)==i) //if biggest measure^2 = i then minus 1
                measure--;

            if(measure>limit)
                answer += power;
            else
                answer += measure;
        }
        System.out.println("answer: " + answer);

    }
}
