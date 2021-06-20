package org.nava.year21.june;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeLevelOrderTraversal {

    static List<Integer> levelOrderTraversal(TreeNode root) {

        List<Integer> levelOrder = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            levelOrder.add(r.val);
            if (r.left != null) {
                queue.add(r.left);
            }
            if (r.right != null) {
                queue.add(r.right);
            }
        }

        return levelOrder;
    }

    static boolean test1() {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        List<Integer> bfs = levelOrderTraversal(root);
        //result should be 1,2,3,4,5
        boolean result = (bfs != null && bfs.get(2) == 3);
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
