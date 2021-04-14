package com.solutions.binarytree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Node root;

    private Node addEle(Node n, int val) {
        if (n == null) {
            return new Node(val);
        } else if (val == n.value) {
            return n;
        } else if (val < n.value) {
            n.left = addEle(n, val);
        } else {
            n.right = addEle(n, val);
        }
        return n;
    }

    public void add(int val) {
        root = addEle(root, val);
    }

    public boolean find(int val) {
        return findEle(root, val);
    }

    private boolean findEle(Node n, int val) {
        if (n == null) {
            return false;
        }

        if (val == n.value) {
            return true;
        }

        return (val < n.value) ? findEle(n.left, val) :
                findEle(n.right, val);
    }
    public int count =0;
    public Node traverseInorder(Node n, int k) {

        if(n==null){
            return null ;
        }
        Node left =  traverseInorder(n.left,k);
        if(left!=null)
            return left;
        count++;
        if(k==count){
            System.out.println(" in k " + n.value + " ");
            return n;
        }
       // System.out.println(" " + n.value + " ");



         return   traverseInorder(n.right,k);

    }

    public void traveresePreorder(Node n) {
         Node temp= n;
         Node right=null;
        Stack<Node> lst = new Stack<Node>();
        Stack<Node> lstR = new Stack<Node>();
        lst.add(temp);
        if(temp.right!=null){
            lstR.add(temp.right);
        }
        while (!lst.isEmpty()|| !lstR.isEmpty()) {
           // temp=lst.firstElement();
            if(!lst.isEmpty()) {
                temp = lst.pop();
            }
                System.out.println(" " + temp.value + " ");

                if (temp.right != null) {
                    lstR.add(temp.right);
                }
                if (temp.left != null) {

                    lst.push(temp.left);
                }else if(!lstR.isEmpty()) {
                    temp = lstR.pop();
                }
            }

    }

    public int height(Node n) {

        if (n == null) {
            return -1;
        } else {
            int l_ht = height(n.left);
            int r_ht = height(n.right);
            if (l_ht > r_ht) {
                return l_ht + 1;
            } else {
                return r_ht + 1;
            }

        }

    }

}





//Tree node
class Node{
    int value;
    Node right;
    Node left;
    Node(int val){
        this.value = val;
        left=null;
        right=null;
    }


}


