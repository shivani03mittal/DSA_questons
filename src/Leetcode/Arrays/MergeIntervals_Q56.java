package Leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals_Q56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            ArrayList<int[]> arr= new ArrayList<>();
            int[][] mergedIntervals;
//         base case if no interval given return empty;
            if(intervals.length ==0 || intervals== null)
                return new int[0][];
//         sort array
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

//         keep a variable for first pair
            int s= intervals[0][0];
            int e= intervals[0][1];

            for(int[] a: intervals)
            {
//             is stating of nxt pair is smaller than ending of previous =>merge
                if(a[0] <= e)
                {
//                 merge
                    e = Math.max(e, a[1]);
                }
//          else add that pait to the ans list
                else {
                    arr.add(new int[]{s,e});
                    s=a[0];
                    e=a[1];
                }
            }

            arr.add(new int[] {s,e});
            return arr.toArray(new int[0][]);
        }
    }
}
