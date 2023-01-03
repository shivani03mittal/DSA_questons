import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Interview {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter sizes for array A and B ");
        int sizeA = scn.nextInt();
        int sizeB = scn.nextInt();

        int[] A = new int[sizeA];
        int[] B = new int[sizeB];
        System.out.println("Enter elemnets in arrays make sure those are in incresing order:");
        for (int i = 0; i < sizeA; i++) {
            A[i] = scn.nextInt();
        }

        for (int i = 0; i < sizeB; i++) {
            B[i] = scn.nextInt();
        }

//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(B));

        ArrayList<Integer> all = new ArrayList<>();
        all.add(A[0]);
        arrangements(A, B, sizeA, sizeB, all, 1, 0, 0, true);
    }

    public static void arrangements(int[] A, int[] B, int nA, int nB, ArrayList<Integer> all, int idxa, int idxb, int curr, boolean Apresent) {
//        first element from A
//        last element from B
//        all have to increasing in order
//        can be of size form 2 till arrays exhaust

//        base case
        if(idxa == nA) {
//            System.out.println(all);
            return;
        }
        if(idxb == nB) {
//            System.out.println(all);
            return;
        }

//        first call to add element from a
        if(Apresent)
        {
            if(all.get(curr) < B[idxb])
            {
                all.add(B[idxb]);
                System.out.println(all);
                arrangements(A,B,nA,nB,all,idxa,idxb+1,curr+1, false);

//
                all.remove(curr);
//                System.out.println(all);
                arrangements(A,B,nA,nB,all,idxa+1,idxb+1,curr, true);
            }
            else
                arrangements(A,B,nA,nB,all,idxa,idxb+1,curr, true);
        }



        else
        {
            if(all.get(curr) < A[idxa])
            { all.add(A[idxa]);

            System.out.println(all);
            arrangements(A, B, nA, nB, all, idxa + 1, idxb, curr + 1, true);

//            removing
//                all.remove(curr);
//                Apresent = false;
                all.remove(curr);
//                System.out.println(all);
                arrangements(A,B,nA,nB,all,idxa+1,idxb+1,curr, false);
            }
            else
                arrangements(A,B,nA,nB,all,idxa+1,idxb,curr, false);

        }



    }
}
