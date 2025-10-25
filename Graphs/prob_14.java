package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Detect Cycle in an Undirected Graph (using BFS)

Problem Statement: Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.
 */
class Pair5 {
    int child;
    int parent;
    Pair5(int c,int p){
        this.child=c;
        this.parent=p;
    }
}
public class prob_14 {

    static boolean cycleFoundBfs(int node,int parent,ArrayList<ArrayList<Integer>> adjList,int vis[]){
        vis[node]=1;
        Queue<Pair5> q = new LinkedList<>();
        q.add(new Pair5(node, parent));
       
        while(!q.isEmpty()){
            int c=q.peek().child;
            int p=q.peek().parent;
            q.remove();
            for(int x: adjList.get(c)){
            if(vis[x]==0){
                vis[x]=1;
                q.add(new Pair5(x, c));
            }
            else if(x != p){
                return true;  //cycle found 
            }
        }
    }        
    return false;     
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

        int vis[]=new int[vertices+1];
        // Queue<Pair5> q= new LinkedList<>();
        for(int i=1;i<=vertices;i++){
            if(vis[i]==0){
                if(cycleFoundBfs(i,-1, adjList, vis)){
                    System.out.println("this graph as cycle.");
                }else{
                    System.out.println("This graph does not have any cycles in it.");
                }
            }
        }
        sc.close();

    }
    
}
