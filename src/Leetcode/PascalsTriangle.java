package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    class Solution {
        public List<List<Integer>> generate(int n) {
//       create the returning list
            List<List<Integer>> triangle= new ArrayList<>();
//         create a temp list to add 1st row
            if(n==0) return triangle;

            List<Integer> first_row= new ArrayList<>();
//         add 1 to first row and first row to triangle
            first_row.add(1);
            triangle.add(first_row);

//         now run for loop to add other row
            for(int i=1; i<n;i++)
            {
//             for each row get prev row and ake a new list add 1 to that list at the
//             start and end.
                List<Integer> prev_row= triangle.get(i-1);
                List<Integer> curr_row= new ArrayList<Integer>();

                curr_row.add(1);
//             now iterate through elements of prev_row to add up and put in curr_row
                for(int j=1;j<i;j++)
                {
                    curr_row.add(prev_row.get(j-1)+prev_row.get(j));
                }

                curr_row.add(1);
                triangle.add(curr_row);
            }

            return triangle;

        }

    }
}
