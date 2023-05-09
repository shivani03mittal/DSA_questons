package Practice_java_lect;

public class Pattern7_solidrhombus {
    public static void main(String[] args) {
        int n=5;
        int row=1;
        int nsp = n-1;
        int nst= n;
        while (row<= n)
        {
            int csp =1;
            while (csp<= nsp)
            {
                System.out.print(" ");
                csp++;
            }
            int cst =1;
            while (cst<= nst)
            {
                System.out.print("* ");
                cst++;
            }
            row++;
            nsp --;
            System.out.println();
        }
    }
}
