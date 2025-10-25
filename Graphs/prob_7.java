package Graphs;

// import java.util.Arrays;
// import java.util.LinkedList;
import java.util.PriorityQueue;
// import java.util.Queue;

/*Shortest Distance in a Binary Maze

Problem Statement: 

Given an n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. 
The path can only be created out of a cell if its value is 1. 

If the path is not possible between the source cell and the destination cell, then return -1.

Note: You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. 
In other words, you can move in one of four directions, Up, Down, Left, and Right.
 */

class Jodi{
    int nodei;
    int nodej;
    int dist;
    public Jodi(int i,int j,int d){
        this.nodei=i;
        this.nodej=j;
        this.dist=d;
    }
}
public class prob_7 {
    public static void main(String[] args) {
        int grid[][] = {{1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 1}};

        
                int n= grid.length;
                int m= grid[0].length;
                int dist[][]=new int[n][m];

                for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist[i].length;j++){
                dist[i][j] =(int)1e9;
            }
        }
                int source[]={0,1};
                int destination[]={2,2};
                // Queue<Jodi> pq =new LinkedList<>();
                PriorityQueue<Jodi> pq =new PriorityQueue<>((x,y)->x.dist-y.dist);
                dist[source[0]][source[1]]=0;
                pq.add(new Jodi(source[0],source[1],0));
                int drow[] = {-1,0,+1,0};
                int dcol[] = {0,+1,0,-1};
                while(!pq.isEmpty()){
                    int a = pq.peek().nodei;
                    int b = pq.peek().nodej;
                    int wt =pq.peek().dist;
                    pq.remove();
                    for(int i=0;i<4;i++){
                        int ni = a + drow[i];
                        int nj = b + dcol[i];
                        if(ni>=0 && ni < n && nj >=0 && nj < m && grid[ni][nj]==1 && wt + 1 < dist[ni][nj]){
                                dist[ni][nj]=wt+ 1;
                                if(ni == destination[0] && nj == destination[1]){
                                    System.out.println(wt+1);
                                    break;
                                }
                                pq.add(new Jodi(ni, nj, wt+1));
                        }

                    }
                }
                // System.out.println(-1);
    }
}
