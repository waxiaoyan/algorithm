package com.algorithm.search;

import sun.awt.image.ImageWatched;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSSearch {
    private int v;
    private boolean[] visited ;

    private LinkedList adj[];
    BFSSearch(int v){
        this.v = v;
        visited = new boolean[this.v];
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int m){
        adj[v].add(m);
    }

    void bfs(int s){
        LinkedList<Integer> queue = new LinkedList();
        visited[s] = true;
        queue.add(s);
        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }

    public static void main(String args[])
    {
        BFSSearch g = new BFSSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);
    }
}
