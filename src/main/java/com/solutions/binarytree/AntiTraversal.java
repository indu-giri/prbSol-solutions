package com.solutions.binarytree;

import java.util.*;
import java.util.function.Consumer;

public class AntiTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.left.left.left = new Node(10);
        root.left.left.right = new Node(11);
        root.right.right.left = new Node(8);

       // antiClockWiseSpiral(root);
        BinaryTree tr = new BinaryTree();
        Node n = tr.traverseInorder(root,5);
        System.out.println("opt:" +n.value);
        System.out.println("PreOrder");
        tr.traveresePreorder(root);

      //  List<Integer> result = new ArrayList<>(Arrays.asList(1,2,3,4,5));
     //   Collections.reverse(result);

   //     result.stream().forEach(new Consumer<Integer>() {
   //         @Override
   //         public void accept(Integer integer) {
 //               System.out.println(integer.toString());
 //          }
 //       });
       // result.stream().filter(x->result.equals(x))


    }

    public static void antiClockWiseSpiral(Node n) {
        BinaryTree t = new BinaryTree();
        int i = 0;
        int j = t.height(n);
        System.out.println(j);
        boolean flag = false;
        List<List<Integer>> result = traversebfs(n);
        while (i < j) {
            Collections.reverse(result.get(i));
            System.out.println(result.get(i));
            i++;
            System.out.println(result.get(j));
            j--;

        }


    }


    private static List<List<Integer>> traversebfs(Node n) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> qu = new LinkedList<>();
        if (n == null) {
            return result;
        }
        qu.add(n);
        while (!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> val = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = qu.remove();
                val.add(temp.value);
                if (temp.left != null) {
                    qu.add(temp.left);
                }
                if (temp.right != null) {
                    qu.add(temp.right);
                }
            }
            result.add(val);
        }
        return result;
    }


}


