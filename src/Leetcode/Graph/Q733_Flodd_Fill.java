package Leetcode.Graph;

public class Q733_Flodd_Fill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int oldcolor= image[sr][sc];
            int[][] ans = image;
            int []dx = {-1,1,0,0};
            int[] dy= {0,0,-1,1};
            dfs(ans, image, sr, sc, color, dx, dy, oldcolor);
            return ans;

        }
        public void dfs (int[][] ans,int[][] image, int i, int j, int color, int[] dx, int[] dy, int inicolor){
            ans[i][j]= color;
            int n = image.length;
            int m = image[0].length;
            for(int k =0;k<4;k++){
                int x = i+dx[k];
                int y = j+dy[k];

                if(x>=0 && x< n && y>=0&& y<m && image[x][y] == inicolor && ans[x][y] != color)
                    dfs(ans, image, x, y, color, dx, dy, inicolor);
            }
        }
    }

    //o(n*m)
}
