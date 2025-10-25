package Graphs;


/*
Number of Islands

Problem Statement: Given a grid of size NxM (N is the number of rows and M is the number of columns in the grid) consisting of '0's (Water) and ‘1's(Land). 
Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Pre-req: Connected Components, Graph traversal techniques
 */
public class prob_20 {

    static void dfsIsland(int i,int j,int[][] grid,int[][] vis,int n,int m){
        vis[i][j]=1;
        int drow[] = {-1,-1,0,+1,+1,-1,0,-1};
        int dcol[] = {0,+1,+1,+1,0,-1,-1,-1};
        for(int k=0;k<8;k++){
            int nrow = i + drow[k];
            int ncol = j + dcol[k];

            if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfsIsland(nrow, ncol, grid, vis, n, m);
            }
        }
    }
    public static void main(String[] args) {

        // int grid[][] = {
        //                 {0,1,1,0},
        //                 {0,1,1,0},
        //                 {0,0,1,0},
        //                 {0,0,0,0},
        //                 {1,1,0,1}
        //                 };
        int [][] grid = {{0,1,1,0,1,0,0},{0,0,1,1,0,1,0}};
        int n=grid.length;
        int m=grid[0].length;
        int vis[][] = new int[n][m];
        int NumberOfIsland=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    dfsIsland(i,j,grid,vis,n,m);
                    NumberOfIsland++;
                }
            }
        }

        System.out.println("The number of island are : "+ NumberOfIsland);
    }
}
