package TwoPointerAndSlidingWindow;

import java.util.Scanner;

/*
There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1.
 However, choosing the rightmost card first will maximize your total score. 
 The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 */
public class Prob_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array:");
        int n=sc.nextInt();
        int cardPoints[] = new int[n];
        for(int i=0;i<n;i++){
            cardPoints[i]=sc.nextInt();
        }
        System.out.println("enter the value of k:");
        int k=sc.nextInt();
        int maxScore=0;
        int lsum=0;
        int rsum=0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        maxScore=lsum;
        int rindex=n-1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rindex];
            rindex--;
            maxScore=Math.max(maxScore,rsum+lsum);
        }
        System.out.println("Maximum points scored is:"+maxScore);
        sc.close();
        
    }
}
