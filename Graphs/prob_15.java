package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

/*
Detect Cycle in an Undirected Graph (using DFS)

Problem Statement: Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 
 */
public class prob_15 {

    static boolean dfsCycle(int node,int p,ArrayList<ArrayList<Integer>> adjList,int vis[]){
        vis[node]=1;
        for(int x :adjList.get(node)){
            if(vis[x]==0){
                if(dfsCycle(x,node,adjList,vis)==true){
                    return true;
                }
            }else if( x != p){
                return true;
            }
        }
        return false;
    } 

    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. of vertices");
        int vertices = sc.nextInt();
        System.out.println("enter the no. of edges");
        int edges = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<=vertices;i++){
            adjList.add(new ArrayList<>());
        }
        System.out.println("Enter the input of edges as pairs u v (1-indexed):");
        for(int i=1;i<=edges;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
       System.out.println("\nAdjacency List:");
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        boolean status =false;
        int vis[] =new int[vertices+1];
        for(int i=0;i<=vertices;i++){
            if(vis[i]==0){
                if(dfsCycle(i,-1,adjList,vis)){
                   status=true;
                   break;
                }
            }
        }
        if(status){
            System.out.println("cycle");
        }else{
            System.out.println("No cycle");
        }
        sc.close();

    }
    
}
