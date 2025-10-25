package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class practice {

    public static void main(String[] args) {
    
    
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int vis[] = new int[10];
    Queue<Integer> q=new LinkedList<>();
    ArrayList<Integer> bfs = new ArrayList<Integer>();

    for(int i=0;i<11;i++){
        vis[i]=0;
    }
    vis[0]=1; // mark visited as 1 for the starting node of graph initially 
    q.add(0);// add the start node of the graph to queue

    while(!q.isEmpty()){
        int node=q.poll();
        bfs.add(node);

        for(int it : adj.get(node)){
            if(vis[it]==0){
                vis[it]=1;
                q.add(it);
            }
        }
       
    }
    System.out.println(bfs);

    }
    
}
