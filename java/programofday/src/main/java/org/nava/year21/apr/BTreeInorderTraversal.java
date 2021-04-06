package org.nava.year21.apr;

import java.util.Stack;

/**
 * Write an in-order traversal of a binary tree iteratively.
 */
public class BTreeInorderTraversal {

    private static Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();

    public static void populateIterator(BinaryTreeNode root) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    public static void getInOrder(BinaryTreeNode root) {
        if (stk.isEmpty())
            return;

        BinaryTreeNode rVal = stk.pop();
        BinaryTreeNode temp = rVal.right;
        populateIterator(temp);
    }

    public static boolean test1() {

        boolean result = (stk != null);
        System.out.println("Test1 result " + result);
        return result;
    }

    public static boolean doTestsPass() {
        return test1();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
