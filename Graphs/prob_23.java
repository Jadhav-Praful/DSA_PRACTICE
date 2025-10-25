package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Kahn's Algorithm | Topological Sort Algorithm 

Problem Statement: Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

Note: In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).
 */
public class prob_23 {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.println("enter the no of vertices:");
        int vertices = sc.nextInt();
        System.out.println("enter the no of edges:");
        int e = sc.nextInt();

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
        for (int i = 0; i <vertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        int[] inDegree = new int[vertices];

        // marking the indegrees of all the node in to an array inDegree
        for (int k = 0; k < vertices; k++) {
            for(int it : adjList.get(k)){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int m=0;m<vertices;m++){
            if(inDegree[m]==0){
                q.add(m);
            }
        }
        ArrayList<Integer> al= new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            al.add(node);
            for(int x: adjList.get(node)){
                inDegree[x]--;
                if(inDegree[x]==0){
                    q.add(x);
                }
            }
        }
        
        System.out.println(al);
        sc.close();
    }
}
