package Leetcode.DP;

public class Q72_EditDistance {

        public int minDistance(String word1, String word2) {
            return minDistance_TD(word1, word2,0,0,new Integer[word1.length()][word2.length()]);
        }
        public static int minDistance_TD(String w1, String w2, int i1, int i2, Integer[][] dp){
            if(i1 == w1.length() && i2== w2.length()) {

                return  0;}
            //if any one index become gretaer than length or any string becomes empty
            if(i1 >= w1.length() || i2 == w2.length())
            {
                int l1 = w1.length() -i1;
                int l2 = w2.length() - i2;

                return Math.max(l1,l2);
            }
            if(dp[i1][i2] != null) {
                return dp[i1][i2];
            }
            //when same charcaters
            if(w1.charAt(i1) == w2.charAt(i2)){
                dp[i1][i2] = minDistance_TD(w1,w2,i1+1,i2+1,dp);
                return dp[i1][i2];
            }
            else{
                int insert = minDistance_TD(w1,w2,i1,i2+1,dp);
                int delete = minDistance_TD(w1,w2,i1+1,i2,dp);
                int replace = minDistance_TD(w1,w2,i1+1,i2+1,dp);
                dp[i1][i2] = Math.min(insert, Math.min(delete,replace)) +1;
                return Math.min(insert, Math.min(delete,replace)) +1;
            }
        }

}
