package Leetcode.Arrays;

public class MaximumSubaary_Q53 {
    class Solution {
        public int maxSubArray(int[] nums) {

            int maxsum=nums[0];
            int sum=0;

//         strat traversing and adding whenever sum -s -ve sum =0 also keep updating maxsum

            for(int i=0;i<nums.length;i++)
            {
                sum = sum +nums[i];
                if(sum > maxsum)
                    maxsum= sum;
                if(sum <0)
                    sum =0;
            }

//         return maxsum

            return maxsum;
        }
    }
}
