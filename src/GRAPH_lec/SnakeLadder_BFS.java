package GRAPH_lec;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder_BFS {
    static int minThrow(int N, int arr[]){
        // code here
        int n =30;
        int[] board= new int[n];
        for(int i =0;i< n;i++){
            board[i]= -1;
        }

        for(int j =0;j< 2*N;j+=2){
            board[arr[j]-1] = arr[j+1]-1;
        }

        boolean[] vis = new boolean[n];
        for(int i =0;i<30;i++){
            vis[i]= false;}
        return bfs(board, vis, n);

    }
    static int bfs(int[] board, boolean[] vis, int n){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));

        while(! q.isEmpty()){
            Pair curr = q.poll();

            if(curr.src == n-1) return curr.roll;

            if(!vis[curr.src]){
                vis[curr.src] = true;

                for(int k =1;k<=6;k++){
                    int x = curr.src+k;
                    if(x>= n ) continue;

                    if(!vis[x]){
                        int dis = curr.roll +1;
                        if(board[x] != -1){
                            q.add(new Pair(board[x], dis));
                        }else{
                            q.add(new Pair(x, curr.roll+1));
                        }
                    }
                }

            }
        }
        return -1;
    }

    static class Pair{
        int src;
        int roll;

        public Pair(int v, int d){
            src= v;
            roll=d;
        }
    }

    public static void main(String[] args) {
        int N= 8;
        int[] arr= {3, 22, 5 ,8 ,11, 26, 20, 29, 17, 4, 19, 7, 27, 1, 21, 9};
        System.out.println(minThrow(8,arr));
    }
}
