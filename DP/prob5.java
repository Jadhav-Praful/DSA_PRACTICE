package DP;

import java.util.Scanner;

/*Problem Statement 
A thief needs to rob money in a street. The houses in the street are arranged in a circular manner. 
Therefore the first and the last house are adjacent to each other. 
The security system in the street is such that if adjacent houses are robbed, the police will get notified.
Given an array of integers “Arr'' which represents money at each house, 
we need to return the maximum amount of money that the thief can rob without alerting the police.
 */
public class prob5 {

    static int optimalSpace(int arr[]){
        int n=arr.length;
        int prev =arr[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int take=arr[i];
            if(i>1) take+=prev2;
            int nTake = 0+prev;
            int cur = Math.max(take,nTake);
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
    public static void main(String[] args) {
        int n;
        System.out.println("enter the size of Array:");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
        int temp1[]=new int[n];
        int temp2[]=new int[n];
        for(int i=0;i<n;i++){
            if(n==1) {
                System.out.println("max money can robbed:"+arr[0]);
                return;
            }
            if(i!=0) temp1[i]=arr[i];
            if(i!=n-1) temp2[i]=arr[i];
        }
        int ans = Math.max(optimalSpace(temp1),optimalSpace(temp2));
        System.out.println("max money can robbed:"+ans);
        sc.close();
    }
    
}
