package Leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q200_NumberOfIslands {

        public int numIslands(char[][] grid) {
            // disconneced graph problem
// bfs
            int m = grid.length;
            int n = grid[0].length;
            int number =0;
            boolean[][] vis = new boolean[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++){
                    if(grid[i][j]=='1' && vis[i][j]== false)
                    {
                        number++;
                        bfs(grid,vis,i,j);

                    }
                }
            }

            return number;
        }
        public static void bfs(char[][] grid, boolean[][] vis, int x, int y)
        {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x,y});
            int dx[]={0,0,1,-1};
            int dy[]={1,-1,0,0};
            while(!q.isEmpty())
            {
                int[] curr= q.poll();
                for(int i=0;i<4;i++){
                    int a= curr[0]+dx[i];
                    int b= curr[1]+dy[i];

                    if(a<0 || b<0|| a>= grid.length|| b>=grid[0].length || grid[a][b]=='0')
                        continue;
                    q.offer(new int[]{a,b});
                }
            }
        }

    }


/**
 static class Trie{
 int numVal;
 Trie[] children = new Trie[2];

 public Trie(){
 numVal=0;
 children[0] = null;
 children[1] = null;

 }

 }

 static Trie root;

 static void insert(int num){
 Trie curr = root;
 for(int i = 31; i>=0 ;i--){
 int currBit = (num & (1<<i)) >=1 ? 1:0;
 if(curr != null && curr.children[currBit] == null){
 curr.children[currBit] = new Trie();
 }

 curr= curr.children[currBit];
 }
 //at leaf node add val
 curr.numVal = num;
 }

 static int minXORUtil(int num){

 Trie curr = root;
 for(int i = 31; i>=0 ;i--){
 int currBit = (num & (1<<i)) >=1 ? 1:0;

 if(curr.children[currBit] != null){
 curr= curr.children[currBit];
 }
 else if(curr.children[1-currBit] != null){
 curr = curr.children[1- currBit] ;
 }

 }
 return num ^ curr.numVal;

 }

 static int minxorpair(int N, int arr[]){
 // for(int i=0; i<N ;i++){
 //     insert(arr[i]);
 // }
 root = new Trie();
 int minXor= Integer.MAX_VALUE;
 insert(arr[0]);
 for(int i=1;i <N;i++){
 minXor = Math.min(minXor, minXORUtil(arr[i]));
 insert(arr[i]);
 }
 return minXor;
 // code here
 }*
 */

