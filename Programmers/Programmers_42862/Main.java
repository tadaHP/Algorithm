package Programmers.Programmers_42862;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve ={3, 1};

        int[] student = new int[n];
        int answer = n;

        for(int i : lost)
            student[i-1] = -1;
        for(int i : reserve)
            student[i-1] +=1 ;

            
        for(int i = 0 ; i < student.length ; i++){
            if(student[i] == -1){
                if(i>0 && student[i-1]==1)
                    student[i-1] -= 1;
                else if(i<n-1 && student[i+1] == 1)
                    student[i+1] -= 1;
                else
                    answer--;
            }
        }
        System.out.println(answer);
    }
}