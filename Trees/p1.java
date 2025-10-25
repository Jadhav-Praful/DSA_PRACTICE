package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    Node(int k){
        this.data=k;
    }
}


public class p1 {

    static void LevelOderTraversal(Node root){
        ArrayList<ArrayList<Integer>> levelTrav = new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(root==null){
            return;
        }
        Node curr=root;
        q.add(curr);
        while(!q.isEmpty()){
            int sizeLevel = q.size();
            ArrayList<Integer> al =new ArrayList<>();
            for(int i=0;i<sizeLevel;i++){
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                al.add(q.poll().data);
            }
            levelTrav.add(al);
            
        }
        System.out.println(levelTrav);
    }
   
    static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
     static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
     static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    // static void postorderIterative(Node root) {
    //     if(root==null){
    //         return;
    //     }
    //     Stack<Node> st = new Stack<>();
    //     st.add(root);
    //     while (!st.isEmpty()) {
    //         root=st.pop();
            
    //         if(root.right!=null){
    //            st.add(root.right);
    //         }
    //         if(root.left!=null){
    //            st.add(root.left);
    //         }
    //         System.out.print(root.data+" ");
            
            
    //     }

    // }

    static void preorderIterative(Node root) {
        if(root==null){
            return;
        }
        Stack<Node> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            root=st.pop();
            System.out.print(root.data+" ");
            if(root.right!=null){
               st.add(root.right);
            }
            if(root.left!=null){
               st.add(root.left);
            }
            
            
        }
    }

    // static void inorderIterative(Node root) {
    //     if(root==null){
    //         return;
    //     }
    //     Stack<Node> st = new Stack<>();
    //     st.add(root);
    //     while (!st.isEmpty()) {
    //         root=st.pop();
    //         if(root.right!=null){
    //            st.add(root.right);
    //         }
    //         System.out.print(root.data+" ");
    //         if(root.left!=null){
    //            st.add(root.left);
    //         }
            
            
    //     }
    // }
    public static void main(String[] args) {
        
        Node root = new Node(5);
        root.left=new Node(6);
        root.right=new Node(7);
        root.left.left=new Node(9);
        root.right.left=new Node(18);
        root.left.right=new Node(78);
        root.right.right=new Node(26);

        System.out.print("\nInorder:");
        inorder(root);
        System.out.print("\npreorder:");
        preorder(root);
        System.out.print("\npostorder:");
        postorder(root);
        System.out.print("\nLevelOrder:");
        LevelOderTraversal(root);
        System.out.print("\nInorder Iterative:");
        // inorderIterative(root);
        System.out.print("\npreorder Iterative:");
        preorderIterative(root);
        System.out.print("\npostorder Iterative:");
        // postorderIterative(root);
    }

    
    
}
