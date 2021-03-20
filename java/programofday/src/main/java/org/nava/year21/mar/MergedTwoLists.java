package org.nava.year21.mar;

/**
 * Given two sorted linked lists, merge them so that the resulting linked list is also sorted.
 */
public class MergedTwoLists {


    public static LinkedListNode merge(LinkedListNode head1, LinkedListNode head2) {

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        LinkedListNode tail1 = head1;
        LinkedListNode tail2 = head2;

        LinkedListNode mergeHead = tail1;

        if (tail1.data > tail2.data) {
            mergeHead = tail2;
            tail2 = tail2.next;
        } else {
            tail1 = tail1.next;
        }
        LinkedListNode mergeTail = mergeHead;


        while ((tail1 != null && tail1.next != null) || (tail2 != null && tail2.next != null)) {

            if (tail1 == null) {
                mergeTail.next = tail2;
                break;
            }

            if (tail2 == null) {
                mergeTail.next = tail1;
                break;
            }

            if (tail1.data > tail2.data) {
                mergeTail.next = tail2;
                tail2 = tail2.next;
            } else {
                mergeTail.next = tail1;
                tail1 = tail1.next;

            }

            mergeTail = mergeTail.next;

        }

        if (tail1 == null) {
            mergeTail.next = tail2;
        } else if (tail2 == null) {
            mergeTail.next = tail1;
        } else if (tail1.data > tail2.data) {
            mergeTail.next = tail2;
        } else {
            mergeTail.next = tail1;
        }


        return mergeHead;
    }

    public static boolean test2() {

        int[] list1 = {4, 8, 15, 19, 22};
        int[] list2 = {7, 9, 10, 16};

        LinkedListNode head1 = LinkedList.createLinkedList(list1);
        LinkedListNode head2 = LinkedList.createLinkedList(list2);

        LinkedListNode mergeHead = merge(head1, head2);

        return mergeHead != null && mergeHead.data == 1;

    }

    public static boolean test1() {

        int[] list1 = {1, 4, 6};
        int[] list2 = {2, 5, 7};

        LinkedListNode head1 = LinkedList.createLinkedList(list1);
        LinkedListNode head2 = LinkedList.createLinkedList(list2);

        LinkedListNode mergeHead = merge(head1, head2);

        return mergeHead != null && mergeHead.data == 1;
    }

    public static boolean doTestsPass() {


        return test2();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Test failed");
        }
    }
}
