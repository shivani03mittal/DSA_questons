package GRAPH_lec;

import java.util.ArrayList;

public class bellmanFord {
    static  class Edge {
        int src;
        int dest;
        int wt;


        public Edge(int src, int des, int wt) {
            this.src= src;
            this.dest=des;
            this.wt= wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,2,-4));


        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));

    }
    public static void bellmanford(ArrayList<Edge>[] graph, int src, int v){
        int [] dis = new int[v];
        for(int i =0;i<v ;i++){
            dis[i] = Integer.MAX_VALUE;
        }

        for(int k =0;k<v;k++){
            for(int i =0;i<v;i++){
                for(int j =0;j<graph[i].size();j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int vi = e.dest;
                    if(dis[u]!= Integer.MAX_VALUE && dis[u]+e.wt < dis[vi]){
                        dis[vi]= dis[u]+e.wt;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int v =5;
        ArrayList<Edge> []graph = new ArrayList[v];
        createGraph(graph);
    }

}
