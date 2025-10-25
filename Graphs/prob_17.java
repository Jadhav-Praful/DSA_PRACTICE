package Graphs;

/*
Number of Enclaves

Problem Statement: You are given an N 0 M binary matrix grid, where 0 represents a sea cell and 1 represents a land cell. 
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid. 
Find the number of land cells in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 */
public class prob_17 {

    static void dfsConvertXToO(int loc,int i,int[][]vis , int[][] grid,int[] drow,int[]dcol){

        vis[loc][i]=1;
        int n = grid.length;
        int m =grid[0].length;
        for(int j=0;j<4;j++){
            int newr= loc + drow[j];
            int newc = i+ dcol[j];
            if(newr>=0 && newr< n && newc>=0 && newc < m && vis[newr][newc] == 0 && grid[newr][newc] == 1){
                dfsConvertXToO(newr, newc, vis, grid,drow,dcol);
            }
        }
    }
    public static void main(String[] args) {
        
        int grid[][] = {
                        {0,0,0,0},
                        {1,0,1,0},
                        {0,1,1,0},
                        {0,0,0,0},
                        };
        int n=grid.length;
        int m=grid[0].length;
        //before changes
        System.out.println("Initial matrix");
         for(int p=0;p<n;p++){
            for(int k=0;k<m;k++){
                    System.out.print(grid[p][k]+" ");    
            }
            System.out.println();
        }

        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        int vis[][] =new int[n][m];
        //first row and last row
        for(int i=0;i<m;i++){

            if(vis[0][i]==0 && grid[0][i]==1){
                dfsConvertXToO(0, i, vis, grid,drow,dcol);
            }

            if(vis[n-1][i]==0 && grid[n-1][i]==1){
                dfsConvertXToO(n-1, i, vis, grid,drow,dcol);
            }
        }

        //first col and last col
        for(int j=0;j<n;j++){

            if(vis[j][0]==0 && grid[j][0]==1){
                dfsConvertXToO(j, 0, vis, grid,drow,dcol);
            }

            if(vis[j][m-1]==0 && grid[j][m-1]==1){
                dfsConvertXToO(j, m-1, vis, grid,drow,dcol);
            }
        }
       int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
