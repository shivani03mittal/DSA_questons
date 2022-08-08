package Leetcode;

public class UniqueBSTs_Q96 {
    class Solution {
        public int numTrees(int n) {
            int[] arr = new int[n+1]; //create an array to store unique trres for given nodes
            arr[0]=arr[1]=1; //sice for thesse number of nodes unique is 1 and 0 is base case
            for(int i=2;i<n+1;i++)
            { //considering every number feom 1 to n as rrot node
                int total=0;
                for(int j= 1;j<i+1;j++)
                {
                    int left = j-1;
                    int right = i-j;
                    total+= arr[left]*arr[right];
                }
                arr[i]= total;
            }

            return arr[n];
        }
    }
}
