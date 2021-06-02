package org.nava.year21.june;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupesOnLL {

    static class Node {
        Node next;
        int data;

        public Node(int d) {
            this.data = d;
        }
    }


    static Node removeDupes(Node head) {
        Node tail1 = head;
        Node prev = tail1;
        Set<Integer> uniqueData = new HashSet<Integer>();
        while (tail1 != null && tail1.next != null) {
            System.out.println("data " + tail1.data);
            if (uniqueData.contains(tail1.data)) {
                prev.next = tail1.next;
                tail1 = prev;
                tail1 = tail1.next;
            } else {
                prev = tail1;
                uniqueData.add(tail1.data);
                tail1 = tail1.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node tail = head;
        for (int i = 0; i < 5; i++) {
            tail.next = new Node(i);
            tail = tail.next;
        }

        Node newHead = removeDupes(head);
        System.out.println("-----------");
        Node tail2 = newHead;
        while (tail2.next != null) {
            System.out.println("data " + tail2.data);
            tail2 = tail2.next;
        }


    }


}
