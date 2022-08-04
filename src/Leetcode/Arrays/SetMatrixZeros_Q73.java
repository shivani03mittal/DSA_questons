package Leetcode.Arrays;

public class SetMatrixZeros_Q73 {
    class Solution {
        public void setZeroes(int[][] matrix) {

//         edge case: corner is zero
            int col=1;//true
            int rowsize= matrix.length;
            int colsize= matrix[0].length;

//         traverse 1st time
            for(int i=0;i<rowsize;i++)
            {
//             check is 0thcolm of a row has zero or not
                if(matrix[i][0] == 0)
                {
                    col=0;
                }

                for(int j=1;j<colsize;j++)
                {
                    if(matrix[i][j]==0)
                    {
//                     set that pos to zero in 1st row and col
                        matrix[i][0]=0;
                        matrix[0][j]=0;

                    }
                }
            }

//         back traverse to put zeroes now
            for(int i =rowsize-1;i>=0;i--)
            {
                for(int j= colsize-1; j>=1;j--)
                {
                    if(matrix[i][0]==0 || matrix[0][j]==0)
                        matrix[i][j]=0;
                }

                if(col==0)
                    matrix[i][0]=0;
            }

        }
    }
}
