package org.nava.year21.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReverseSinglyLinkedList {

    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        if (head != null) {
            while (head.next != null) {
                LinkedListNode currentHead = head;
                head = head.next;
                if (prev == null) {
                    prev = currentHead;
                    prev.next = null;
                } else {
                    currentHead.next = prev;
                    prev = currentHead;
                }
            }
            head.next = prev;
        }

        return head;
    }

    public static LinkedListNode reverse(LinkedListNode head, int size) {

        //convert the list to array in reverse order
        //construct new list with the array

        int[] reversedList = new int[size];
        LinkedListNode tail = head;
        if (tail != null) {
            int reverseCount = size - 1;
            int count = 0;
            while (tail.next != null) {
                LinkedListNode node = tail;
                System.out.println("Node " + count + " value " + node.data);
                reversedList[reverseCount] = node.data;
                tail = tail.next;
                count++;
                reverseCount--;
            }
            System.out.println("Node " + count + " value " + tail.data);
            reversedList[reverseCount] = tail.data;
        }

        head = LinkedList.createLinkedList(reversedList);
        return head;
    }


    public static void main(String[] args) {

        int[] input = {4, 7, 8, 1, 3, 2};
        LinkedListNode head = LinkedList.createLinkedList(input);
        System.out.println("Print the list for :" + Arrays.toString(input));
        LinkedList.display(head);
        head = reverse(head, input.length);
        System.out.println("Print the list after reverse :" + Arrays.toString(input));
        LinkedList.display(head);

        head = reverse(head);
        System.out.println("Print the list after reverse :" + Arrays.toString(input));
        LinkedList.display(head);

    }

}


