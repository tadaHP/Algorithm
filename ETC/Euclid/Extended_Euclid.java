package ETC.Euclid;

public class Extended_Euclid {
    

    public static void main (String[] args) {
        
        expandEuclideanAlgorithm(69,30);
        // expandEuclideanAlgorithm(240,46);
        
    }
    ////////////////////////////////////////////////////////////////
    
    public static int euclideanAlgorithm (int big, int small) {

        if(Integer.compare(big, small)==0) return big;

        return euclideanAlgorithm(small, big%small);

    }

    public static void expandEuclideanAlgorithm (int big, int small) {
        
        int[] x = {1,0};
        int temp_x;
        int[] y = {0,1};
        int temp_y;
        int[] r = {big,small};
        int temp_r;
        int q;
        // if(q<0) q -= 1;

        while(!(Integer.compare(r[1], 0)==0)){
            q = r[0]/r[1];
            temp_r = r[0]-(r[1]*q);
            temp_x = x[0]-(x[1]*q);
            temp_y = y[0]-(y[1]*q);

            System.out.println("r1: "+ r[0] + " r2: " + r[1] + " r: " + temp_r);
            System.out.println("x1: "+ x[0] + " x2: " + x[1] + " x: " + temp_x);
            System.out.println("y1: "+ y[0] + " y2: " + y[1] + " y: " + temp_y);
            System.out.println("q: " + q);

            r[0] = r[1];
            r[1] = temp_r;

            x[0] = x[1];
            x[1] = temp_x;

            y[0] = y[1];
            y[1] = temp_y;

            

            System.out.println();
            try{Thread.sleep(1000);}
            catch (Exception e ){

            }
        }  
    }
}
