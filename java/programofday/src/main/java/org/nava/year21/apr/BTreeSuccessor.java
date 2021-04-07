package org.nava.year21.apr;

import java.util.ArrayList;
import java.util.List;

/**
 * The in-order successor of a node in a binary Search Tree (BST) is the next node in in-order traversal.
 */
public class BTreeSuccessor {

    public static BinaryTreeNode findMin(BinaryTreeNode root) {
        if (root == null) {
            return root;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static BinaryTreeNode inorderSuccessorBST(BinaryTreeNode root, int d) {

        if (root == null) {
            return null;
        }


        BinaryTreeNode successor = null;

        while (root != null) {

            if (root.data < d) {
                root = root.right;
            } else if (root.data > d) {
                successor = root;
                root = root.left;
            } else {
                if (root.right != null) {
                    successor = findMin(root.right);
                }
                break;
            }
        }
        return successor;
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
        BinaryTreeNode output = inorderSuccessorBST(root, 100);

        boolean result = (output != null && output.data == 200);
        System.out.println("Test1 result " + result);

        output = inorderSuccessorBST(root, 25);

        result = (output != null && output.data == 35);
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
