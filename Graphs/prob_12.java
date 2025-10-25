package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

/*Depth First Search (DFS)

Problem Statement: Given an undirected graph, return a vector of all nodes by traversing the graph using depth-first search (DFS).
 */
public class prob_12 {

    static ArrayList<Integer> dfsPath(ArrayList<ArrayList<Integer>> adjList,int vis[],ArrayList<Integer> df,int node){
        vis[node]=1;
        df.add(node);
        for(int it:adjList.get(node)){
            if(vis[it]==0)
                dfsPath(adjList, vis, df, it);
        }
        return df;
    }
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adjList){
        int n=adjList.size();
        int visited[] = new int[n];
        ArrayList<Integer> df = new ArrayList<>();
        for(int i=1;i<n;i++){
                if(visited[i]==0){
                     df = dfsPath(adjList,visited,df,i);
                }
        }
        return df;
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("enter no of vertices");
        int vertices = input.nextInt();
        System.out.println("enter no of edges");
        int edges = input.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<=vertices;i++){
            adjList.add(new ArrayList<>());
        }
        System.out.println("enter the edges 1 index edeges");
        for(int i=1;i<=edges;i++){
            int u =input.nextInt();
            int v=input.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }


        System.out.println("/nAdjacency List");
        for(int i=1;i<=vertices;i++){
            System.out.print(i+" :");
            for(int x : adjList.get(i)){
                System.out.print(x+" ");
            }
            System.out.println();
        }

        ArrayList<Integer> ans=dfs(adjList);
        System.out.println(ans);
        input.close();
    }
    
}
