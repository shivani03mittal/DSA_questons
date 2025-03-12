package GRAPH_lec;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class SCC_Kosaraju {
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

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));


        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));


    }
    public static void topsprt(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> s){
        vis[curr] = true;
        for(int i=0;i< graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topsprt(graph,vis,e.dest,s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr){
        vis[curr]= true;
        System.out.print(curr);
        for(int i=0;i< graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,vis, e.dest);
            }
        }
    }
public static void kosaraju(ArrayList<Edge>[] graph, int v){
    Stack<Integer> s = new Stack<>();
    boolean vis[]= new boolean[v];
    for(int i=0;i<v;i++){
        if(!vis[i]){
            topsprt(graph, vis,i, s);
        }
    }

    //step2 : clone graph to store transpose;
    ArrayList<Edge>[] transpose= new ArrayList[v];
    for(int i =0;i<v;i++){
        vis[i] = false; // because during topsort all were visited so for step 3 , eigther make new vis or repurpose this
        transpose[i]= new ArrayList<Edge>();
    }
    //take each node and each edge
    for(int i=0;i<v;i++){
        for(int j =0;j<graph[i].size();j++){
            Edge e = graph[i].get(j); // e.src->e.dst
            transpose[e.dest].add(new Edge(e.dest, e.src));
        }
    }
    //step 3: take node from stack and perform dfs
    while (!s.isEmpty()){
        int curr= s.pop();
        if(!vis[curr]){
            dfs(transpose, vis, curr);
            System.out.println();
        }

    }



}
    public static void main(String[] args) {
        int v =5;
        ArrayList<Edge>[] graph= new ArrayList[v];
        createGraph(graph);
        kosaraju(graph,v);
    }
}
