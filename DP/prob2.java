package DP;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement:
Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. 
At a time the frog can climb either one or two steps. A height[N] array is also given. 
Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. 
We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1

 */
public class prob2 {
    public static void main(String[] args) {
        int n;
        System.out.println("enter the size of dpArray:");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int height[]=new int[n];
        for (int i = 0; i < height.length; i++) {
            height[i]= sc.nextInt();
        }
        int dp[] = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int oneStep = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }
            dp[i] = Math.min(oneStep, twoStep);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println("minimum energy required is:"+dp[n-1]);
        sc.close();
    }
    
}
