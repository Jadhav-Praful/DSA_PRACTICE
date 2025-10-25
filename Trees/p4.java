package Trees;

import java.util.Arrays;
import java.util.Scanner;

public class p4 {

    static void preOrder(int arr[],int root){
        if(root>=arr.length || arr[root]==-1){
            return;
        }
        System.out.print(arr[root]+" ");
        preOrder(arr,root*2);//left
        preOrder(arr,root*2+1);//right
    }
    static int balancedTreeOrNot(int arr[],int root){
         if(root>=arr.length || arr[root]==-1){
            return 0;
        }
        int lh=balancedTreeOrNot(arr, root*2);
        if(lh==-1) return -1;
        int rh=balancedTreeOrNot(arr, root*2+1);
        if(rh==-1) return -1;
        if(Math.abs(rh-lh)>1) return -1;
        return Math.max(lh, rh)+1;
    }
    public static void main(String[] args) {
            System.out.println("enter number of nodes(-1 for no node)");
            int arr[] = new int[16];
            Arrays.fill(arr,-1);
            Scanner sc=new Scanner(System.in);
            for(int i=1;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println("Preorder Traversal:");
            preOrder(arr, 1);
            System.out.println(balancedTreeOrNot(arr, 1)!=-1);
            sc.close();
    }
    
}
