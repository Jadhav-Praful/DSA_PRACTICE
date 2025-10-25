package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*Distance of Nearest Cell having 1

Problem Statement: Given a binary grid of N*M. Find the distance of the nearest 1 in the grid for each cell.

The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1.
 */
class Pair4{
    int first;
    int second;
    int step;
    Pair4(int f,int s,int t){
        this.first=f;
        this.second=s;
        this.step=t;
    }
}
public class prob_4 {

    static int[][] NearestOnesMatrix(int n,int m,int[][] grid){
        int vis[][] = new int[n][m];
        int ans[][] = new int[n][m];
        Queue<Pair4> q =new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    vis[i][j]=1;
                    q.add(new Pair4(i, j, 0));
                }else{
                    vis[i][j]=0;
                }
            }
        }
        int drow[]={-1,0,+1,0};
        int dcol[]={0,+1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c= q.peek().second;
            int st=q.peek().step;
            q.remove();
            ans[r][c]=st;
            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new Pair4(nr, nc, st+1));

            }
            }
            

        }
         for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int[][] grid = {{0,1,1,0},
                        {1,1,0,0}, 
                        {0,0,1,1}};
        int n=grid.length;
        int m=grid[0].length;
        
        NearestOnesMatrix(n,m,grid);

       
    }
    
}
