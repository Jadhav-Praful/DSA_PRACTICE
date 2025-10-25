package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
// Extention of 24TH question 
public class prob_25 {


    static void dfsTopologicalSort(int node, ArrayList<ArrayList<Integer>> adjList,int[]vis,Stack<Integer> st){
        
        vis[node]=1;
        for(int x:adjList.get(node)){
            if(vis[x]==0){
                dfsTopologicalSort(x, adjList, vis,st);
            }
        }
        st.push(node);

        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of vertices");
        int V = sc.nextInt();
        System.out.println("enter the no of edges");
        int E =sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList =new ArrayList<>();
        Stack<Integer> st =new Stack<>();
        for(int i=0;i<=V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int j=0;j<E;j++){
            int u = sc.nextInt();
            int v=sc.nextInt();
            adjList.get(u).add(v);
        }
        boolean workDone=false;
        int vis[] = new int[V+1];
        int pathvis[] =new int[V+1];
        for(int k=0;k<V;k++){
            if(vis[k]==0){
                if(prob_24.dfsworkDone(k,adjList,vis,pathvis)){
                    workDone=true;
                    break;
                }else{
            dfsTopologicalSort(k, adjList, vis, st);
        }
            }
        }
        if(workDone){
            System.out.println("[]");
        }else{
            while(!st.isEmpty()){
                System.out.print(st.pop()+" ");
            }
        }
        sc.close();
        
    }
    
}