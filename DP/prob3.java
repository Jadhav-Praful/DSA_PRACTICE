package DP;

import java.util.Arrays;
import java.util.Scanner;

/*
follow up question for 2nd one 
 */
public class prob3 {
    public static void main(String[] args) {
        int n;
        System.out.println("enter the size of dpArray:");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        System.out.println("enter the k val:");
        int k=sc.nextInt();
        int height[]=new int[n];
        for (int i = 0; i < height.length; i++) {
            height[i]= sc.nextInt();
        }
        int dp[] = new int[n];
        dp[0]=0;
        int min=Integer.MAX_VALUE;
        int Steps;
        for(int i=1;i<n;i++){
            Steps=0;
            for(int j=0;j<=k;j++){
                if(i-j>=0){
                  Steps = dp[n - i] + Math.abs(height[i] - height[i - 1]);
                min=Math.min(Steps, min);
                } 
            }
            dp[i] =min ;
            }
            
        System.out.println(Arrays.toString(dp));
        System.out.println("minimum energy required is:"+dp[n-1]);
        sc.close();
    }
}