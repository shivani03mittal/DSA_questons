package Leetcode.Arrays;

public class TrappingRainWater_Q42 {
    class Solution {
        public int trap(int[] arr) {
            int water=0;
//         for(int i=0;i< height.length;i++)
//         {
//              int left =0;
//             int right =0 ;
//             for(int j=i ;j>=0 ;j--)
//             {
//                 left= Math.max(left, height[j]);
//             }
//              for(int j=i ;j<height.length ;j++)
//             {
//                 right= Math.max(right, height[j]);
//             }

//             water+= Math.min(left, right)- height[i];
//         }
            int n = arr.length;
            int left=0;
            int right = n-1;
            int maxLeft=arr[0];
            int maxRight= arr[n-1];

            while(left <right)
            {
//             moving pointer
                if(maxLeft <= maxRight)
                {
                    left++;
                    int dif = maxLeft- arr[left];
                    if(dif > 0)
                        water += dif;
                    else
                        maxLeft = arr[left];
                }
                else
                {
                    right--;
                    int dif = maxRight- arr[right];
                    if(dif > 0)
                        water += dif;
                    else
                        maxRight = arr[right];
                }


            }


            return water;

        }
    }
}
