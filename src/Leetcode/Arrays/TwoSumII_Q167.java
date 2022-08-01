package Leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII_Q167 {

        public int[] twoSum(int[] numbers, int target) {

//         int[] ans = new int[2];
//         // two pointer
// //         o(nlogn);
//         Arrays.sort(numbers);
//         int start=0;
//         int end = numbers.length-1;
//         while(start<end)
//         {
//             if(numbers[start]+ numbers[end]== target)
//             {
//                 ans[0]= start+1;
//                 ans[1]= end+1;
//                 return ans;
//             }
//             else if(numbers[start]+ numbers[end]>target)
//                 end--;
//             else
//                 start++;
//         }

//         return ans;

//         hashmap
            int[] ans = new int[2];
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            for(int i=0;i<numbers.length;i++)
            {
                if(map.containsKey(target-numbers[i]))
                {
                    ans[1]=i+1;
                    ans[0]=map.get(target-numbers[i])+1;
                    return ans;
                }

                map.put(numbers[i],i);
            }
            return ans;
        }
    }

