package Trees;

import java.util.Scanner;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int k){
        this.data=k;
        left=right=null;
    }
}


public class p2 {

    static TreeNode root = null;
    static TreeNode InsertNode(TreeNode root,int v){
        if(root==null){
            return new TreeNode(v);
        }
        if(root.data < v) root.right=InsertNode(root, v);
        else if(root.data>v) root.left=InsertNode(root, v);
        return root;
    }
    static void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
     static void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
     static void postorder(TreeNode root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String[] args) {
        
        int ch;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the choice\n1.Insert the TreeNode\n2.Inorder Display\n3.preOrder Display\n4.PostOrder Display\n5.DFS Display\n6.BFS Display\n7.Delete TreeNode");
        ch=sc.nextInt();
        while(true){
        System.out.println("enter the choice\n1.Insert the TreeNode\n2.Inorder Display\n3.preOrder Display\n4.PostOrder Display\n5.DFS Display\n6.BFS Display\n7.Delete TreeNode");
        switch(ch){
            case 1:
                System.out.println("enter the value of TreeNode to insert:");
                int val= sc.nextInt();
                root=InsertNode(root,val);
                break;
            case 2:
                System.out.print("\nInorder:");
                inorder(root);
                break;
            case 3:
                System.out.print("\npreorder:");
                preorder(root);
                break;
            case 4:
                System.out.print("\npostorder:");
                postorder(root);
                break;
            case 5:
                sc.close();
                break;
            case 6:
                break;
            case 7:
                break;
        }
    }   
       
    }
     
}
