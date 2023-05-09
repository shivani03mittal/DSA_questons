package Leetcode.DP;

import java.util.ArrayList;

public class Q300_LongestIncreasingSubsequense {
   public static class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return Lis_td(nums,0,-1,new Integer[nums.length][nums.length+1]);
//     }
//      public static int Lis_td(int[] arr, int s, int prev, Integer[][] dp){

//         if(s== arr.length) {
// //            System.out.println(path);
//             return 0;
//         }
//         //since -1 is not possoble for arr so pprev+1;
//         if(dp[s][prev+1] != null) return dp[s][prev+1];
//         //include only if greater
//         int sp1=0;
//         if(prev ==-1 || arr[s] >arr[prev]) {
//             //included
//             sp1 = 1 + Lis_td(arr, s + 1, s,dp);
//         }
//         //excluded
//         int sp2 = Lis_td(arr,s+1,prev, dp);
//         dp[s][prev+1]= Math.max(sp1,sp2);
//         return Math.max(sp1,sp2);

        //     }
        public static int lengthOfLIS(int[] arr){
            ArrayList<Integer> al = new ArrayList<>();
            for(int ali : arr){
                int idx = BinarySearch(al, ali);
                if(idx== al.size()) al.add(ali);
                else
                    al.set(idx,ali);
                // System.out.println(al);
            }
            return al.size();
        }
        public static int BinarySearch(ArrayList<Integer> al , int ali)
        {
            int ans = al.size();
            int s = 0;
            int e = al.size()-1;
            while (s<= e)
            {
                int mid = (s+e)/2;
                if(al.get(mid) >= ali){
                    ans = mid;
                    e = mid-1;
                }else {
                    s = mid+1;
                }
            }
            return ans;
        }
    }
}
