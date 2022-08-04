package Leetcode.Arrays;

public class BestTimeToSellStock_Q121 {
    class Solution {
        public int maxProfit(int[] prices) {

// brute force
//         int profit=0;
//         for(int i=0;i<prices.length;i++)
//         {
//             for (int j=i+1 ;j<prices.length;j++)
//             {
//                 if(prices[j]>prices[i])
//                 {
//                     int dif = prices[j]- prices[i];
//                     if(dif > profit)
//                         profit = dif;
//                 }
//             }
//         }

//         return profit;


//         optimized
//         two pointer / two variable approch
            int min=prices[0];
            int profit=0;
            for(int i=0;i<prices.length;i++)
            {
//             if min ele > element then change and profit stys same
//             else update profit
                if(prices[i]< min)
                    min = prices[i];
                else if(prices[i]> min)
                {
                    int dif = prices[i] - min;
                    if(dif > profit)
                        profit = dif;
                }

            }


            return profit;
        }
    }
}
