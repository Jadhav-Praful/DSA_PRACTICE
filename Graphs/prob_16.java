package Graphs;
/*
Surrounded Regions | Replace O’s with X’s
Problem Statement: Given a matrix mat of size N x M where every element is either ‘O’ or ‘X’. 
Replace all ‘O’ with ‘X’ that is surrounded by ‘X’. 
An ‘O’ (or a set of ‘O’) is considered to be surrounded by ‘X’ if there are ‘X’ at locations just below, just above just left, and just right of it.
 */
public class prob_16 {

    static void dfsConvertXToO(int loc,int i,int[][]vis , char [][] grid,int[] drow,int[]dcol){

        vis[loc][i]=1;
        int n = grid.length;
        int m =grid[0].length;
        for(int j=0;j<4;j++){
            int newr= loc + drow[j];
            int newc = i+ dcol[j];
            if(newr>=0 && newr< n && newc>=0 && newc < m && vis[newr][newc] == 0 && grid[newr][newc] == 'O'){
                dfsConvertXToO(newr, newc, vis, grid,drow,dcol);
            }
        }
    }

    public static void main(String[] args) {
        
        char grid[][] = {
                        {'X','X','X','X'},
                        {'X','O','X','X'},
                        {'X','O','O','X'},
                        {'X','O','X','X'},
                        {'X','X','O','O'}
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

            if(vis[0][i]==0 && grid[0][i]=='O'){
                dfsConvertXToO(0, i, vis, grid,drow,dcol);
            }

            if(vis[n-1][i]==0 && grid[n-1][i]=='O'){
                dfsConvertXToO(n-1, i, vis, grid,drow,dcol);
            }
        }

        //first col and last col
        for(int j=0;j<n;j++){

            if(vis[j][0]==0 && grid[j][0]=='O'){
                dfsConvertXToO(j, 0, vis, grid,drow,dcol);
            }

            if(vis[j][m-1]==0 && grid[j][m-1]=='O'){
                dfsConvertXToO(j, m-1, vis, grid,drow,dcol);
            }
        }
       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='O'){
                    grid[i][j]='X';
                }
            }
        }
        //after the changes
        System.out.println("Final matrix");
        for(int s=0;s<n;s++){
            for(int l=0;l<m;l++){
                    System.out.print(grid[s][l]+" ");    
            }
            System.out.println();
        }

        
    }
}
