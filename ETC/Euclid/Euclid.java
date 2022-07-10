package ETC.Euclid;


public class Euclid{
    public static void main(String[] args) {
        System.out.println(GCD(69, 30));
    }

    

    public static int GCD(int big, int small){
        
        
        System.out.println("Big: " + big + " Small: " + small);
        if(Integer.compare(small, 0)==0){
            return big;
        }
        return GCD(small,big % small);
    }
}