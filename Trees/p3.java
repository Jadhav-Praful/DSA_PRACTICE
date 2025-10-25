package Trees;
//Height of a binary tree or max depth of binary tree

import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode l;
    TreeNode r;
    TreeNode(int v){
        this.val=v;
        l=r=null;
    }
}
public class p3 {
    static TreeNode root=null;

    static TreeNode insertNode(TreeNode root,int v){
        if(root==null){
            return new TreeNode(v);
        }
        if(v<root.val ){
            root.l=insertNode(root.l, v);
        }
        else{
            root.r=insertNode(root.r, v);
        }
        return root;
    }

    static void displayInorder(TreeNode root){
        if(root==null){
            return;
        }
        displayInorder(root.l);
        System.out.print(root.val+" ");
        displayInorder(root.r);
    }

    static int maxHeightOrDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = maxHeightOrDepth(root.l);
        int rightHeight=maxHeightOrDepth(root.r);
        return 1+Math.max(leftHeight, rightHeight);
    }

    static int DiameterOfTree(TreeNode root,int maximum){
        if(root==null){
            return 0;
        }
        int leftHeight = DiameterOfTree(root.l,maximum);
        int rightHeight=DiameterOfTree(root.r,maximum);
        maximum=Math.max(maximum,leftHeight+rightHeight);
        return 1+Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("\nenter your choice 1.insert 2.display 3.HeightOrMaxDepthOfTree 4.DiameterOfTree 5.Exit  ");
            int ch=sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter the no of nodes:");
                    int k=sc.nextInt();
                    int nodes[]=new int[k];
                    for(int i=0;i<k;i++){
                       nodes[i]=sc.nextInt();
                    }
                    for(int x:nodes){
                        root=insertNode(root, x);
                    }
                    break;
                case 2:
                    displayInorder(root);
                    break;
                case 3:
                    int Height=maxHeightOrDepth(root);
                    System.out.println("HeightOrDepthOfTree :"+Height);
                    break;
                case 4:
                    int maximum=DiameterOfTree(root, 0);
                    System.out.println("Diameter of tree:"+maximum);
                    break;
                case 5:
                    System.out.println("Exiting....");
                    sc.close();
                    return;
            }
        }
        

    }
}
