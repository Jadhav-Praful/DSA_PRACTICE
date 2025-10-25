package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Bellman Ford Algorithm

Problem Statement: Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertices from the source vertex S.

Note: If the Graph contains a negative cycle then return an array consisting of only -1.

Example 1:

Input Format: 
V = 6, 
E = [[3, 2, 6], [5, 3, 1], [0, 1, 5], [1, 5, -3], [1, 2, -2], [3, 4, -2], [2, 4, 3]], 
S = 0
Result: 0 5 3 3 1 2

Explanation: Shortest distance of all nodes from the source node is returned.

 */


public class prob_33 {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.println("number of vertices and edges");
        int V =sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<MainPair>> adjList= new ArrayList<>();

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int j=0;j<E;j++){
            int u = sc.nextInt();
            int v=sc.nextInt();
            int wt=sc.nextInt();
            adjList.get(u).add(new MainPair(v, wt));
            // adjList.get(v).add(new MainPair(u, wt));
        }

        System.out.println("\nAdjacency List");
        for(int m=0;m<V;m++){
            System.out.print(m+":");
            for(MainPair n : adjList.get(m)){
                System.out.print("{"+n.node+","+n.distance+"}");
            }
            System.out.println();
        }

        int dist[] = new int[V];
        Arrays.fill(dist,(int)1e9);
        System.out.println("enter the source node:");
        int src = sc.nextInt();
        dist[src]=0;
        
        // Bellman-Ford Algorithm
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (MainPair edge : adjList.get(u)) {
                    int v = edge.node;
                    int wt = edge.distance;
                    if (dist[u] != (int)1e9 && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Check for negative weight cycles
        boolean negCycle = false;
        for (int u = 0; u < V; u++) {
            for (MainPair edge : adjList.get(u)) {
                int v = edge.node;
                int wt = edge.distance;
                if (dist[u] != (int)1e9 && dist[u] + wt < dist[v]) {
                    negCycle = true;
                    break;
                }
            }
            if (negCycle) break;
        }

        System.out.println("\nShortest Distances:");
        if (negCycle) {
            System.out.println(Arrays.toString(new int[]{-1}));
        } else {
            for (int i = 0; i < V; i++) {
                System.out.print(dist[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    } 
}
