package Graphs;

import java.util.PriorityQueue;
import java.util.Scanner;

/*Path With Minimum Effort

You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
where heights[row][col] represents the height of the cell (row, col). You are situated in the top-left cell, (0, 0), 
and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,0-indexed). You can move up, down, left, or right, 
and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 */
class Jodi1{
    int row;
    int col;
    int diff;
    Jodi1(int r,int c,int d){
        this.row= r;
        this.col =c;
        this.diff =d;
    }
}
public class prob_8 {
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the no of row and coloumn");
        int V =sc.nextInt();
        int E = sc.nextInt();
        int[][] grid = new int[V][E];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                grid[i][j] =sc.nextInt();
            }
        }
        System.out.println("/nHeight of peeks Matrix");
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        int[][] dist = new int[V][E];
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist[i].length;j++){
                dist[i][j] =(int)1e9;
            }
        }
        System.out.println("enter the source  i and j to start Minimum effort to hike:");
        int srci=sc.nextInt();
        int srcj=sc.nextInt();
        sc.close();
        PriorityQueue<Jodi1> pq= new PriorityQueue<>((x,y)->x.diff-y.diff);
        dist[srci][srcj]=0;
        pq.add(new Jodi1(srci, srcj, 0));
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        while(!pq.isEmpty()){
            Jodi1 curr =pq.poll();
            int r = curr.row;
            int c= curr.col;
            int di = curr.diff;
            pq.remove(curr);
            if(r == V-1 && c ==E-1){
              System.out.println(di);
              return;
            } 
            for(int i=0;i<4;i++){
                int nr = r +drow[i];
                int nc = c +dcol[i];
                if(nr>=0 && nr< V && nc>=0 && nc < E){
                    int minEffort = Math.max(Math.abs(grid[r][c] - grid[nr][nc]),di);
                    if(minEffort < dist[nr][nc]){
                        dist[nr][nc] =minEffort;
                        pq.add(new Jodi1(nr, nc, minEffort));
                    }
                }
            }
        }

        
    }
}
