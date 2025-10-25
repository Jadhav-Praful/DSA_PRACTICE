package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.LinkedList;
// import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*Shortest Path in Directed Acyclic Graph Topological Sort

Given a DAG, find the shortest path from the source to all other nodes in this DAG. 
In this problem statement, we have assumed the source vertex to be ‘0’. You will be given the weighted edges of the graph.

Note: What is a DAG ( Directed Acyclic Graph)?

A Directed Graph (containing one-sided edges) having no cycles is said to be a Directed Acyclic Graph.
 */

class Pair2{
    int node;
    int dist;
    public Pair2(int n,int d){
        this.node=n;
        this.dist=d;
    }
}
public class prob_29 {
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the no of vertices and edges");
        int v = sc.nextInt();
        int e =sc.nextInt();

        ArrayList<ArrayList<Pair2>> adjList =new ArrayList<>();

        for(int i=0;i<v;i++){
            
            adjList.add(new ArrayList<>());
        }
        for(int j=0;j<e;j++){
            int u=sc.nextInt();
            int p=sc.nextInt();
            int wt=sc.nextInt();
            adjList.get(u).add(new Pair2(p, wt));
        }
        

        int dist[] =new int[v];
        for(int l=0;l<v;l++){
            dist[l]=(int)1e9;
        }
        Stack<Integer> st=new Stack<>();
        System.out.println("enter the source vertex");
        int src =sc.nextInt();
        dist[src]=0;
        st.push(src);
        while(!st.isEmpty()){
            int node = st.pop();
            for(Pair2 x : adjList.get(node)){
                if(x.dist < dist[x.node]){
                    dist[x.node]=x.dist;
                    st.push(x.node);
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        sc.close();

    }
}
