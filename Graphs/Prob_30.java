package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*Dijkstra’s Algorithm - Using Set : G-33

Given a weighted, undirected, and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists 
containing two integers where the first integer of each list j denotes there is an edge between i and j, second integers corresponds to the weight of that edge. 
You are given the source vertex S and You have to Find the shortest distance of all the vertex from the source vertex S. 
You have to return a list of integers denoting the shortest distance between each node and Source vertex S.



Note: The Graph doesn’t contain any negative weight cycle
 */
// Dijikstra cannot be implimented by TreeSet or HashSet using java language as it is done in C++;

class MainPair{
    int node;
    int distance;
    MainPair(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
}
public class Prob_30 {
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
            adjList.get(v).add(new MainPair(u, wt));
        }

        System.out.println("\nAdjacency List");
        for(int m=0;m<V;m++){
            System.out.print(m+":");
            for(MainPair n : adjList.get(m)){
                System.out.print("{"+n.node+","+n.distance+"}");
            }
            System.out.println();
        }

        PriorityQueue<MainPair> p = new PriorityQueue<>((x,y)->x.distance-y.distance);

        int dist[] = new int[V];
        Arrays.fill(dist, (int)1e9); 
        System.out.println("enter the source vertex");
        int src  = sc.nextInt();
        dist[src] = 0;
        p.add(new MainPair(src, 0));
        while(!p.isEmpty()){
            MainPair curr = p.poll();
            int eleValue = curr.node;
            int eleDistance =curr.distance;
            p.remove(curr);
            for(MainPair x : adjList.get(eleValue)){
                if(x.distance + eleDistance < dist[x.node]){
                    dist[x.node] = x.distance + eleDistance;
                    p.add(new MainPair(x.node,dist[x.node]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        sc.close();
    }
}
