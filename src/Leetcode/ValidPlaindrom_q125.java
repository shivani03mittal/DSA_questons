package Leetcode;

public class ValidPlaindrom_q125 {
    public boolean isPalindrome(String s) {
//         65-90 A-Z
//         97-122 a-z
//         48-57 [0-9]

        String input = convertStr(s);

        int start =0;
        int end = input.length()-1;
        while( start <=end)
        {
            if(input.charAt(start) != input.charAt(end))
                return false;

            start++;
            end --;
        }

        return true;
    }

    public static String convertStr(String s)
    {
        String input="";
        for(int i=0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch >= 65 && ch <=90)
            {
                input += (char)(ch+32 );
            }
            else if(ch >= 97 && ch<= 122)
            {
                input+= ch;
            }

            else if(ch >= 48 && ch<= 57)
            {
                input+= ch;
            }


        }
        // System.out.print(input);

        return input;
    }
}
