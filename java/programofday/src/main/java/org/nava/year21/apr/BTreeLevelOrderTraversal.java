package org.nava.year21.apr;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, display the node values at each level.
 * Node values for all levels should be displayed on separate lines.
 */
public class BTreeLevelOrderTraversal {

    private static String output = "";

    public static String levelOrderTraversal(BinaryTreeNode root) {

        if (root == null) {
            return "";
        }

        String result = "";

        ArrayList<Queue<BinaryTreeNode>> queues = new ArrayList<Queue<BinaryTreeNode>>();

        queues.add(new ArrayDeque<BinaryTreeNode>());
        queues.add(new ArrayDeque<BinaryTreeNode>());

        Queue<BinaryTreeNode> current_queue = queues.get(0);
        Queue<BinaryTreeNode> next_queue = queues.get(1);

        current_queue.add(root);
        int level_number = 0;

        while (!current_queue.isEmpty()) {
            BinaryTreeNode temp = current_queue.poll();
            System.out.print(temp.data + " ");
            result += String.valueOf(temp.data) + " ";

            if (temp.left != null) {
                next_queue.add(temp.left);
            }

            if (temp.right != null) {
                next_queue.add(temp.right);
            }

            if (current_queue.isEmpty()) {
                System.out.println();
                ++level_number;
                current_queue = queues.get(level_number % 2);
                next_queue = queues.get((level_number + 1) % 2);
            }
        }
        System.out.println();
        return result;

    }

    public static String levelOrderTraversal1(BinaryTreeNode root) {

        while (root != null) {
            getOrder(root);
            output += "\n";
            getOrder(root.left);
            output += "\n";
            getOrder(root.right);
            root = root.left;
        }
        return output;
    }

    public static void getOrder(BinaryTreeNode root) {
        if (root != null) {
            output += "" + root.data;
            if (root.left != null || root.right != null) {
                output += "\n";
                if (root.left != null) {
                    output += " " + root.left.data;
                }
                if (root.right != null) {
                    output += " " + root.right.data;
                }
            }
        }
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
        String output = levelOrderTraversal(root);
        System.out.println("Level Order \n" + output);
        boolean result = (output != null);
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
