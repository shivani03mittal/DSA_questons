package Practice_java_lect;

public class Pattern9_pallindrom {
    public static void main(String[] args) {
        int n = 5;
        int row =1;
        int nsp = n-1;
        int nst =1;
        while (row<=n)
        {
            int csp =1;
             while (csp <= nsp)
             {
                 System.out.print("  ");
                 csp++;
             }

             int cst=1;
             int val= row;
             while (cst <= nst)
             {
                 System.out.print(val+" ");
                 cst++;
                 val--;
                 if(val==0)
                     break;

             }
             int val1 =2;
             while (cst <= nst)
             {
                 System.out.print(val1+" ");
                 cst++;
                 val1++;
             }

            row++;
             nsp--;
             nst +=2;
            System.out.println();
        }
    }
}
