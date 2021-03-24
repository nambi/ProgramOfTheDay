package org.nava.year21.mar;

import java.util.ArrayList;

/**
 * Add Two Integers Represented by Linked Lists
 * Given the head pointers of two linked lists where each linked list represents an integer number (each node is a digit),
 * add them and return the resulting linked list. Here, the first node in a list represents the least significant digit
 */
public class Add2Integers {


    public static LinkedListNode add2Lists(LinkedListNode head1, LinkedListNode head2) {

        LinkedListNode tail1 = head1;
        LinkedListNode tail2 = head2;
        int carry = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (tail1 != null || tail2 != null) {

            carry = getCarry(tail1, tail2, carry, result);

            if (tail1 != null) {
                tail1 = tail1.next;
            }

            if (tail2 != null) {
                tail2 = tail2.next;
            }
        }

        while (carry > 0) {
            //10 --> 1,0
            result.add(carry % 10);
            carry = carry / 10;

        }
        LinkedListNode mergeHead = LinkedList.createLinkedList(result);

        return mergeHead;
    }

    private static int getCarry(LinkedListNode tail1, LinkedListNode tail2, int carry, ArrayList<Integer> result) {
        if (tail1 != null && tail2 != null) {
            carry = getCarry(tail1.data + tail2.data, carry, result);
        } else if (tail1 != null) {
            carry = getCarry(tail1.data, carry, result);
        } else if (tail2 != null) {
            carry = getCarry(tail2.data, carry, result);
        }
        return carry;
    }

    private static int getCarry(int data, int carry, ArrayList<Integer> result) {
        int sum = carry + data;
        if (sum > 9) {
            //10 --> 1,0
            carry = sum / 10;
            sum = sum % 10;
        } else {
            carry = 0;
        }
        result.add(sum);
        return carry;
    }

    public static boolean test2() {

        int[] input1 = {1, 0, 9, 9};
        int[] input2 = {7, 3, 2};


        //output --> 2,8,1,1
        LinkedListNode head1 = LinkedList.createLinkedList(input1);
        LinkedListNode head2 = LinkedList.createLinkedList(input2);

        LinkedListNode head = add2Lists(head1, head2);
        boolean result = (head != null && head.data == 8);

        System.out.println("Test2 result " + result);

        return result;
    }

    public static boolean test1() {

        int[] input1 = {3, 5, 8};
        int[] input2 = {9, 2, 3};


        //output --> 2,8,1,1
        LinkedListNode head1 = LinkedList.createLinkedList(input1);
        LinkedListNode head2 = LinkedList.createLinkedList(input2);

        LinkedListNode head = add2Lists(head1, head2);
        boolean result = (head != null && head.data == 2);

        System.out.println("Test1 result " + result);

        return result;
    }

    public static boolean doTestsPass() {

        return test2();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }

}
