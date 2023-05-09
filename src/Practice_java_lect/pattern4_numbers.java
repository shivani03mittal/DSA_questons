package Practice_java_lect;

public class pattern4_numbers {
    public static void main(String[] args) {
        int n = 5;
        int row =1;
        int nst=1;
        int val=1;
        while (row<= n)
        {
            int cst =1;
            while (cst<= nst)
            {
                System.out.print(val+" ");
                cst++;
                val++;
            }
            row++;
            nst++;
            System.out.println();
        }
    }
}
