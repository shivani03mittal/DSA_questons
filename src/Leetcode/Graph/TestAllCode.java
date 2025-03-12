package Leetcode.Graph;
import java.util.*;

public class TestAllCode {

        public static int orangesRotting(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int rotten =0;
            int min=0;
            int no_oranges =0;

            Queue<int[]> q = new LinkedList<>();

            if(m ==0) return -1;
            for(int i=0;i <m ;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j] == 2){
                        q.offer(new int[]{i,j});
                        rotten++;
                    }

                    if(mat[i][j] !=0){
                        no_oranges++;
                    }
                }
            }
            System.out.println("rotten:" + rotten);
            System.out.println("Oranges: " + no_oranges);

            if(no_oranges ==0) return -1;
            int[] dx= {0,0,-1,1};
            int[] dy ={+1,-1,0,0};

            while(! q.isEmpty()){
                int size = q.size();
                for (int t=0; t<size ;t++) {
                    int[] curr = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int x = curr[0] + dx[k];
                        int y = curr[1] + dy[k];

                        if (x < 0 || y < 0 || x >= m || y >= n || mat[x][y] == 0 || mat[x][y] == 2) {
                            continue;
                        } else {
                            mat[x][y] = 2;
                            q.offer(new int[]{x, y});
                            rotten++;
                        }
                    }
                }
                if(q.size()!=0)
                {   min++;}
            }
            return no_oranges ==rotten? min: -1;
        }


        public static void main(String[] args){
            int[][] mat ={{0,1,2},{0,1,2},{2,1,1}};
            System.out.print(orangesRotting(mat));
        }


}
