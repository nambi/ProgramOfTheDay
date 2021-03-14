package org.nava.year21.mar;

import java.util.Arrays;

/**
 * Given the head pointer of a linked list, sort it in ascending order using insertion sort.
 */
public class SortLinkedList {


    public static LinkedListNode insertionSort(LinkedListNode sorted, LinkedListNode node) {

        if (node == null) {
            return sorted;
        }

        //if the incoming node is less than the sorted, insert at head
        if (sorted == null || sorted.data >= node.data) {
            node.next = sorted;
            return node;
        }

        LinkedListNode curr = sorted;
        //go until the incoming node is greater
        while (curr.next != null && (curr.next.data < node.data)) {
            curr = curr.next;
        }
        //insert at the point of highest order
        node.next = curr.next;
        curr.next = node;
        return sorted;
    }

    public static LinkedListNode sort(LinkedListNode head) {
        LinkedListNode sorted = null;
        LinkedListNode curr = head;

        while (curr != null) {
            LinkedListNode temp = curr.next;
            sorted = insertionSort(sorted, curr);
            curr = temp;
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] input = {4, 7, 8, 1, 3, 2};
        LinkedListNode head = LinkedList.createLinkedList(input);
        System.out.println("Print the list for :" + Arrays.toString(input));
        LinkedList.display(head);

        LinkedListNode sorted = sort(head);
        System.out.println("Print the sorted list for :" + Arrays.toString(input));
        LinkedList.display(sorted);
    }
}
