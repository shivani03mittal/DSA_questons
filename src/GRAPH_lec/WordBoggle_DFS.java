package GRAPH_lec;

import java.util.ArrayList;

public class WordBoggle_DFS {
    public static String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        ArrayList<String> arr  =new ArrayList<>();
        int n = board.length;
        int  m = board[0].length;
        for(String s: dictionary){
            if( dfs(s, board, n,m)){
                arr.add(s);
            }
        }
        return arr.toArray(new String[arr.size()]);
    }
    static class Pair{
        int i;
        int j;

        public Pair(int i, int j){
            this.i= i;
            this.j= j;
        }
    }

    static boolean  dfs(String key, char[][] board, int n, int m){

        //search start: if -1,-1 return false
        //substring from 1, src if result of serach, if non neighbour same return false

        char start= key.charAt(0);
       ArrayList<Pair> inBoard= new ArrayList<>();
       search(start, board,n,m,inBoard);
        if(inBoard.size()==0){return false;}
        while (! inBoard.isEmpty()){
            boolean[][] vis = new boolean[n][m];
            String rem = key.substring(1);
            Pair p = inBoard.remove(0);
             if(dfsUtil(rem, board, p.i, p.j, vis)) return true;
        }
        return false;
    }

   static boolean dfsUtil(String str, char[][] board, int i, int j, boolean[][] vis){


        vis[i][j] = true;
        if(str.length() ==0) return true;

        int[] dx ={0,0, 1, -1, 1,1,-1,-1};
        int[] dy={1, -1, 0, 0, 1,-1,1,-1};
        for(int k =0;k<8;k++){
            int x = i+dx[k];
            int y = j+ dy[k];

            if(x<0 || y<0 || x>=board.length ||y>=board[0].length || vis[x][y] == true
                    || board[x][y] != str.charAt(0)){
                continue;
            }
           if(dfsUtil(str.substring(1),board, x,y, vis)) return true;
           vis[x][y] = false;

        }
        return false;
    }

    static void search(char c, char[][] board, int n , int m,  ArrayList<Pair> cor){
        for(int i=0;i<n ;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]== c){
                    cor.add(new Pair(i,j));
                }
            }
        }

    }

    public static void main(String[] args) {
        String[] dictionary = {"GEEKS","FOR","QUIZ","GO"};
        char[][] board = {{'G','I','Z'},{'U','E','K'},{'Q','S','E'}};
//        String[] dictionary = {"qpennjewd", "jpq", "qihinqepjnn" ,"ihnqennjp" ,"ih", "iuhqenn" ,"jpqih", "qeqpj"};
//        char[][] board = {{'n','j'},{'n','p'},{'e','q'},{'q','i'},{'n','h'},{'u','i'}};
//        String[] dictionary = {"uobfpyljwyydyylsxwfkvmrjuttgfdhdclnlivefscnpmizjqjxdnwlufuhydujxj", "qzjliwdylxywbufpte" ,"syyylyjqzdwjlxywmfbpfuofwjunttsikvmrlwpncskvye" ,"pmljfzdwysxypfbwljrirvidinsfmnrpkarwvspxwqbpwtplnyhxawqwnxjaqaopohlw" ,"iwdyyyylsxypfufmbokwisgtdflchncpmjrjlwmxog" ,"xlwbfmjrvkwisgtuncpjmiwdjyylsyyvnskvdgyoxrwucbknfniwmyojctdxqnidxlqky"};
//        char[][] board = {{'b', 'v' ,'h' ,'i', 'o' ,'f' ,'q' ,'j', 'y' ,'y'},
//                {'t', 'y', 'v', 'd', 'x', 'j', 'z', 'd', 'y', 'l'},
//                {'v', 'e', 'k', 'n', 'w' ,'l', 'i' ,'w' ,'y','s'},
//                {'i', 'f', 's', 'c', 'p' ,'m', 'r' ,'j' ,'l','x'},
//                {'l', 'd', 'h', 'n', 'u' ,'j', 'v' ,'m' ,'w','y'},
//                {'n', 'c', 'd', 't', 't' ,'w', 'k' ,'f' ,'b','p'},
//                {'c', 'l', 'f', 'g', 's' ,'i', 'f' ,'o' ,'u','f'}
//        };

        String[] ans = wordBoggle(board,dictionary);
        for(String s: ans){
            System.out.println(s);
        }
    }
}
