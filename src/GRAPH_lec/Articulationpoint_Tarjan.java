package GRAPH_lec;

import java.util.ArrayList;

public class Articulationpoint_Tarjan {
    static  class Edge {
        int src;
        int dest;



        public Edge(int src, int des) {
            this.src= src;
            this.dest=des;

        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));



    }
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[], int parent, int[] dt, int[] low,
                           int time, boolean ap[]){
        vis[curr] = true;
        dt[curr]= low[curr]= ++time;
        int children =0;

        for(int i=0;i< graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(parent== neigh){
                continue;
            }else if( vis[neigh]){
                low[curr] = Math.min(low[curr],dt[neigh]);
            }else{
                dfs(graph,e.dest,vis,curr,dt,low,time,ap);
                low[curr] = Math.min(low[curr],low[neigh]);
                //ap cond
                if(dt[curr] <= low[neigh] && parent != -1){
                    ap[curr] = true;
                }
                children++;
            }
        }

        //check for src vertex
        if(parent ==-1 && children >1){
            ap[curr] = true;
        }

    }
    public static void artculation(ArrayList<Edge>[] graph, int v){
        int[] dt= new int[v];
        int[] low= new int[v];
        int time=0;
        boolean vis[]= new boolean[v];
        boolean ap[] = new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph,i,vis,-1,dt, low, time, ap);
            }
        }
        for (int i=0;i<v;i++){
            if(ap[i]){
                System.out.println("ap:"+ i);
            }
        }
    }

    public static void main(String[] args) {
        int v =5;
        ArrayList<Edge>[] graph= new ArrayList[v];
        createGraph(graph);
        artculation(graph,v);
    }
}
