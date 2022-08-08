package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumMutiple {
    public static void main(String[] args) {

        int[] A = {-11 ,8 ,10, 9, -19, -8, 19, -14};
//                { -12, 17, -13, 17 };
        int N = 8;

        long ans = maximumMultiple(N, A);
        System.out.println(ans);
    }

    public static long maximumMultiple(int N, int[] A) {
        // code here
        ArrayList<Long> B = new ArrayList<>();
        ArrayList<Integer> all= new ArrayList<Integer>();
        long max =0;

        for(int i=0; i<N;i++)
        {
            all.add(A[i]);
        }
//        System.out.println(all);

        for(int i=0;i< N/2;i++) {
            int n1 = Collections.min(all);
            int n2 = Collections.max(all);
//
            long p = n1 * n2;
            System.out.println(n1 + " " + n2 + " " + p);
            B.add(p);
            all.remove(Integer.valueOf(n1));
            all.remove(Integer.valueOf(n2));
        }


//
        max = Collections.max(B);


        return max;





    }
}
