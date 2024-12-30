package com.example.demo.graph;

import java.util.List;

/**
 * @author Mukesh Verma
 */
public class BFS {
    public static void main(String[] args) {
        Solution solution=new Solution();

       // Graph graph=new Graph();
        Vertex v1=new Vertex(1);
        Vertex v2=new Vertex(2);
        Vertex v3=new Vertex(3);
        Vertex v4=new Vertex(4);
        Vertex v5=new Vertex(5);
        v1.setNext(v3);
        v3.setNext(v5);
        v2.setNext(v4);
        List<Vertex> list=List.of(v1,v2,v3,v4,v5);
        //graph.setAdjacencyList(list);
      //  solution.bfsTraversal(graph,0);
    }
}
