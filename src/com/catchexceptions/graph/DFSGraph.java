/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.catchexceptions.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0, 23-Nov-2018
 * @author gourav
 */
public class DFSGraph {

    private Integer             n;
    private LinkedList<Integer> adjList[];
    
    @SuppressWarnings("unchecked")
    public DFSGraph(Integer n) {
        this.n= n;
        adjList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {

        DFSGraph g = new DFSGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.traverse(2);
    }

    public void addEdge(Integer v, Integer e) {
        adjList[v].add(e);
    }
    
    public void traverse(Integer v) {
        boolean[] visited = new boolean[n];
        dfs(v, visited);
    }
    
    public void dfs(Integer v, boolean[] visited) {
        
        System.out.println(v);
        visited[v] = true;
        
        LinkedList<Integer> adjV = adjList[v];
        for (Integer integer : adjV) {
            if(!visited[integer]) {
                dfs(integer, visited);
            }
        }
        
        
    }

}
