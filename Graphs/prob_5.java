package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 Problem Statement: Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.

 If we are able to colour a graph with two colours such that no adjacent nodes have the same colour, it is called a bipartite graph.

 */
public class prob_5 {

    static boolean dfs(int node,int color,ArrayList<ArrayList<Integer>> adjList,int vis[]){
        vis[node]=color;
        for(int x : adjList.get(node)){
            if(vis[x]==-1){
                if(dfs(x, 1-color,adjList, vis)==false){
                    return false;
                }
            }else if(vis[x] == color ){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // For 0-indexed graph, initialize n+1 lists
        for(int i = 0; i < vertices; i++){
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter the input of edges as pairs u v (0-indexed):");
        for(int i = 0; i < edges; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        System.out.println("\nAdjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        int vis[] = new int[vertices];
        Arrays.fill(vis,-1);
        for(int i=0;i<vertices;i++){
            if(vis[i]==-1){
                if(dfs(i,0,adjList,vis)==false) System.out.println("it is not bipartite");
                else{
                    System.out.println("it is bipartite");
                }
            }
        }
        sc.close();
    }
    
}
