package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Breadth First Search (BFS): Level Order Traversal
// Problem Statement: Given an undirected graph, return a vector of all nodes by traversing the graph using breadth-first search (BFS).
public class prob_1 {

    static void breadthfirstSearch(ArrayList<ArrayList<Integer>> adjList){
        int n=adjList.size();
        int visited[] = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        q.add(1);
        visited[1]=1;
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(int x : adjList.get(node)){
                if(visited[x]==0){
                    visited[x]=1;
                    q.add(x);
                }
                
            }
        }
        System.out.println("\nBFS traversal : "+bfs);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // For 1-indexed graph, initialize n+1 lists
        for(int i = 0; i <= vertices; i++){
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter the input of edges as pairs u v (1-indexed):");
        for(int i = 1; i <= edges; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
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

        breadthfirstSearch(adjList);
        sc.close();
    }
}
