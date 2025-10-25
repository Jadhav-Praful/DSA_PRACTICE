package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*Dijkstra’s Algorithm - Using Priority Queue : G-32

Given a weighted, undirected, and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is an edge between i and j, second integers corresponds to the weight of that edge. You are given the source vertex S and You have to Find the shortest distance of all the vertex from the source vertex S. You have to return a list of integers denoting the shortest distance between each node and the Source vertex S.

Note: The Graph doesn’t contain any negative weight cycle.
 */

class MainPair1{
    int node;
    int distance;
    MainPair1(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
}
public class prob_6 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("number of vertices and edges");
        int V =sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<MainPair1>> adjList= new ArrayList<>();

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int j=0;j<E;j++){
            int u = sc.nextInt();
            int v=sc.nextInt();
            int wt=sc.nextInt();
            adjList.get(u).add(new MainPair1(v, wt));
            adjList.get(v).add(new MainPair1(u, wt));
        }

        System.out.println("\nAdjacency List");
        for(int m=0;m<V;m++){
            System.out.print(m+":");
            for(MainPair1 n : adjList.get(m)){
                System.out.print("{"+n.node+","+n.distance+"}");
            }
            System.out.println();
        }

        int[] dist = new int[V];
        for(int x=0;x<V;x++) dist[x]=(int)1e9;

        PriorityQueue<MainPair1> pq =new PriorityQueue<>((x,y)->x.distance - y.distance);
        System.out.println("enter the source node:");
        int src = sc.nextInt();
        pq.add(new MainPair1(src, 0));
        dist[src] = 0;
        while(!pq.isEmpty()){
            int eleValue = pq.peek().node;
            int eleDistance = pq.peek().distance;
            pq.remove();
            for(MainPair1 x:adjList.get(eleValue)){
                if(eleDistance+x.distance < dist[x.node]){
                    dist[x.node]=x.distance+eleDistance;
                    pq.add(new MainPair1(x.node, dist[x.node]));
                }
            }
        }

        System.out.println("the shortest distences form given source to all vertices:");
        System.out.println(Arrays.toString(dist));
        sc.close();
    }
    
}
/*
input :
5 5
0 1 4
1 4 6
4 3 10 
0 2 8
2 3 2

output:
[0, 4, 8, 10, 10]
*/ 