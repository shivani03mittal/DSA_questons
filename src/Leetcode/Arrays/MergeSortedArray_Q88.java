package Leetcode.Arrays;

public class MergeSortedArray_Q88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

//         insertion sort


//         finding index
            for(int i=0;i<nums2.length;i++)
            {
                int toinsert= i;
                int toInsertVal = nums2[toinsert];
                int j = m+i-1;
                while(j >=0 && toInsertVal < nums1[j])
                {
                    nums1[j+1]=nums1[j];
                    j--;

                }
                nums1[j+1]= toInsertVal;
                // System.out.println(Arrays.toString(nums1));

            }


        }
    }
}
