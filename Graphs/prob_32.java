package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Minimum Multiplications to Reach End

Given start, end, and an array arr of n numbers. At each step, the start is multiplied by any number in the array and 
then a mod operation with 100000 is done to get the new start.
Your task is to find the minimum steps in which the end can be achieved starting from the start. If it is not possible to reach the end, then return -1.

Example 1:

Input:
arr[] = {2, 5, 7}
start = 3
end = 30

Output:
2
 */
public class prob_32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Array:");
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i]= sc.nextInt();
        }
        Queue<Pair6> q =new LinkedList<>();
        System.out.println("enter the start and end");
        int start =sc.nextInt();
        int end=sc.nextInt();
        int dist[] = new int[100000];
        Arrays.fill(dist,(int)1e9);
        q.add(new Pair6(start,0));
        dist[start]=0;
        int mod =100000;
        while(!q.isEmpty()){
            int node = q.peek().node;
            int steps=q.peek().distance;
            q.remove();
            for(int x : arr){
                int nextNum = (x*node)%mod;
                if(steps+1 < dist[nextNum]){
                    dist[nextNum]=steps+1;
                    if(nextNum==end) {System.out.println(steps+1); break;}
                    q.add(new Pair6(nextNum,dist[nextNum]));
                }  
            }
        }
        if(dist[end]==(int)1e9){
            System.out.println(-1);
        }
        sc.close();
    }
}
