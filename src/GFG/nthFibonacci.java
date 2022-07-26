package GFG;

public class nthFibonacci {
    static long mod = 1000000007;
    static long nthFibonacci(long n) {

        //prestoring
        long dp[] = new long[(int) n + 5];
        //initializing dp[0] as 0
        dp[0] = 0;
        //initializing dp[1] as 1
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //as same as fibonacci formula f(i)=f(i-1)+f(i-2)
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        //returning nth value
        return dp[(int) n];
    }
}
