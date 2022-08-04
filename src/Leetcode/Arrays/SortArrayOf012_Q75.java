package Leetcode.Arrays;

public class SortArrayOf012_Q75 {
    class Solution {
        public void sortColors(int[] nums) {

//         couting sort : not in one pass
//         int ones=0;
//         int two=0;
//         int zeroes=0;
//         for(int i=0; i<nums.length;i++)
//         {
//             if(nums[i]==1)
//                 ones++;
//             else if(nums[i]== 0)
//                 zeroes++;

//         }
//         for(int i=0;i<nums.length;i++)
//         {
//             if(zeroes !=0)
//             {
//                 nums[i]=0;
//                 zeroes--;
//             }
//             else if(ones!=0)
//             {nums[i]=1;
//              ones--;
//             }
//             else
//                 nums[i]=2;
//         }
//     }
// }
            // 3pointer approach
            int n = nums.length;
            int left =0 ;
            int right = n-1;
            int curr=0;
            int piv=1;
            while(curr<=right)
            {
                if( nums[curr] == piv)
                {
                    // int temp = nums[left];
                    // nums[left]= nums[curr];
                    // nums[curr]= temp;
                    // left++;
                    curr++;
                }
                else if(nums[curr] <piv )
                {
                    int temp = nums[curr];
                    nums[curr]= nums[left];
                    nums[left]= temp;
                    left++;
                    curr++;
                }
                else{
                    int temp = nums[curr];
                    nums[curr]= nums[right];
                    nums[right]= temp;
                    right--;

                }

                // System.out.println("d "+d+" d[] "+ nums[d]);

            }
        }
    }
}
