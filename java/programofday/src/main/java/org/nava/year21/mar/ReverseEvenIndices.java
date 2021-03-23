package org.nava.year21.mar;

/**
 * Reverse Even Nodes in a Linked List
 * <p>
 * Given a singly linked list, reverse the nodes at even indices.
 */
public class ReverseEvenIndices {


    public static LinkedListNode reverse(LinkedListNode head) {

        return null;
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
