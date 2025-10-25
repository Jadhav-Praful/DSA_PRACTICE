package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Shortest Path in Undirected Graph with unit distance

Given an Undirected Graph having unit weight, find the shortest path from the source to all other nodes in this graph. 
In this problem statement, we have assumed the source vertex to be ‘0’. If a vertex is unreachable from the source node, then return -1 for that vertex.
0 1
1 2
2 6
6 7
7 8
0 3
3 4
4 5
5 6
6 8 */

class Pair1{
    int source;
    int distance;
    Pair1(int n,int d){
        this.source=n;
        this.distance=d;
    }
}
public class prob_28 {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.println("enter the no of vertices and edges");
        int v = sc.nextInt();
        int e =sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList =new ArrayList<>();

        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }
        for(int j=0;j<e;j++){
            int u=sc.nextInt();
            int p=sc.nextInt();
            adjList.get(u).add(p);
            adjList.get(p).add(u);
        }
        System.out.println("/nAdjacency List");
        for(int k=0;k<v;k++){
            System.out.print(k + ": ");
            for(int x :adjList.get(k)){
                System.out.print(x+" ");
            }
            System.out.println();
        }

        int dist[] =new int[v];
        for(int l=0;l<v;l++){
            dist[l]=-1;
        }
        Queue<Pair1> q =new LinkedList<>();
        System.out.println("enter the source vertex");
        int src =sc.nextInt();
        q.add(new Pair1(src,0));
        dist[src]=0;

        while(!q.isEmpty()){
            int node = q.peek().source;
            int far =q.peek().distance;
            q.remove();
            for(int x: adjList.get(node)){
                if(dist[x] == -1){
                    dist[x]=far+1;
                    q.add(new Pair1(x, far+1));
                }
            }
        }
        for(int m=0;m<dist.length;m++){
            if(dist[m]==-1){
                System.out.println(-1);
                break;
            }
        }
        System.out.println(Arrays.toString(dist));
        sc.close();
    }
    
}
