package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Cheapest Flights Within K Stops

There are n cities and m edges connected by some number of flights. 
You are given an array of flights where flights[i] = [ fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost price. 
You have also given three integers src, dst, and k, and return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 */
class Pair6{
    int node;
    int distance;
    Pair6(int n,int d){
        this.node=n;
        this.distance=d;
    }
}
class Tuple{
    int stops;
    int node;
    int distance;
    Tuple(int s,int node,int distance){
        this.stops=s;
        this.node=node;
        this.distance=distance;
    }
}
public class prob_31 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("number of vertices and edges");
        int V =sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Pair6>> adjList= new ArrayList<>();

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int j=0;j<E;j++){
            int u = sc.nextInt();
            int v=sc.nextInt();
            int wt=sc.nextInt();
            adjList.get(u).add(new Pair6(v, wt));
            // adjList.get(v).add(new Pair6(u, wt));
        }

        System.out.println("\nAdjacency List");
        for(int m=0;m<V;m++){
            System.out.print(m+":");
            for(Pair6 n : adjList.get(m)){
                System.out.print("{"+n.node+","+n.distance+"}");
            }
            System.out.println();
        }
        int[] dist = new int[V];
        for(int x=0;x<V;x++) dist[x]=(int)1e9;
        Queue<Tuple> pq =new LinkedList<>();
        System.out.println("enter the source node and no of stops");
        int src = sc.nextInt();
        int K = sc.nextInt();
        dist[src]=0;
        pq.add(new Tuple(0,src,0));
        while(!pq.isEmpty()){
            Tuple cur = pq.poll();
            int curVal =cur.node;
            int curDist = cur.distance;
            int stops =cur.stops;
            if(stops > K) continue;
            for(Pair6 x : adjList.get(curVal)){
                if(x.distance+curDist < dist[x.node] && stops<=K){
                    dist[x.node]=x.distance+curDist;
                    pq.add(new Tuple(stops+1,x.node,dist[x.node])); 
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        if(dist[V-1]==(int)1e9) System.out.println("Unreachable");
        sc.close();
        
    }
    
}
