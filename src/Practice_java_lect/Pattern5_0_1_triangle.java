package Practice_java_lect;

public class Pattern5_0_1_triangle {
    public static void main(String[] args) {

        int n = 5;
        int row=1;
        int col =1;
        while (row <= n)
        {
            int cst=1;
            while (cst<= col)
            {
                if((cst+row) %2==0)
                {
                    System.out.print("1 ");
                }
                else
                    System.out.print("0 ");

                cst++;
            }

            row++;
            col++;
            System.out.println();
        }
    }
}
