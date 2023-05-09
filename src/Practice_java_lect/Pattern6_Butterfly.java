package Practice_java_lect;

public class Pattern6_Butterfly {
    public static void main(String[] args) {

        int n =4;
        int row=1;
        int nst =1;
        int nsp = n+2;
        while (row<= 2*n+1)
        {
            int cst1=1;
            while (cst1 <= nst)
            {
                System.out.print("* ");
                cst1++;
            }

            int csp=1;
            while (csp<= nsp)
            {
                System.out.print("  ");
                csp++;
            }

            int cst2= cst1-1;
            while (cst2 >0)
            {
                System.out.print("* ");
                cst2--;
            }

            System.out.println();
            row++;
            if(row >= n+1)
            {
                nsp+=2;
                nst--;
            }
            else {
                nst++;
                nsp-=2;
            }
        }
    }
}
