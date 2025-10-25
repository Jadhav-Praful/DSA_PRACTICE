package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Rotten Oranges : Min time to rot all oranges : BFS

Problem Statement: You will be given an m x n grid, where each cell has the following values : 

2  -  represents a rotten orange
1  -  represents a Fresh orange
0  -  represents an Empty Cell
Every minute, if a Fresh Orange is adjacent to a Rotten Orange in 4-direction ( upward, downwards, right, and left ) it becomes Rotten. 

Return the minimum number of minutes required such that none of the cells has a Fresh Orange. If it's not possible, return -1.

 */

class Pair3{
    int first;
    int second;
    int time;
    Pair3(int f,int s,int t){
        this.first=f;
        this.second=s;
        this.time=t;
    }
}
public class prob_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of rows");
        int r = sc.nextInt();
        System.out.println("enter the no of cols");
        int c = sc.nextInt();
        int grid[][]=new int[r][c];
        System.out.println("enter the input of grid");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println("Grid MATRIX");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        Queue<Pair3> q = new LinkedList<>();
        int vis[][]=new int[r][c];
        int freshCount=0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    q.add(new Pair3(i, j, 0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) freshCount++;
            }
        }

        int tm=0;
        int count=0;
        int drow[]={-1,0,+1,0};
        int crow[]={0,+1,0,-1};
        while(!q.isEmpty()){
            int n=q.peek().first;
            int m=q.peek().second;
            int t=q.peek().time;
            tm=Math.max(tm, t);
            q.remove();
            for(int i=0;i<4;i++){
                int newr=n+drow[i];
            int newc=m+crow[i];

            if(newr>=0 && newr< r && newc>=0 && newc < c && vis[newr][newc] == 0 && grid[newr][newc] == 1){
                            q.add(new Pair3(newr, newc, t+1));
                            vis[newr][newc]=2;
                            count++;
                }
            }
            
        }
        sc.close();
        if(count != freshCount) System.out.println(-1);
        else System.out.println(tm);
        
    }
    
    
}
