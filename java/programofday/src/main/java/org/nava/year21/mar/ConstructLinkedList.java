package org.nava.year21.mar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Construct a simple linked list with integers with basic operations of adding at head,tail and display
 */
public class ConstructLinkedList {

    public static void main(String[] args) {
        int[] input = {4, 7, 8, 1, 3, 2};
        LinkedListNode head = LinkedList.createLinkedList(input);
        System.out.println("Print the list for :" + Arrays.toString(input));
        LinkedList.display(head);

        System.out.println("Print the list for after adding 5 at the head");
        head = LinkedList.insertAtHead(head, 5);
        LinkedList.display(head);

        System.out.println("Print the list for after adding 9 at the tail");
        head = LinkedList.insertAtTail(head, 9);
        LinkedList.display(head);
    }
}

class LinkedList {

    public static LinkedListNode insertAtHead(LinkedListNode head, int data) {
        LinkedListNode node = new LinkedListNode(data);

        if (head != null) {
            LinkedListNode temp = head;
            head = node;
            head.next = temp;
        }
        return node;
    }

    public static LinkedListNode insertAtTail(LinkedListNode head, int data) {
        LinkedListNode node = new LinkedListNode(data);
        LinkedListNode tail = head;
        if (tail != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }

        return head;
    }

    public static LinkedListNode createLinkedList(int[] arr) {
        LinkedListNode head = null;
        LinkedListNode tail = null;

        for (int a : arr) {
            LinkedListNode node = new LinkedListNode(a);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }

        return head;
    }
    public static LinkedListNode createLinkedList(ArrayList<Integer> arr) {
        LinkedListNode head = null;
        LinkedListNode tail = null;

        for (int a : arr) {
            LinkedListNode node = new LinkedListNode(a);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }

        return head;
    }
    public static void display(LinkedListNode head) {
        LinkedListNode tail = head;
        if (tail != null) {
            int count = 0;
            while (tail.next != null) {
                LinkedListNode node = tail;
                System.out.println("Node " + count + " value " + node.data);
                tail = tail.next;
                count++;
            }
            System.out.println("Node " + count + " value " + tail.data);
        }
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }
}
