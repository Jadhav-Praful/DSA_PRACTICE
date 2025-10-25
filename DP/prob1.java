package DP;

import java.util.Scanner;

/*Handwritten Task:

Problem Statement: Given a number of stairs. Starting from the 0th stair we need to climb to the “Nth” stair. 
At a time we can climb either one or two steps. We need to return the total number of distinct ways to reach from 0th to Nth stair.
 */
public class prob1 {
    //Memoization tc-O(N) and sc-0(N)->stack space +0(N)->extra array 
    static int fib(int n,int dp[]){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fib(n-1, dp)+fib(n-2, dp);
    }
    static int optimal(int n){
        if(n<=1) return 1;
        int prev1=1;
        int prev=1;
        int cur=0;
        for(int i=2;i<=n;i++){
            cur=prev+prev1;
            prev1=prev;
            prev=cur;
        }
        return prev;
    }
    static int climbStairsOptimal(int n) {
    if (n <= 1) return 1;
    int prev1 = 0, prev = 1, curr = 0;
    for (int i = 2; i <= n; i++) {
        curr = prev + prev1;
        prev1 = prev;
        prev = curr;
    }
    return prev;
}
    public static void main(String[] args) {
        int n;
        System.out.println("enter the size of dpArray:");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // System.out.println("This is Memoization:");
        // for(int i=0;i<=n;i++){
        //    int ans = fib(i,dp); 
        //    System.out.print(ans+" ");
        // }

        System.out.println("Total no of way we can climb are:"+optimal(n));
        sc.close();
    }
}
