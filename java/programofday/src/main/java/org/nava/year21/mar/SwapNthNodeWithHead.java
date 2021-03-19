package org.nava.year21.mar;

/**
 * Given the head of a singly linked list and 'N', swap the head with the Nth node. Return the head of the new linked list.
 */
public class SwapNthNodeWithHead {


    public static LinkedListNode swapNthNode(LinkedListNode head, int n) {

        if (head == null || head.next == null || n < 2) {
            return head;
        }

        LinkedListNode tail = head;
        int count = 1;
        while (tail.next != null) {

            if (count == n) {
                int data = tail.data;
                tail.data = head.data;
                head.data = data;
                break;
            }
            tail = tail.next;
            count++;
        }

        return head;
    }


    public static boolean test1() {

        int[] nodes = {3, 4, 1, 5};
        LinkedListNode head = LinkedList.createLinkedList(nodes);
        LinkedListNode newHead = swapNthNode(head, 2);

        return newHead != null && newHead.data == 4;
    }

    public static boolean doTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Test failed");
        }

    }
}
