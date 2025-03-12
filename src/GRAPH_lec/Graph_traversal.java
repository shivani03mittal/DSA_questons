package GRAPH_lec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_traversal {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d)
        {
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[])
    {
        for(int i= 0;i< graph.length;i++)
        {
            graph[i]= new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,0));

        graph[3].add(new Edge(3,5));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));

        graph[5].add(new Edge(5,6));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));

        graph[6].add(new Edge(6,5));
    }

    public static void bfs(ArrayList<Edge> graph[], int V)
    {
        Queue<Integer> q= new LinkedList<>();
        boolean vis[]= new boolean[V];
        q.add(0);

        while (!q.isEmpty())
        {
            int curr= q.poll();
            if(!vis[curr])
            {
                System.out.print(curr+" ");
                vis[curr]= true;
                for(int i=0;i< graph[curr].size();i++)
                {
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    private  static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[])
    {
//        if(!vis[curr]) {
            System.out.print(curr + " ");
            vis[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
            if(vis[e.dest]==false)
                dfs(graph, e.dest, vis);
            }
//        }
    }


    public static void allpaths(ArrayList<Edge> graph[], boolean vis[], int curr, int target, String path)
    {
        //T(n) = O(v*v)
//        base case
        if(curr==target)
        {
            System.out.println(path+"");
            return;
        }

        vis[curr]= true;
        for(int i=0;i< graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest])
            {
//                vis[curr]= true;
                allpaths(graph, vis,e.dest,target,path+e.dest);
//                vis[curr]= false;
            }
        }
        vis[curr]= false;
    }
    public static void main(String[] args) {
    int V = 7;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
//    bfs(graph, V);
    boolean vis[]= new boolean[V];
//    dfs(graph,0,vis);
        allpaths(graph,vis,0,5,"0");
    }
}
