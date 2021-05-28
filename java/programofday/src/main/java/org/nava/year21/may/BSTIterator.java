package org.nava.year21.may;

import java.util.ArrayList;
import java.util.List;

/**
 * BST In order traversal
 */
public class BSTIterator {

    List<Integer> list = new ArrayList<>();
    int index = 0;

    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }


    static boolean test1() {
        //["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
        //construct tree with [[7, 3, 15, null, null, 9, 20]
        //[null, 3, 7, true, 9, true, 15, true, 20, false]
        TreeNode root = new TreeNode();
        BSTIterator bst = new BSTIterator(root);

        boolean output = false;
        boolean result = (output == true);
        System.out.println("Test1 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
