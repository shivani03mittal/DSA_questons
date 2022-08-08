package Leetcode;

public class SingleElementinSortedArray_Q540 {
    class Solution {
        public int singleNonDuplicate(int[] nums) {

//         XOR is also one approach
//         int ans = nums[0];
//         for(int i=1; i<nums.length;i++)
//         {
//             ans = ans ^ nums[i];
//         }

//         return ans;

//         vinary search + Xor
            int start = 0;
            int end = nums.length-2;
            while(start <= end)
            { int mid = (start + end) /2;
                if(nums[mid]== nums[mid^1])
                    start = mid+1;

                else
                    end = mid -1;
            }
            return nums[start];
//         bonary search check mid mid+1 and mid -1 if any same then not that one goes on left
//         as well right side
//         int start = 0;
//         int end = nums.length-1;
//         while(start <= end)
//         { int mid = (start + end) /2;
//             if(mid %2 ==0)
//             {
//                 if(nums[mid-1] == nums[mid]) // fo at 0dd
//                 {
// //                     right half
// //                     go to wards left
//                     end = mid-1;
//                 }
//                 else if (nums[mid+1] == nums[mid])//fo at even at so at odd
//                 {
// //                     left half
//                     start = mid+1;
//                 }

//                 else
//                     return nums[mid];
//             }

//             else
//             {
//                 if(nums[mid-1] == nums[mid]) // fo at even
//                 {

// //                    left half
//                     start = mid-1;
//                 }
//                 else if (nums[mid+1] == nums[mid])//fo at odd at so at even
//                 {
// //                     right half
//                     end = mid+1;

//                 }
//                 else
//                     return nums[mid];
//             }
//         }

            // return nums[start];


        }
    }
}
