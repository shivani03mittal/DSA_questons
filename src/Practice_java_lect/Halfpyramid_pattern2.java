package Practice_java_lect;

public class Halfpyramid_pattern2 {
    public static void main(String[] args) {
        int n=4;
        int row=1;
//        while (row<= n)
//        {
//            int nst = row;
//            int cst =1;
//            while (cst<= nst)
//            {
//                System.out.print("*");
//                cst++;
//            }
//            row++;
//            System.out.println();
//        }
        int nst =4;
        while (row<= n)
        {
            int cst =1;
            while (cst<= nst)
            {
                System.out.print("*");
                cst++;
            }
            row++;
            nst--;
            System.out.println();
        }


    }
}
