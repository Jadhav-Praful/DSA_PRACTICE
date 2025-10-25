package TwoPointerAndSlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Prob_5 {

    static void bruteforce(String s,int k){
        int n= s.length();
        int maxLen=0;
       for(int i=0;i<n;i++){
            HashSet<Character> st=new HashSet<>();
            for(int j=i;j<n;j++){
                st.add(s.charAt(j));
                if(st.size()<=k){
                    maxLen=Math.max(maxLen, j-i+1);
                }
                else{
                    break;
                }
            }
        }
        System.out.println("MaxLength of maximum type of fruits collected :"+maxLen);
        
    }

    static void optimal(String s, int k) {
    int maxLen = 0;
    int r = 0, l = 0;
    HashMap<Character, Integer> hm = new HashMap<>();

    while (r < s.length()) {
        char c = s.charAt(r);
        hm.put(c, hm.getOrDefault(c, 0) + 1);

        while (hm.size() > k) {
            char leftChar = s.charAt(l);
            hm.put(leftChar, hm.get(leftChar) - 1);
            if (hm.get(leftChar) == 0) {
                hm.remove(leftChar);
            }
            l++;
        }

        maxLen = Math.max(maxLen, r - l + 1);
        r++;
    }

    System.out.println("ml: " + maxLen);
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string:");
        String str = sc.nextLine();
        int k=sc.nextInt();
        bruteforce(str,k);
        optimal(str,k);
        sc.close();

    }
    
}
