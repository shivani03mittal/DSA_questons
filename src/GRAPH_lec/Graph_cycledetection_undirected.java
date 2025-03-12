package GRAPH_lec;

import java.util.ArrayList;

public class  Graph_cycledetection_undirected {

        static class Edge{
            int src;
            int dest;

            public Edge(int s, int d)
            {
                this.src=s;
                this.dest=d;
            }
        }
        public static void createGraph(ArrayList<Edge> graph[]) {
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<Edge>();
            }
            graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 4));

            graph[1].add(new Edge(1, 0));
            graph[1].add(new Edge(1, 2));
            graph[1].add(new Edge(1, 4));

            graph[2].add(new Edge(2, 1));
            graph[2].add(new Edge(2, 3));

            graph[3].add(new Edge(3, 2));

            graph[4].add(new Edge(4, 0));
            graph[4].add(new Edge(4, 1));
            graph[4].add(new Edge(4, 5));

            graph[5].add(new Edge(5, 4));

        }
        public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean[] vis, int cur, int parent)
        {
            vis[cur]= true;
            for(int i =0;i<graph[cur].size();i++)
            {
                Edge e = graph[cur].get(i);
                if(vis[e.dest]== true && parent != e.dest )
                    return true;
                else if(!vis[e.dest])
                    if(isCycleUndirected(graph,vis,e.dest,cur))
                        return true;
            }
            return false;
        }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean[] vis= new boolean[V];
        System.out.println(isCycleUndirected(graph,vis,0,-1));
    }
}
