package Leetcode;

public class PalindromeNumaber_Q9 {

        public boolean isPalindrome(int x) {
            int n=  reverse(x);
            if(x <0 )
                return false;
            if(n != x )
                return false;
            return true;
        }


        public static int  reverse(int x)
        {int reversen = 0;
            while(x!=0)
            {
                int digit = x%10;
                reversen = reversen *10 + digit;
                x = x/10;
            }

            return reversen;

        }
    }

