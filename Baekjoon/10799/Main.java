import java.io.*;
import java.util.*;
import java.util.stream.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Boolean> stack = new Stack<>();
        boolean status = false;
        char lastCharacter = '1';
        int answer = 0;


        String[] split = reader.readLine().split("");
        // 1. lastCharacter가 '(' 인데 현재가 ')' 이거면 레이저
        // 2. stack에서 숫자 하나 뺄때 혹은 status가 true -> false로 바뀔때 숫자 하나씩 더하기
        // 3. 레이저를 쏠대는 stack 만큼 더하기

        for (String string : split) {
            if(string.equals("(")){
                if(status){ // stack에 적재 시작
                    stack.add(true);
                }else{ // status 변경
                    status = true;
                }
            }else{
                if(lastCharacter == '('){ // stack 사이즈 만큼 자르기
                    if(!stack.isEmpty()){
                        answer += stack.size();
                        stack.pop();
                    }else{
                        status = false;
                    }
                }else{
                    if(stack.isEmpty()){
                        answer++;
                        status = false;
                    }else{
                        answer++;
                        stack.pop();
                    }
                }
            }
            lastCharacter = string.charAt(0);
        }

        writer.write(String.valueOf(answer));
        writer.flush();

        reader.close();
        writer.close();
    }
}