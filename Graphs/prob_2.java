package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

// Number of Provinces

// Problem Statement: Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

public class prob_2 {


    static void dfs(int node,ArrayList<ArrayList<Integer>> adjList,int visited[]){
        visited[node]=1;
        for(int it:adjList.get(node)){
            if(visited[it]==0){
                
                dfs(it, adjList, visited);
            }
        }
        

    }

    static void NumberOfProvince(ArrayList<ArrayList<Integer>> adjList){


        int count=0;
        int n = adjList.size()-1;
        int visited[] = new int[n+1];
        // Queue<Integer> q = new LinkedList<>();
        // visited[1]=1;
        // q.add(1);
        // while (!q.isEmpty()) {
        //     int node = q.poll();
        //     for(int it : adjList.get(node)){
        //         if(visited[it]==0){
        //             count++;
        //             visited[it]=1;
        //         }
        //     }
        // }
        for(int i=1;i<=n;i++){
            if(visited[i]==0){
                count++;
                dfs(i,adjList,visited);
            }
        }
        System.out.println("Number of provinces is"+count);
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

        NumberOfProvince(adjList);
        sc.close();
    }
    
}
