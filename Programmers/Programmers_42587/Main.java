package Programmers.Programmers_42587;

import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) {
        // int[] priorities = {2,1,3,2};
        // int location = 2;
        
        // int[] priorities = {1,1,9,1,1,1};
        // int location = 0;
        int[] priorities = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int location = 1;

        ////start


        int temp;
        boolean isBig;
        int count = 0;

        System.out.println("start");
        
        while(true){
            System.out.println();
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                
            }
            System.out.println("location: " + location);


            isBig = false;
            temp = priorities[0];
            System.out.println("priorities[0]: " + temp);
            for(int i = 1 ;i<priorities.length ; i++){
                if(priorities[i]>temp) isBig = true;
            }
            System.out.println("isBig: " + isBig);

            if(isBig) {
                System.out.println("isBig");
                swap_array(priorities, temp);
                
                if(Integer.compare(location, 0)==0){
                    location = priorities.length -1;
                    System.out.println("isBig and location is 0");
                }
                else location --;
                continue; // there is big priority then pass this
            }
            if(Integer.compare(location, 0)==0){
                count++;
                System.out.println("answer: " + count);
                break;
            }
            System.out.println("pop: " + priorities[0]);
            count++;
            priorities = remove(priorities, 0);
            location--;
        }

    }

    public static void swap_array(int[] array, int temp){
        for(int i = 0 ; i < array.length-1 ; i ++){
            array[i] = array[i+1];
        }
        array[array.length-1] = temp;
    }

    public static int[] remove(int[] array, int index)
    {
        if (array == null || index < 0 || index >= array.length)  return array;

        return IntStream.range(0, array.length)//size of stream
                        .filter(i -> i != index)// i가 index와 같으면 포함하지 않음
                        .map(i -> array[i])//a[i]째를 이용하여 맵핑
                        .toArray();//array로 출력
    }//https://www.techiedelight.com/ko/remove-element-specific-index-array-java/

}