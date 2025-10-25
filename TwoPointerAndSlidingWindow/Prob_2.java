package TwoPointerAndSlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers. */
public class Prob_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int maxLength=0;
        int hash[] =new int[256];
        Arrays.fill(hash,-1);
        int len=0;
        int l=0;
        int r=0;
        while(r<input.length()){
            if(hash[input.charAt(r)]!=-1&&  hash[input.charAt(r)]>=l){
                l=hash[input.charAt(r)]+1;
            }
            len=r-l+1;
            maxLength=Math.max(maxLength, len);
            hash[input.charAt(r)]=r;
            r++;
        }
        System.out.println("Maxlength:"+maxLength);
        sc.close();
        
    }
    
}
