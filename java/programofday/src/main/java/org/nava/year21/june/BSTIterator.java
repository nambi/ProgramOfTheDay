package org.nava.year21.june;

import java.util.*;

public class BSTIterator {

    private TreeNode root;
    private LinkedList<Integer> bstList = new LinkedList<Integer>();
    private int currentVal = Integer.MIN_VALUE;

    public BSTIterator(TreeNode root) {
        this.root = root;
        traverseInOrder(this.root);
    }

    private void traverseInOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        traverseInOrder(root.left);
        bstList.add(root.val);
        traverseInOrder(root.right);
    }

    public int next() {
        currentVal = bstList.pop();
        return currentVal;
    }

    public boolean hasNext() {

        return bstList.iterator().hasNext();
    }


    static boolean test1() {

        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)), new TreeNode(5, null, null));
        BSTIterator bst = new BSTIterator(root);

        System.out.println("test1 result " + bst.next());
        System.out.println("test1 result " + bst.next());
        System.out.println("test1 result " + bst.next());
        System.out.println("test1 result " + bst.next());
        System.out.println("test1 result " + bst.next());
        boolean result = false;
        System.out.println("test1 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
