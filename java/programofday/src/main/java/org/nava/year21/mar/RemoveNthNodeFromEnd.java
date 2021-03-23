package org.nava.year21.mar;

import java.util.ArrayList;

public class RemoveNthNodeFromEnd {

    public static LinkedListNode removeNthNode(LinkedListNode head, int nodeIndex) {

        if (head == null || nodeIndex < 1) {
            return head;
        }

        LinkedListNode tail = head;
        ArrayList<LinkedListNode> nodeList = new ArrayList<>();
        while (tail.next != null) {
            nodeList.add(tail);
            tail = tail.next;
        }
        nodeList.add(tail);

        int indexToRemove = nodeList.size() - nodeIndex;

        if (indexToRemove == 0) {
           head = head.next;
        }

        if ((indexToRemove - 1) > -1) {
            LinkedListNode prev = nodeList.get(indexToRemove - 1);
            prev.next = prev.next.next;
        }

        return head;
    }

    public static boolean test4() {
        int[] input = {3};
        int nthNode = 1;

        LinkedListNode head = LinkedList.createLinkedList(input);

        head = removeNthNode(head, nthNode);
        //Invalid input; No node is removed
        boolean result = (head == null);
        System.out.println("Test 4 result " + result);
        return result;
    }

    public static boolean test3() {
        int[] input = {};
        int nthNode = -1;

        LinkedListNode head = LinkedList.createLinkedList(input);

        head = removeNthNode(head, nthNode);
        //Invalid input; No node is removed
        boolean result = (head == null);
        System.out.println("Test 3 result " + result);
        return result;
    }

    public static boolean test2() {
        int[] input = {3};
        int nthNode = 5;

        LinkedListNode head = LinkedList.createLinkedList(input);

        head = removeNthNode(head, nthNode);
        //Invalid input; No node is removed
        boolean result = (head != null && head.data == 3);
        System.out.println("Test 2 result " + result);
        return result;
    }

    public static boolean test1() {

        int[] input = {3, 4, 5, 1, 2};
        int nthNode = 5;

        LinkedListNode head = LinkedList.createLinkedList(input);

        head = removeNthNode(head, nthNode);
        boolean result = (head != null && head.data == 4);
        System.out.println("Test 1 result " + result);
        return result;
    }

    public static boolean doTestsPass() {

        return test4() && test1() && test2() && test3();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }
}
