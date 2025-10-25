package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*Number of Ways to Arrive at Destination

You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. 
The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array ‘roads’ where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. 
You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
 */

class MPair {
    int node;
    int distance;
    MPair(int n,int d){
        this.node=n;
        this.distance=d;
    }
}
public class prob_9 {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.println("number of vertices and edges");
        int V =sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<MPair>> adjList= new ArrayList<>();

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int j=0;j<E;j++){
            int u = sc.nextInt();
            int v=sc.nextInt();
            int wt=sc.nextInt();
            adjList.get(u).add(new MPair(v, wt));
            adjList.get(v).add(new MPair(u, wt));
        }

        System.out.println("\nAdjacency List");
        for(int m=0;m<V;m++){
            System.out.print(m+":");
            for(MPair n : adjList.get(m)){
                System.out.print("{"+n.node+","+n.distance+"}");
            }
            System.out.println();
        }
        int[] ways = new int[V];
        int[] dist = new int[V];
        for(int x=0;x<V;x++) dist[x]=(int)1e9;
        PriorityQueue<MPair> pq =new PriorityQueue<>((x,y)->x.distance-y.distance);
        System.out.println("enter the source node");
        int src = sc.nextInt();
        dist[src]=0;
        ways[src]=1;
        pq.add(new MPair(src,0));
        int mod = (int)(1e9+7);
        while(!pq.isEmpty()){
            MPair cur = pq.poll();
            int curVal =cur.node;
            int curDist = cur.distance;
            pq.remove(cur);
            for(MPair x : adjList.get(curVal)){
                if(x.distance+curDist < dist[x.node]){
                    dist[x.node]=x.distance+curDist;
                    pq.add(new MPair(x.node,dist[x.node]));
                    ways[x.node]=ways[curVal];
                }else if(x.distance+curDist == dist[x.node]){
                    ways[x.node]=(ways[curVal]+ways[x.node])%mod;
                }
            }
        }
        // System.out.println(Arrays.toString(ways));
        System.out.println(ways[V-1]%mod);
        sc.close();
    }
    
}
/*
input:
7 10
0 1 2
0 4 5
0 6 7
4 6 2
6 5 1
6 3 3
3 5 1
1 3 3
1 2 3
2 5 1 
output:
4
*/