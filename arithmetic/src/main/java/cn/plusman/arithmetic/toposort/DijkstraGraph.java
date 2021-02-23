/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.toposort;

import java.util.LinkedList;

/**
 * @author plusman
 * @since 2021/2/19 9:59 PM
 */
public class DijkstraGraph {
    // 邻接表
    private LinkedList<Edge> adj[];
    // 顶点个数
    private int v;
    
    // 有向有权图的邻接表
    public DijkstraGraph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int s, int t, int w) { // 添加一条边
        this.adj[s].add(new Edge(s, t, w));
    }
    
    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重
        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }
    /**
     * 下面这个类是为了dijkstra实现用的
     */
    private class Vertex {
        public int id; // 顶点编号ID
        public int dist; // 从起始顶点到这个顶点的距离
        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }
    
    
    /**
     * 因为Java提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
     * 根据vertex.dist构建小顶堆
     */
    private class PriorityQueue {
        
        private Vertex[] nodes;
        private int count;
        public PriorityQueue(int v) {
            this.nodes = new Vertex[v+1];
            this.count = v;
        }
        public Vertex poll() {
            return null;
        }
        public void add(Vertex vertex) {}
        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度O(logn)。
        public void update(Vertex vertex) {
        
        }
        public boolean isEmpty() {
            return false;
        }
    }
                    
    public void dijkstra(int s, int t) { // 从顶点s到顶点t的最短路径
        // 用来还原最短路径
        int[] predecessor = new int[this.v];
        Vertex[] vertexes = new Vertex[this.v];
        for (int i = 0; i < this.v; ++i) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue queue; // 小顶堆
        queue = new PriorityQueue(this.v);
        boolean[] inqueue; // 标记是否进入过队列
        inqueue = new boolean[this.v];
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            // 取堆顶元素并删除
            Vertex minVertex= queue.poll();
            if (minVertex.id == t) {
                break; // 最短路径产生了
            }
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                // 取出一条minVetex相连的边
                Edge e = adj[minVertex.id].get(i);
                // minVertex-->nextVertex
                Vertex nextVertex = vertexes[e.tid];
                // 更新next的dist
                if (minVertex.dist + e.w < nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id] == true) {
                        // 更新队列中的dist值
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        // 输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
    }
                    
    private void print(int s, int t, int[] predecessor) {
        if (s == t) {
            return;
        }
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }
}


