package cn.plusman.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph { // 无向图
    public int v; // 顶点的个数
    public LinkedList<Integer>[] adj; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public static void main(String[] args) {
        int v = 8;

        Graph graph = new Graph(v);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        DFS dfs = new DFS(v, graph);
        // dfs.dfsByRecursive(0, 6);

        System.out.println(Arrays.toString(graph.adj));
    }
}
