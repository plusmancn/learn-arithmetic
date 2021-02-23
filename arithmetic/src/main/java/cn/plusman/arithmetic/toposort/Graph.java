/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.toposort;

import java.util.LinkedList;

/**
 * 拓扑图
 * @author plusman
 * @since 2021/2/18 9:49 PM
 */
public class Graph {
    /**
     * 顶点个数
     */
    private int v;
    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;
    
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    /**
     * s 先于 t，边 s->t
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
    }
}
