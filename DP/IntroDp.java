package DP;

import java.util.Arrays;
import java.util.Scanner;

public class IntroDp {

    //Memoization tc-O(N) and sc-0(N)->stack space +0(N)->extra array
    static int fib(int n,int dp[]){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fib(n-1, dp)+fib(n-2, dp);
    }
    public static void main(String[] args) {
        int n;
        System.out.println("enter the size of dpArray:");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("This is Memoization:");
        System.out.println(fib(4,dp));
        for(int i=0;i<=n;i++){
           int ans = fib(i,dp); 
           System.out.print(ans+" ");
        }
        System.out.print("\nThis is tabulation:"); //tc-0(n) sc-o(n)
        int dp2[]=new int[n+1];
        dp2[0]=0;
        dp2[1]=1;
        for (int i = 2; i < dp2.length; i++) {
            dp2[i]=dp2[i-1]+dp2[i-2];
        }
        System.out.println(Arrays.toString(dp2));

        sc.close();
        


    }
    
}
