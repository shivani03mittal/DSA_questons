package Leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_Q15 {

        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> ans = new ArrayList<>();
          

//       two pointer : sort arrays
            Arrays.sort(nums);
            for(int i=0; i< nums.length-2;i++)
            {
                if(i==0 || (i>0 && nums[i] != nums[i-1]))
                {
                    int start= i+1;
                    int end = nums.length-1;
                    int sum = 0- nums[i];

                    while(start < end)
                    {
                        if(nums[start]+ nums[end]== sum)
                        {
                            ans.add(Arrays.asList(nums[i], nums[start],nums[end]));


                            while(start < end  && nums[start]== nums[start+1]) start++;
                            while(start < end  && nums[end]== nums[end-1]) end--;
                            end--;
                            start++;
                        }
                        else if(nums[start]+ nums[end] >sum)
                            end--;
                        else
                            start++;
                    }
                }
            }


            return ans;
        }

}
