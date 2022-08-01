package Leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_Q1 {

        public int[] twoSum(int[] nums, int target) {

            int[] ans = new int[2];
//         brute force
//         for(int i=0;i< nums.length;i++)
//         {
//             int sum = target - nums[i];
//             System.out.println(sum);
//             ans[0]=i;
//             for(int j=i+1;j<nums.length;j++)
//             {
//                 if(nums[j] == sum)
//                 {
//                     ans[1]=j;
//                     return ans;
//                 }
//             }
//         }

//         return ans;


//         optimised
//         two pointr can not be used as array mentioend is not sorted

//         hashmap
            Map<Integer, Integer> map = new HashMap<Integer,Integer>();
            for(int i=0;i<nums.length;i++)
            {
                if(map.containsKey(target - nums[i]))
                {
                    ans[0]= i;
                    ans[1]= map.get(target - nums[i]);
                    return ans;
                }

                map.put(nums[i],i);
            }

            return ans;
        }


}
