package Leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q994_RottingOranges_GraphBFS {

        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int min=0;
            int no_oranges= 0;
            // bfs
            Queue<int[]> q= new LinkedList<>();

            // base cases
            if(grid.length==0) return 0;

            // put all rotten in queue
            // count no of oranges
            for(int i=0;i<m;i++)
            {
                for (int j=0;j<n;j++)
                {
                    if(grid[i][j]== 2){
                        q.offer(new int[]{i,j});
                    }
                    if(grid[i][j] !=0)
                        no_oranges ++;
                }
            }

            if(no_oranges == 0) return 0;
            int rotten =0;
            int dx[]={0,0,1,-1};
            int dy[]={1,-1,0,0};

            while(!q.isEmpty())
            {
                int size = q.size();
                rotten = rotten + size;
                for(int k=0;k<size;k++)
                {
                    int [] current= q.poll();
                    for (int t =0;t<4;t++)
                    {
                        int x = current[0]+dx[t];
                        int y = current[1]+dy[t];

                        // check if there oranges
                        if(x<0 || y<0 || x>= m|| y>= n|| grid[x][y]==0|| grid[x][y]==2)
                            continue;

                        grid[x][y]=2;
                        q.offer(new int[]{x,y});

                    }

                }

                if(q.size()!=0)
                {   min++;}
            }
            return no_oranges== rotten? min:-1;
        }
    }

