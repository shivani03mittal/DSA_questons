package Practice_java_lect;

public class Pattern1 {
    public static void main(String[] args) {
        int n = 4;
        int row =1;
        int nst= 5;
        while(row <= n)
        {
            int cst =1;
            while (cst<= nst)
            {
                if(row  ==1 || row == n || cst ==1 || cst == nst)
                    System.out.print("*");
                else
                    System.out.print(" ");
                cst++;
            }
            System.out.println();
            row++;
        }
    }
}
