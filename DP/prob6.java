package DP;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement: A Ninja has an ‘N’ Day training schedule. 
He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day. 
There are merit points associated with performing an activity each day. The same activity can’t be performed on two consecutive days. 
We need to find the maximum merit points the ninja can attain in N Days.
We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity on that particular day. 
Our task is to calculate the maximum number of merit points that the ninja can earn.
 */
public class prob6 {

    static int bruteForceSolution(int day,int lastTask,int arr[][]){
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=lastTask){
                 maxi = Math.max(maxi,arr[day][i]);  
                }
            }
            return maxi; 
        }
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=lastTask){
             int points = arr[day][i]+bruteForceSolution(day-1, i, arr);
            maxi = Math.max(maxi, points);   
            }    
        }
        return maxi;
    }
    static int MemoizationDP(int day,int lastTask,int arr[][]){
        int dp[][] = new int[arr.length][4];
        for (int[] row : dp) Arrays.fill(row, -1); 
    
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=lastTask){
                 maxi = Math.max(maxi,arr[day][i]);  
                }
            }
            return maxi; 
        }
        if(dp[day][lastTask]!=-1) return dp[day][lastTask];
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=lastTask){
             int points = arr[day][i]+bruteForceSolution(day-1, i, arr);
            maxi = Math.max(maxi, points);   
            }    
        }
        return dp[day][lastTask]=maxi;
    }
    public static void main(String[] args) {
        int n;
        System.out.println("enter the size of Array:");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int arr[][]=new int[n][3];
        for (int i = 0; i < n; i++) {
            for(int j=0;j<3;j++){
               arr[i][j]= sc.nextInt(); 
            }
        }
        System.out.println("Training schedule");
        for (int i = 0; i < n; i++) {
            for(int j=0;j<3;j++){
               System.out.print(arr[i][j]+" "); 
            }
            System.out.println();
        }
        int maxPoints = bruteForceSolution(n-1,3,arr);
        System.out.println("Maximum Points Secured:"+maxPoints);
        int maxPoints2 = MemoizationDP(n-1,3,arr);
        System.out.println("Maximum Points Secured optimal:"+maxPoints2);
        sc.close();
    }
}
