package DP;

import java.util.Scanner;

/*Problem Statement:
Given an array of ‘N’  positive integers,
 we need to return the maximum sum of the subsequence such that no two elements of the subsequence are adjacent elements in the array.
Note: A subsequence of an array is a list with elements of the array where some elements are deleted ( or not deleted at all).
the elements should be in the same order in the subsequence as in the array.
 */
public class prob4 {

    static int brute(int ind,int arr[]){
        if(ind==0) return arr[ind];
        if(ind<0) return 0;
        int pick = arr[ind]+brute(ind-2, arr);
        int notPick = brute(ind-1, arr);
        return Math.max(pick, notPick);
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
        int answer = brute(n-1, arr);
        System.out.println("Maximum sum of subsequence is:"+answer);
        sc.close();
    }
}
