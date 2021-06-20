package org.nava.year21.june;


import java.util.Stack;

/**
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
 */
public class ClosestValueBST {

    static int levelOrderTraversal(TreeNode root, double target) {
        //DFS is better as we can quickly decide on the range
        int closestValue = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode r = stack.pop();
            if (target == r.val) {
                return r.val;
            }
            if (target > r.val) {
                if (r.right != null) {
                    stack.add(r.right);
                }
                closestValue = r.val;
            } else {
                if (r.left != null) {
                    stack.add(r.left);
                }
                closestValue = r.val;
            }
        }

        return closestValue;
    }

    static boolean test1() {

        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)), new TreeNode(5, null, null));
        int sum = levelOrderTraversal(root, 3.25);
        //result should be 4
        boolean result = (sum == 3);
        System.out.println("test1 result " + result);
        return result;
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
