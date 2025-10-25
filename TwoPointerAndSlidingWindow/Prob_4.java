package TwoPointerAndSlidingWindow;
import java.util.HashSet;
/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. 
The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. 
The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees. */
import java.util.Scanner;

public class Prob_4 {

    static void bruteforce(int arr[],int n){

        int maxLen=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> st=new HashSet<>();
            for(int j=i;j<n;j++){
                st.add(arr[j]);
                if(st.size()<=2){
                    maxLen=Math.max(maxLen, j-i+1);
                }
                else{
                    break;
                }
            }
        }
        System.out.println("MaxLength of maximum type of fruits collected :"+maxLen);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array:");
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        bruteforce(arr,n);


        sc.close();
    }
    
}
