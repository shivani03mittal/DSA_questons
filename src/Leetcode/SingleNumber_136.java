package Leetcode;

public class SingleNumber_136 {
    class Solution {
        public int singleNumber(int[] nums) {
            //         can use hashmap (but  O(N) space)
//         can use XOR

            int result=0;;
            for(int i=0;i<nums.length;i++)
            {
                result= result ^ nums[i];
            }
            return result;
        }
    }
}
