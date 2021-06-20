package org.nava.year21.june;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
public class RangeSumBST {

    static int levelOrderTraversal(TreeNode root, int low, int high) {

        int sum = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            if (r.val >= low && r.val <= high) {
                sum = sum + (r.val);
            }
            if (r.left != null) {
                queue.add(r.left);
            }
            if (r.right != null) {
                queue.add(r.right);
            }
        }

        return sum;
    }

    static boolean test1() {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        int sum = levelOrderTraversal(root, 3, 5);
        //result should be 3+4+5 = 12
        boolean result = (sum == 12);
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
