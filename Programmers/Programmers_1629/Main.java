package Programmers.Programmers_1629;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static long c;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[1]);
        c = Long.parseLong(split[2]);

        System.out.println(pow(a,b));

    }

    private static long pow(long a, long e){
        if (e == 1){
            return a % c;
        }

        long pow = pow(a, e / 2);

        if (e%2==1){
            return (pow * pow % c ) * a % c;
        }

        return pow * pow % c;
    }
}
