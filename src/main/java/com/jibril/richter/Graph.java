package com.jibril.richter;

import jdk.internal.joptsimple.internal.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Graph {

    private HashMap<String, ArrayList<String>> vertices = new HashMap<>();

    public boolean addVertex(String vertex){
        if(vertices.get(vertex) == null){
            vertices.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2){
        if(vertex1 != null && vertex2 != null){
            vertices.get(vertex1).add(vertex2);
            vertices.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2){
        if (vertices.get(vertex1) != null && vertices.get(vertex2) != null){
            vertices.get(vertex1).remove(vertex2);
            vertices.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex){
        if (vertices.get(vertex) != null){
            ArrayList<String> edges = vertices.get(vertex);
            for (int index = 0; index < edges.size(); index++){
                vertices.get(edges.get(index)).remove(vertex);
            }
            vertices.remove(vertex);
        }

        return false;
    }

    
}
