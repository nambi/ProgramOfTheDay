package org.nava.year21.mar;

import sun.awt.image.ImageWatched;

/**
 * Given the head pointer of a linked sort,
 * sort the linked list in ascending order using merge sort,
 * and return the new head pointer of sorted linked list.
 */
public class SortList {

    static class ListPair {

        LinkedListNode first;
        LinkedListNode second;

        public ListPair(LinkedListNode first, LinkedListNode second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * move fast to end and slow to mid and split them
     *
     * @param head
     * @param pair
     */
    public static void split(LinkedListNode head, ListPair pair) {

        if (head == null) {
            return;
        } else if (head.next == null) {
            pair.first = head;
            pair.second = null;
            return;
        }

        LinkedListNode fast = head.next;
        LinkedListNode slow = head;

        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        pair.first = head;
        pair.second = slow.next;
        slow.next = null;
    }

    /**
     * divide and conquer --> keep dividing the list into 2 halves until we get one element and merge them as 2 sorted lists
     *
     * @param head
     * @return
     */
    public static LinkedListNode sort(LinkedListNode head) {
        // one element condition
        if (head == null || head.next == null) {
            return head;
        }

        ListPair pair = new ListPair(null, null);
        split(head, pair);

        pair.first = sort(pair.first);
        pair.second = sort(pair.second);

        LinkedListNode mergedHead = MergedTwoLists.merge(pair.first, pair.second);
        return mergedHead;
    }

    public static boolean test1() {

        int[] input = {3, 1, 5, 2};
        LinkedListNode head = LinkedList.createLinkedList(input);
        head = sort(head);
        boolean result = (head != null && head.data == 1);
        return result;
    }


    public static boolean test2() {

        int[] input = {3};
        LinkedListNode head = LinkedList.createLinkedList(input);
        head = sort(head);
        boolean result = (head != null && head.data == 3);
        return result;
    }

    public static boolean doTestsPass() {

        return test1() && test2();
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Test failed");
        }
    }
}
