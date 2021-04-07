package org.nava.year21.apr;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Write an in-order traversal of a binary tree iteratively.
 */
public class BTreeInorderTraversal {


    static String iterativeInorder(BinaryTreeNode root) {
        String output = "";
        Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
        while (!stk.empty() || root != null) {
            if (root != null) {
                stk.push(root);
                root = root.left;
                continue;
            }
            output += stk.peek().data + " ";
            System.out.println(stk.peek().data + " ");
            root = stk.pop().right;
        }

        return output;
    }

    public static boolean test1() {

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(50);
        list.add(75);
        list.add(35);
        list.add(25);
        BinaryTreeNode root = BinaryTree.createBST(list);
        String output = iterativeInorder(root);

        boolean result = (output != null && output.trim().equalsIgnoreCase("25 35 50 75 100 200"));
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
