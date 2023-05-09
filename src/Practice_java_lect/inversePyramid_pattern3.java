package Practice_java_lect;

public class inversePyramid_pattern3 {
    public static void main(String[] args) {
        int n = 4;
        int row=1;
        int nsp = n-1;
        int nst = 1;
        while (row<= n)
        {
            int csp =1;
            while (csp<= nsp)
            {
                System.out.print(" ");
                csp++;
            }
            int cst =1;
            while (cst <= nst)
            {
                System.out.print("*");
                cst++;
            }

            row++;
            nsp --;
            nst ++;
            System.out.println();
        }
    }
}
