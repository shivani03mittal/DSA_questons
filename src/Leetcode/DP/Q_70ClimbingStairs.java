package Leetcode.DP;

public class Q_70ClimbingStairs {

        public int climbStairs(int n) {
            //recursive
            // return move(0,n);
            //topdown
            // return move_td(0, n,new Integer[n+1]);
            return move_BU(n);

        }
        public static int move(int curr, int n){
            if(curr > n ) return 0;
            if(curr== n) return 1;

            int sp1= move(curr+1,n);
            int sp2 = move(curr +2,n);
            return sp1 + sp2;

            //t(n) = O(2^n)
        }

        public static int move_td(int curr,int n,Integer[] dp){
            if(curr > n ) return 0;
            if(curr== n) return 1;

            if(dp[curr] != null) return dp[curr];
            int sp1= move_td(curr+1,n,dp);
            int sp2 = move_td(curr +2,n,dp);
            dp[curr] = sp1+sp2;
            return sp1 + sp2;

            //t(n) = O(n)
        }
        public static int move_BU(int n){
            int[] dp = new int[n+2];
            dp[n]=1;
            dp[n+1]=0;
            for(int curr = n-1; curr >=0 ;curr--){
                int sp1 = dp[curr+1];
                int sp2 = dp[curr+2];
                dp[curr] = sp1 +sp2;
            }
            return dp[0];
        }

}
