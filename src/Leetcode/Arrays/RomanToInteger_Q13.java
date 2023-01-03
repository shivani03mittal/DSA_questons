package Leetcode.Arrays;

public class RomanToInteger_Q13 {
    class Solution {
        public int romanToInt(String s) {
            int num =0;
            for(int i=s.length()-1; i>=0;i--)
            {
                if(s.charAt(i) =='I')
                {
                    num += 1;
                }
                else if(s.charAt(i) =='V')
                {
                    if(i>0 && s.charAt(i-1) =='I')
                    {
                        num+=4;
                        i--;
                    }
                    else
                    {
                        num+=5;
                    }
                }
                else if(s.charAt(i) =='X')
                {
                    if(i>0 && s.charAt(i-1) =='I')
                    {
                        num+=9;
                        i--;
                    }
                    else
                    {
                        num+=10;
                    }

                }
                else if( s.charAt(i) =='L')
                {
                    if(i>0 && s.charAt(i-1) =='X')
                    {
                        num+=40;
                        i--;
                    }
                    else
                    {
                        num+=50;
                    }

                }
                else if( s.charAt(i) =='C')
                {
                    if(i>0 && s.charAt(i-1) =='X')
                    {
                        num+=90;
                        i--;
                    }
                    else
                    {
                        num+=100;
                    }

                }
                else if( s.charAt(i) =='D')
                {
                    if(i>0 && s.charAt(i-1) =='C')
                    {
                        num+=400;
                        i--;
                    }
                    else
                    {
                        num+=500;
                    }

                }
                else if( s.charAt(i) =='M')
                {
                    if(i>0 && s.charAt(i-1) =='C')
                    {
                        num+=900;
                        i--;
                    }
                    else
                    {
                        num+=1000;
                    }

                }

                // System.out.println(num);

            }

            return num;


        }




    }
}
