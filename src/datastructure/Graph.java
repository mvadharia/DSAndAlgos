package datastructure;

import java.util.*;

public class Graph<T> {
    List<List<T>> adjList;
    public Graph(){
        adjList= new ArrayList<>();
    }

    void addNodes(int n){
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
    }

    void addUndirectedEdge(ArrayList<T> arr, int u, int v){
        if(arr.contains(u) && arr.contains(v)){
            adjList.get(u).add(arr.get(v));
            adjList.get(v).add(arr.get(u));
        }
        throw new RuntimeException();
    }

    void addDirectedEdge(ArrayList arr, T u, T v){
        if(arr.contains(u) && arr.contains(v)){
            adjList.get(arr.indexOf(u)).add(v);
        }
        throw new RuntimeException();
    }

    boolean detectCycle(ArrayList<T> arr){
        Set<T> visited=new HashSet<>();
        for(int i=0;i<adjList.size();i++){
            if(!visited.contains(arr.get(i))){
                return isCyclic(arr,i,visited,-1);
            }
        }
        return false;
    }
    boolean isCyclic(ArrayList<T>arr,int ind, Set<T> vis, int parent){
        vis.add(arr.get(ind));
        for(T item: adjList.get(ind)){
            if(!vis.contains(item)){
                if(!isCyclic(arr,arr.indexOf(item),vis,ind)){
                    return true;
                }
            }else if(arr.indexOf(item)!=parent){
                return true;
            }
        }
        return false;
    }

}
