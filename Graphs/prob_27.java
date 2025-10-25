package Graphs;

import java.util.ArrayList;
import java.util.Stack;

/*
Alien Dictionary - Topological Sort
Problem Statement: Given a sorted dictionary of an alien language having N words and k starting alphabets of a standard dictionary. 
Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order.
 */
public class prob_27 {

    static Stack<Integer> dfs(int node,int k,ArrayList<ArrayList<Integer>> adjList,int[]vis,int[]pathvis,Stack<Integer> st){
        vis[node]=1;
        vis[node]=1;
        for(int x:adjList.get(node)){
            if(vis[x]==0){
                dfs(x, k, adjList, vis,pathvis, st);
            }
            else if(pathvis[x]==1){
                return new Stack<Integer>(){};
            }
        }
        pathvis[node]=0;
        st.push(node);
        return st;
    }
    static ArrayList<Integer> topoSort(int k,ArrayList<ArrayList<Integer>> adjList){

        Stack<Integer> st =new Stack<>();
        int[] vis = new int[k];
        int[] pathvis =new int[k];
        for(int i=0;i<k;i++){
            if(vis[i]==0){
                st = dfs(i,k,adjList,vis,pathvis,st);
            }
        }
        ArrayList<Integer> al =new ArrayList<>();
        while(!st.isEmpty()){
            al.add(st.pop());
        }
        return al;

    }
    public static void main(String[] args) {

        int N = 5; //element in dictionary;
        int k = 4; // no of vertices

        String[] dict = {"baa","abcd","abca","cab","cad"};

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<k;i++){
            adjList.add(new ArrayList<>());
        }
        for(int j=0;j<N-1;j++){
            String s1 = dict[j];
            String s2 = dict[j+1];
            int len = Math.min(s1.length(),s2.length());
            for(int p=0;p<len;p++){
                if(s1.charAt(p)!=s2.charAt(p)){
                    adjList.get(s1.charAt(p)-'a').add(s2.charAt(p)-'a');
                    break;
                }
            }
        }

        ArrayList<Integer> al = topoSort(k,adjList);
        String ans ="";
        for(int x:al){
            ans = ans + (char)(x+(int)('a'));
        }

        System.out.println(ans);
        
    }
    
}
