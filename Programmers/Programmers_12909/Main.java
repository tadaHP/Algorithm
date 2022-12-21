package Programmers.Programmers_12909;

import java.util.Stack;

public class Main {

    //True
//    static String s = "()()";
//    static String s = "(())()";

    //False
//    static String s = ")()(";
    static String s = "(()(";

    public static void main(String[] args) {
        boolean answer = true;
        int num = 0;
        char temp;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp == '(') {
                num--;
                if (num < 0) {
                    answer = false;
                }
            }
            else {
                num++;
            }
        }

        if(num>0)
            answer = false;


    }
}
