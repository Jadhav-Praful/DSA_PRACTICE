package Graphs;
/*Strongly Connected Components - Kosaraju's Algorithm

Problem Statement: Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges.
Find the number of strongly connected components in the graph.

Pre-requisite: DFS algorithm
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class prob_43 {

    static void dfs(int node,int vis[], ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node]=1;

        for(int neighbor : adj.get(node)){
            if(vis[neighbor]==0){
                dfs(neighbor, vis, adj, st);
            }
        }
        st.push(node);
    }
     static void dfs3(int node,int vis[], ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;

        for(int neighbor : adj.get(node)){
            if(vis[neighbor]==0){
                dfs3(neighbor, vis, adj);
            }
        }
        
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges:");
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        // int adjMat[][] = new int[vertices][vertices];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
        System.out.println("enter the edge u->v");
        for(int i=0;i<edges;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adjList.get(u).add(v);
        }
        
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        int vis[]=new int[vertices];

        Stack<Integer> st = new Stack<>();
        //step 1: to make the timing of dfs complete
        for(int i=0;i<vertices;i++){
            if(vis[i]==0){
                dfs(i,vis,adjList,st);
            }
        }
        //step 2: to reverse the graph
        ArrayList<ArrayList<Integer>> adjListTrans = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjListTrans.add(new ArrayList<>());
        }
        for(int i=0;i<vertices;i++){
            vis[i]=0;
            for(int it:adjList.get(i)){
                adjListTrans.get(it).add(i);
            }
        }

        //step 3 perfome the dfs in order of finishing
        int scc=0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if(vis[node]==0){
                scc++;
                dfs3(node, vis, adjListTrans);
            }

            
        }
        System.out.println("Number of strongly connected components are :"+scc);
        sc.close();
        
    }
    
}
