package Leetcode.Arrays;

public class FindTheDuplicateNumber_Q287 {
    class Solution {
        public int findDuplicate(int[] arr) {
//         sort and traverse
            // Arrays.sort(arr);
//         for(int i =0; i<arr.length;i++)
//         {
//             if(arr[i]== arr[i+1])
//                 return arr[i];
//         }

//         return -1;

// we will refer to index from the traversal of the aary
            for(int i=0;i<arr.length;i++)
            {
                int idx= Math.abs(arr[i])-1;
                if(arr[idx] <0)
                    return idx+1;
                arr[idx] = -arr[idx];
            }

            return -1;

        }
    }
}
