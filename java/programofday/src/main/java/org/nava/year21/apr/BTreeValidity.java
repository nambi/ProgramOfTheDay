package org.nava.year21.apr;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, figure out whether it's a BST.
 */
public class BTreeValidity {

    public static boolean isValid(BinaryTreeNode root) {
        /**
         * At all levels L<N<R
         */
        BinaryTreeNode left = root;
        while (left != null) {
            int n = left.data;

            if (left.right != null && n > left.right.data) {
                return false;
            }
            if (left.right != null && n < left.left.data) {
                return false;
            }
            left = left.left;
        }
        BinaryTreeNode right = root;
        while (right != null) {
            int n = right.data;

            if (right.right != null && n > right.right.data) {
                return false;
            }
            if (right.right != null && n < right.left.data) {
                return false;
            }
            right = right.right;
        }
        return true;
    }

    private static boolean isBstRec(BinaryTreeNode root, int min_value, int max_value) {

        if (root == null) {
            return true;
        }

        if (root.data < min_value || root.data > max_value) {
            return false;
        }

        return isBstRec(root.left, min_value, root.data) &&
            isBstRec(root.right, root.data, max_value);
    }

    public static boolean isBst(BinaryTreeNode root) {
        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean test2() {

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(50);
        list.add(75);
        list.add(35);
        list.add(25);
        BinaryTreeNode root = BinaryTree.createBST(list);
        boolean output = isBst(root);

        boolean result = (output);
        System.out.println("Test2 result " + result);
        return result;
    }

    public static boolean test1() {

        BinaryTreeNode root = new BinaryTreeNode(100);
        BinaryTree.insert(root, 50);
        BinaryTree.insert(root, 200);
        BinaryTree.insert(root, 25);
        // Add a node at an incorrect position
        BinaryTree.insert(root, 125);
        BinaryTree.insert(root, 150);
        BinaryTree.insert(root, 300);
        boolean output = isValid(root);

        boolean result = (output);
        System.out.println("Test1 result " + result);
        return result;
    }

    public static boolean doTestsPass() {
        return test1() && test2();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }
}
