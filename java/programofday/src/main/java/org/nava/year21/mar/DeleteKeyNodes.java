package org.nava.year21.mar;

import java.util.Arrays;

/**
 * Given the head of a linked list and a key, delete the node with this given key from the linked list.
 */
public class DeleteKeyNodes {


    public static LinkedListNode deleteKeyNodes(LinkedListNode head, int key) {
        LinkedListNode tail = head;
        if (tail != null) {
            while (tail != null && tail.next != null) {
                LinkedListNode node = tail.next;
                if (key != node.data) {
                    tail = tail.next;
                } else {
                    tail.next = tail.next.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] arr) {
        int[] input = {4, 7, 8, 1, 3, 3, 2};
        LinkedListNode head = LinkedList.createLinkedList(input);
        System.out.println("Print the list for :" + Arrays.toString(input));
        LinkedList.display(head);
        head = deleteKeyNodes(head, 3);
        System.out.println("Print the list after dedupe :");
        LinkedList.display(head);

    }
}
