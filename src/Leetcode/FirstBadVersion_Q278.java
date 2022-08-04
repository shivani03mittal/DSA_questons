package Leetcode;

public class FirstBadVersion_Q278 {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


        public int firstBadVersion(int n) {

//         binary search
            int s=0;
            int e= n;
            int ans = n;

            while(s<=e)

            {
                int mid = e+(s-e)/2;
//                if(isBadVersion(mid))
                {
                    ans=mid;
                    e= mid-1;
                }
//                else
                    s= mid+1;

            }

            return ans;

        }



}
