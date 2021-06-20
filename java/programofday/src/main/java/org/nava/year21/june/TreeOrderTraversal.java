package org.nava.year21.june;

import java.util.ArrayList;
import java.util.List;

public class TreeOrderTraversal {

    static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<Integer>();

        traversePreOrder(root, order);

        return order;
    }

    static void traversePreOrder(TreeNode root, List<Integer> order) {

        if (root == null) {
            return;
        }
        order.add(root.val);
        traversePreOrder(root.left, order);
        traversePreOrder(root.right, order);
    }

    static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<Integer>();

        traverseInOrder(root, order);

        return order;
    }

    static void traverseInOrder(TreeNode root, List<Integer> order) {

        if (root == null) {
            return;
        }
        traverseInOrder(root.left, order);
        order.add(root.val);
        traverseInOrder(root.right, order);
    }

    static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<Integer>();

        traversePostOrder(root, order);

        return order;
    }

    static void traversePostOrder(TreeNode root, List<Integer> order) {

        if (root == null) {
            return;
        }
        traversePostOrder(root.left, order);
        traversePostOrder(root.right, order);
        order.add(root.val);
    }

    static boolean test1() {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        List<Integer> preOrder = preOrderTraversal(root);
        //result should be 1,2,4,5,3
        boolean result = (preOrder != null && preOrder.get(2) == 4);
        System.out.println("test1 result " + result);
        return result;
    }

    static boolean test2() {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        List<Integer> inOrder = inOrderTraversal(root);
        //result should be 4,2,5,1,3
        boolean result = (inOrder != null && inOrder.get(2) == 5);
        System.out.println("test2 result " + result);
        return result;
    }

    static boolean test3() {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        List<Integer> postOrder = postOrderTraversal(root);
        //result should be 4,5,2,3,1
        boolean result = (postOrder != null && postOrder.get(2) == 2);
        System.out.println("test3 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1() && test2() && test3();
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
