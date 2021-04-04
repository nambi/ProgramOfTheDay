package org.nava.year21.apr;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a class that implements an in-order iterator on a Binary Tree.
 * <p>
 * We are given the root node of a binary tree.
 * We have to write an iterator that takes in this root and iterates through the nodes of a binary tree in an in-order way.
 * The expectation is to write two critical methods of any iterator: hasNext() and getNext()
 */
public class BTreeInorderIterator {

    BinaryTreeNode root;

    public BTreeInorderIterator(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean hasNext() {
        return false;
    }

    public BinaryTreeNode getNext() {
        return null;
    }

    public static String inorderUsingIterator(BinaryTreeNode root) {
        BTreeInorderIterator iter = new BTreeInorderIterator(root);
        String result = "";
        while (iter.hasNext()) {
            result += iter.getNext().data + " ";
        }
        return result;
    }


    public static boolean test1() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        BinaryTreeNode root = BinaryTree.createBST(list);
        String output = inorderUsingIterator(root);
        boolean result = (output != null && output.startsWith("0"));
        System.out.println("Test1 result " + result);
        return result;
    }

    public static boolean doTestPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doTestPass()) {
            System.out.println("All Tests passed");
        } else {
            System.out.println("Tests failed");
        }

    }

}
