package Leetcode.Arrays;

public class RotateImage_Q48 {
    class Solution {
        public void rotate(int[][] mat) {

//         transpose
            int n = mat.length;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<i;j++)
                {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i]= temp;
                }
            }

//         rverse each row
            for(int i=0;i<n;i++)
            {
                int s= 0;
                int e = n-1;
                while(s<e)
                {
                    int temp = mat[i][s];
                    mat[i][s] = mat[i][e];
                    mat[i][e]= temp;
                    s++;
                    e--;
                }
            }
        }
    }

}
