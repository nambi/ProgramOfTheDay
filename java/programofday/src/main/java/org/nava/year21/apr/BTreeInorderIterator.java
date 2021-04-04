package org.nava.year21.apr;

import java.util.ArrayList;
import java.util.Iterator;
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

    BinaryTreeNode currentRoot;

    List<BinaryTreeNode> _list = new ArrayList<>();

    Iterator<BinaryTreeNode> _listItr;

    public BTreeInorderIterator(BinaryTreeNode root) {
        this.root = root;
        populateList();
        _listItr = _list.listIterator();

    }

    private void populateList() {
        //create a list with all left first from bottom and all right from the root
        // _list
        buildList(this.root, _list);
    }

    private static BinaryTreeNode buildList(BinaryTreeNode root, List<BinaryTreeNode> list) {

        if (root == null) {
            return null;
        }

        list.add(root);

        BinaryTreeNode left = buildList(root.left, list);
        BinaryTreeNode right = buildList(root.right, list);

        return root;
    }

    public boolean hasNext() {

        return _listItr.hasNext();
    }

    public BinaryTreeNode getNext() {

        return _listItr.next();
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
