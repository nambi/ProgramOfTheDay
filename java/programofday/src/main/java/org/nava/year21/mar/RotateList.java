package org.nava.year21.mar;

public class RotateList {


    public static LinkedListNode rotate(LinkedListNode head, int rotationNodes) {

        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode tail1 = head;
        LinkedListNode tail2 = null;
        LinkedListNode tail3 = null;

        int count = 0;

        while (tail1.next != null) {

            if (count > (rotationNodes)) {
                if (tail2 == null) {
                    tail2 = tail1;
                } else {
                    tail2.next = tail1;
                }
            } else {
                //only add nodes
                int[] data = {tail1.data};
                LinkedListNode node = LinkedList.createLinkedList(data);
                if (tail3 == null) {
                    tail3 = node;
                } else {
                    tail3.next = node;
                }
            }
            count++;
            tail1 = tail1.next;
        }
//        tail2.next = tail1;
        LinkedListNode tail4 = tail2;
        while (tail4.next != null) {
            tail4 = tail4.next;
        }
        tail4.next = tail3;

        return tail2;
    }

    public static boolean test1() {

        int[] input = {2, 4, 8, 6, 3};
        int rotationNodes = 1;
        LinkedListNode head = LinkedList.createLinkedList(input);
        head = rotate(head, rotationNodes);
        boolean result = (head != null && head.data == 8);
        System.out.println("Test1 Result " + result);
        return result;
    }

    public static boolean doTestsPass() {

        return test1();
    }

    public static void main(String[] args) {


        if (doTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }

}
