package org.nava.year21.mar;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list, return the nth from last node. Return null if 'n' is out-of-bounds.
 */
public class NthFromEndOfNode {


    public static LinkedListNode findNodeOptimized(LinkedListNode head, int n) {

        if (head == null || n == 0) {
            return null;
        }

        LinkedListNode tail = head;
        int tailCount = 0;

        while (tail.next != null && tailCount < n) {
            tail = tail.next;
            tailCount++;
        }

        if (tailCount != n) {
            return null;
        }

        while (tail.next != null) {
            head = head.next;
            tail = tail.next;
        }
        head = head.next;

        return head;
    }

    public static LinkedListNode findNode(LinkedListNode head, int n) {

        if (head == null || n == 0) {
            return null;
        }
        List<LinkedListNode> nodes = new ArrayList<>();
        LinkedListNode tail = head;
        int count = 0;
        while (tail.next != null) {
            nodes.add(tail);
            System.out.println("Node " + count + " data " + tail.data);
            tail = tail.next;
            count++;
        }
        nodes.add(tail);
        System.out.println("Node " + count + " data " + tail.data);

        int totalNodes = nodes.size();
        int nthNodeIndex = totalNodes - n;

        if (nthNodeIndex < 0 || nthNodeIndex > (totalNodes - 1)) {
            return null;
        }

        return nodes.get(nthNodeIndex);
    }

    public static boolean test1() {
        int[] list = {3, 4, 5, 1, 8};
        LinkedListNode head = LinkedList.createLinkedList(list);
        LinkedListNode nthNode = findNodeOptimized(head, 2);
        boolean result = (nthNode != null && nthNode.data == 1);
        return result;
    }

    public static boolean test2() {
        int[] list = {3, 4, 5, 1, 8};
        LinkedListNode head = LinkedList.createLinkedList(list);
        LinkedListNode nthNode = findNodeOptimized(head, 7);
        boolean result = (nthNode == null);
        return result;
    }


    public static boolean test3() {
        int[] list = {7, 14, 21, 28, 35, 42};
        LinkedListNode head = LinkedList.createLinkedList(list);
        LinkedListNode nthNode = findNodeOptimized(head, 3);
        boolean result = (nthNode != null && nthNode.data == 28);
        return result;
    }

    public static boolean doTestsPass() {
        return test1() && test2() && test3();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests Failed");
        }

    }
}
