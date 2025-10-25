package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*Topological Sort Algorithm

Problem Statement: Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

Note: In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).
 */
public class prob_22 {

    static void dfsTopologicalSort(int node, ArrayList<ArrayList<Integer>> adjList,int[]vis,Stack<Integer> st){
        
        vis[node]=1;
        for(int x:adjList.get(node)){
            if(vis[x]==0){
                dfsTopologicalSort(x, adjList, vis,st);
            }
        }
        st.push(node);

        
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the no of vertices:");
        int vertices = sc.nextInt();
        System.out.println("enter the no of edges:");
        int e = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
        for(int j=0;j<e;j++){
            int u = sc.nextInt();
            int v =sc.nextInt();
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
        int vis[] = new int[vertices];

        for(int i=0;i<vertices;i++){
                if(vis[i]==0){
                    dfsTopologicalSort(i,adjList,vis,st);
                }
        }

        for (int i=st.size()-1;i>=0;i--) {
            int it = st.pop();
            System.out.print(it+" ");
            
        }
        sc.close();
    }
    
}
