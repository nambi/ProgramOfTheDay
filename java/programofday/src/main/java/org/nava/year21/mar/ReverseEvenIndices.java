package org.nava.year21.mar;

import java.util.ArrayList;

/**
 * Reverse Even Nodes in a Linked List
 * <p>
 * Given a singly linked list, reverse the nodes at even indices.
 */
public class ReverseEvenIndices {


    public static LinkedListNode reverse(LinkedListNode head) {

        LinkedListNode tail = head;
        ArrayList<LinkedListNode> nodeList = new ArrayList<>();
        while (tail.next != null) {
            nodeList.add(tail);
            tail = tail.next;
        }
        nodeList.add(tail);
        LinkedListNode prev = null;
        LinkedListNode prevPrev = null;
        for (int i = 0; i < nodeList.size(); i++) {
            if ((i + 1) % 2 == 0) {
                if (prev == null) {
                    prevPrev = nodeList.get(i - 1);
                    prev = nodeList.get(i);
                } else {
                    LinkedListNode current = nodeList.get(i);
                    LinkedListNode oldNext = prev.next;
                    prev.next = current.next;
                    current.next = oldNext;
                    prevPrev.next = current;
                    nodeList.get(i - 1).next = prev;
                    prev = null;
                    prevPrev = null;
                }
            }

        }

        return head;
    }

    public static boolean test1() {

        int[] input = {1, 3, 5, 6, 7};
        LinkedListNode head = LinkedList.createLinkedList(input);
        head = reverse(head);
        // reversed list should be {1,6,5,3,7}
        boolean result = (head != null && head.next.data == 6);
        return result;
    }

    public static boolean doAllTestsPass() {

        return test1();
    }

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }
}
