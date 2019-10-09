package com.algorithm.search;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSSearch {
    private static LinkedList path = new LinkedList();
    private int v;
    private LinkedList<Integer> adjacency[];

    public static void main(String[] args) {
        DFSSearch g = new DFSSearch(4);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
//        g.dfs(0);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.dfs(2);
        Iterator i = path.iterator();
        while(i.hasNext()) {
            System.out.print(i.next() + " ");
        }
    }

    private DFSSearch(int v) {
        this.v = v;
        adjacency = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacency[i] = new LinkedList<>();
        }
    }
    void addEdge(int v, int w) {
        adjacency[v].add(w);
    }

    void dfsUtil(int v, boolean[] visited){
        visited[v] = true;
        path.add(v);
        Iterator<Integer> i = adjacency[v].listIterator();
        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n]) {
                dfsUtil(n,visited);
            }
        }
    }

    void dfs(int n){
        boolean[] visited = new boolean[this.v];
        dfsUtil(n,visited);
    }

}
