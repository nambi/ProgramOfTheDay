package org.nava.year21.mar;

import java.util.Arrays;

/**
 * Given the head nodes of two linked lists that may or may not intersect,
 * find out if they intersect and return the point of intersection. Return null otherwise.
 */
public class IntersectionOf2Lists {


    public static LinkedListNode intersectionOptimized(LinkedListNode head1, LinkedListNode head2) {

        return null;
    }

    public static LinkedListNode intersection(LinkedListNode head1, LinkedListNode head2) {

        LinkedListNode tail1 = head1;

        while (tail1.next != null) {

            LinkedListNode tail2 = head2;

            while (tail2.next != null) {

                if (tail1 == tail2) {
                    return tail2;
                }
                tail2 = tail2.next;
            }

            tail1 = tail1.next;
        }

        return null;
    }


    public static void main(String[] args) {

        int[] input1 = {4, 7, 8, 1, 3, 2};
        LinkedListNode head1 = LinkedList.createLinkedList(input1);
        int[] input2 = {9, 5, 3, 2};
        LinkedListNode head2 = LinkedList.createLinkedList(input2);

        LinkedListNode node1 = new LinkedListNode(12);
        LinkedListNode node2 = new LinkedListNode(27);

        node1.next = node2;
        head1.next = node1;
        head2.next = node1;


        System.out.println("Print the list for 1:" + Arrays.toString(input1));
        LinkedList.display(head1);

        System.out.println("Print the list for 2 :" + Arrays.toString(input2));
        LinkedList.display(head2);

        LinkedListNode match = intersection(head1, head2);
        System.out.println("Match  is :");
        LinkedList.display(match);

    }
}
