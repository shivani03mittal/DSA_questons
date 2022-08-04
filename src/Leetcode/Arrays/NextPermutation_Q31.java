package Leetcode.Arrays;

public class NextPermutation_Q31 {
    class Solution {
        public void nextPermutation(int[] nums) {
//         next lexicographically greater arrangement
//         if legnth of aary is 0 or 1return itsel
            if(nums.length ==0 || nums.length ==1) return;

//         start from second last element to find 1st index where a[i]> ar[1+1]
            int i= nums.length-2;
            while(i>=0 && nums[i] >= nums[i+1])
                i--;

//         now find that first index which is smaler than the ith elemet
            if(i>=0)
            {
                int j= nums.length-1;
                while(nums[j]<= nums[i])
                    j--;

//             now swap those two
                swap(nums, i, j);
            }

//         now reverse the rest
            reverse(nums, i+1, nums.length-1);
        }

        public  void swap(int[] nums, int i, int j)
        {
            int temp = nums[i];
            nums[i]= nums[j];
            nums[j] = temp;
        }

        public  void reverse(int[] nums, int i, int j)
        {
            while(i<j)
            {
                swap(nums, i++, j--);
            }
        }
    }
}
