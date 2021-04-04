package org.nava.year21.apr;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the roots of two binary trees, determine if these trees are identical or not.
 * Identical trees have the same layout and data at each node
 */
public class BTreeIdenticalCheck {

    public static boolean areIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            return ((root1.data == root2.data) &&
                areIdentical(root1.left, root2.left) &&
                areIdentical(root1.right, root2.right));
        }

        return false;
    }

    public static boolean isIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }

        List<Integer> list1 = BinaryTree.bst_to_arraylist(root1);
        List<Integer> list2 = BinaryTree.bst_to_arraylist(root2);

        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {

            int node1 = list1.get(i);
            int node2 = list2.get(i);

            if (node1 != node2) {
                return false;
            }

        }
        return true;
    }

    public static boolean test1() {

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(0);
        list1.add(1);

        BinaryTreeNode root1 = BinaryTree.createBST(list1);
        BinaryTreeNode root2 = BinaryTree.createBST(list1);
        boolean result = (isIdentical(root1, root2) == true);
        System.out.println("test1 result " + result);
        return result;
    }

    public static boolean doTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All Tests passed");
        } else {
            System.out.println("Tests failed");
        }
    }
}
