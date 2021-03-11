package org.nava.year21.mar;

import java.util.*;

public class DedupeLinkedList {

    public static LinkedListNode dedupe(LinkedListNode head) {
        Set<Integer> uniqueValue = new HashSet<>();
        LinkedListNode tail = head;
        uniqueValue.add(tail.data);
        if (tail != null) {
            while (tail != null && tail.next != null) {
                LinkedListNode node = tail.next;
                if (!uniqueValue.contains(node.data)) {
                    uniqueValue.add(node.data);
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
        head = dedupe(head);
        System.out.println("Print the list after dedupe :");
        LinkedList.display(head);

    }
}
