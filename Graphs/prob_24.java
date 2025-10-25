package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

/*Problem Statement I (Course Schedule): There are a total of n tasks you have to pick, labeled from 0 to n-1. 
Some tasks may have prerequisites tasks, for example, to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]

Given the total number of n tasks and a list of prerequisite pairs of size m. Find the order of tasks you should pick to finish all tasks.

Note: There may be multiple correct orders, you need to return one of them. If it is impossible to finish all tasks, return an empty array.

Problem Statement II (Pre-requisite Tasks): There are a total of N tasks, labeled from 0 to N-1. 
Some tasks may have prerequisites, for example, to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]

Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.

Note: These two questions are linked. The second question asks if it is possible to finish all the tasks and the first question states to return.
The ordering of the tasks if it is possible to perform all the tasks, otherwise return an empty array.
 */

public class prob_24 {

    static boolean dfsworkDone(int node,ArrayList<ArrayList<Integer>> adjList,int[] vis,int[]pathvis){
        
        vis[node]=1;
        pathvis[node]=1;
        for(int x:adjList.get(node)){
            if(vis[x]==0){
                if(dfsworkDone(x, adjList, vis, pathvis)==true){
                    return true;
                }
            }
            else if(pathvis[x]==1){
                return true;
            }
        }
        pathvis[node]=0;
        return false;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of vertices");
        int V = sc.nextInt();
        System.out.println("enter the no of edges");
        int E =sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList =new ArrayList<>();

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
                if(dfsworkDone(k,adjList,vis,pathvis)){
                    workDone=true;
                    break;
                }
            }
        }
        if(workDone){
            System.out.println("Task Course cannot be Done");
        }
        else{
            System.out.println("Task Course can be Done");
        }
        sc.close();
    }
    
}
