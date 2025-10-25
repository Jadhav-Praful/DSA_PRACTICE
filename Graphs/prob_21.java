package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

/*
Detect cycle in a directed graph (using DFS) : G 19

Problem Statement: Given a directed graph with V vertices and E edges, check whether it contains any cycle or not. 
*/
public class prob_21 {

    static boolean dfsCycleDirected(int node,ArrayList<ArrayList<Integer>> adjList,int[] vis,int pathvis[]){
        
        vis[node]=1;
        pathvis[node]=1;
        for(int x : adjList.get(node)){
            if(vis[x]==0){
              if(dfsCycleDirected(x, adjList, vis, pathvis)){
                return true;
                }   
            }else if(pathvis[x] == 1){
                    return true;
                }
            
        }
        pathvis[node]=0;
        return false;
    } 
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the no of vertices:");
        int vertices = sc.nextInt();
        System.out.println("enter the no of edges:");
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<=vertices;i++){
            adjList.add(new ArrayList<>());
        }
        for(int j=1;j<=e;j++){
            int u = sc.nextInt();
            int v =sc.nextInt();
            adjList.get(u).add(v);
        }

        System.out.println("\nAdjacency List:");
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        int vis[] = new int[vertices+1];
        int pathvis[] = new int[vertices+1];
        boolean check = false;
        for(int k=1;k<=vertices;k++){
            if(vis[k]==0){
                if(dfsCycleDirected(k,adjList,vis,pathvis)){
                    check = true;
                    break;   
                }
                
            }
        }
        sc.close();
        if(check){
            System.out.println("directed cyclic graph");
        }else{
                    System.out.println("Directed Acyclic Graph");
        }
    }
    
}
