package Graphs;
/*
Find Eventual Safe States - BFS - Topological Sort: G-25

Problem Statement: A directed graph of V vertices and E edges is given in the form of an adjacency list adj. 
Each node of the graph is labeled with a distinct integer in the range 0 to V - 1. 
A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node. 
You have to return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class prob_26 {
    
    public static void main(String[] args) {
       
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the no of vertices:");
        int vertices = sc.nextInt();
        System.out.println("enter the no of edges:");
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
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
                adjRev.get(it).add(k);
                inDegree[k]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int m=0;m<vertices;m++){
            if(inDegree[m]==0){
                q.add(m);
            }
        }
        ArrayList<Integer> safeNode= new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safeNode.add(node);
            for(int x: adjRev.get(node)){
                inDegree[x]--;
                if(inDegree[x]==0){
                    q.add(x);
                }
            }
        }
        Collections.sort(safeNode);
        System.out.println(safeNode);
        sc.close();

    
    }
}
