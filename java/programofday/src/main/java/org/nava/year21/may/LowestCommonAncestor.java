package org.nava.year21.may;

import org.nava.year21.apr.BinaryTree;
import org.nava.year21.apr.BinaryTreeNode;

public class LowestCommonAncestor {


    static BinaryTreeNode findLowestCommonAncestor(BinaryTreeNode root, int value1, int value2) {

        while (root != null) {

            int value = root.data;

            if (value > value1 && value > value2) {
                root = root.left;
            } else if (value < value1 && value < value2) {
                root = root.right;
            } else {
                return root;
            }

        }
        return root;
    }

    static boolean test1() {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTree tree = new BinaryTree(root);
        BinaryTree.insert(root, 5);
        BinaryTree.insert(root, 20);
        BinaryTree.insert(root, 15);
        BinaryTree.insert(root, 12);
        BinaryTree.anotherDisplayTree(root,1);
        BinaryTreeNode result = findLowestCommonAncestor(root, 15, 12);

        return (result != null && result.data == 15);
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
}
