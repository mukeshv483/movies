package com.example.demo.graph;

/**
 * @author Mukesh Verma
 */
import java.util.*;

public class Solution {
     List<Integer> result=new ArrayList<>();
    public  List<Integer> bfsTraversal(Graph graph, int source) {
       // bfs(graph.getAdjacencyList().get(source));
        return result;
    }

    public  void bfs(Vertex v){
           if(v==null){
               return;
           }
           System.out.println("data: "+ v.getValue());
           result.add(v.getValue());
           bfs(v.getNext());
    }

}