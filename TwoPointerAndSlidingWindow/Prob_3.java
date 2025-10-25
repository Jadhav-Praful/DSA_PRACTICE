package TwoPointerAndSlidingWindow;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
import java.util.Scanner;

public class Prob_3 {

    static void bruteforce(int arr[],int k,int n){
         int zero=0;
        int len=0;
        int maxLen=0;
        for(int i=0;i<n;i++){
            zero=0;
            for(int j=i;j<n;j++){
                if(arr[j]==0){
                    zero++;
                }
                if(zero<=k){
                    len=j-i+1;
                    maxLen=Math.max(maxLen,len);
                }
                else{
                    break;
                }
            }
        }
        System.out.println("longest subarray:"+maxLen);
    }

    static void optimal(int arr[],int k,int n){
        int zero=0;
        int l=0;
        int r=0;
        int maxLen=0;
        int len=0;
        while (r<n) {
            if(arr[r]==0) zero++;
            if(zero>k) {
                if(arr[l]==0){
                    zero--;
                }
                l++;
            }
            if(zero<=k){
                len=r-l+1;
                maxLen=Math.max(maxLen, len);
            }
            r++;
        }
        System.out.println("maxlength:"+maxLen);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array:");
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the value of k:");
        int k=sc.nextInt();
        bruteforce(arr,k,n);
        optimal(arr,k,n);
        sc.close();
    }
}
