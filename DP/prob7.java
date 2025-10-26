package DP;

import java.util.Arrays;
import java.util.Scanner;

/*
Given two values M and N, which represent a matrix[M][N]. 
We need to find the total unique paths from the top-left cell (matrix[0][0]) to the rightmost cell (matrix[M-1][N-1]).
At any cell we are allowed to move in only two directions:- bottom and right.
 */
public class prob7 {
    static int uniquePath(int arr[][],int i,int j,int m,int n){
        if(i==m-1 && j==n-1) return 1;
        if(i>m || j>n) return 0;
        int right = uniquePath(arr, i, j+1, m, n);
        int bottom = uniquePath(arr, i+1, j, m, n);
        return right+bottom;
    }
    static int uniquePathOptimalMemoization(int arr[][],int i,int j,int m,int n){
        int dp[][]=new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1); 
        if(i==m-1 && j==n-1) return 1;
        if(i>m || j>n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = uniquePath(arr, i, j+1, m, n);
        int bottom = uniquePath(arr, i+1, j, m, n);
        return dp[i][j]=right+bottom;
    }
    static int uniquePathOptimalTabulation(int arr[][],int i,int j,int m,int n){
        int dp[][]=new int[m][n];
        for(int k=0;k<m;k++){
            for(int l=0;l<n;l++){
                if(k==0 && l==0) dp[0][0]=1;
                else
                {
                   int right=0,bottom=0;
                if(k>0){
                  right = dp[k-1][l]; 
                }
                if(l>0){
                bottom = dp[k][l-1]; 
                }
                dp[k][l]=right+bottom; 
                }  
            }
        }
        return dp[m-1][n-1];
       
    }
    public static void main(String[] args) {
        int m,n;
        System.out.println("enter the size of Array m nad n:");
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        int arr[][]=new int[m][n];
        for (int i = 0; i < m; i++) {
            for(int j=0;j<n;j++){
               arr[i][j]= sc.nextInt(); 
            }
        }

        int count = uniquePathOptimalTabulation(arr,0,0,m,n);
        System.out.println("No of unique paths to reach destination:"+count);
        sc.close();
    }
    
}
