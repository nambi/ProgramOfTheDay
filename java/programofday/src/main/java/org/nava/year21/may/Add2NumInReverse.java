package org.nava.year21.may;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Add2NumInReverse {

    /**
     * @param num1 (2 -> 4 - > 3)
     * @param num2 (5 -> 6 ->4)
     * @return 7 -> 0 -> 8 (342+465 = 807 the numbers are in reverse order, sum them and return in reverse order)
     */
    static LinkedList<Integer> sum(LinkedList<Integer> num1, LinkedList<Integer> num2) {
        /**
         * loop both the linked list and keep getting sum from each node
         * add to the result linked list
         */
        int carry = 0;
        int sum = 0;
        int temp = 0;
        LinkedList<Integer> tail1 = num1;
        LinkedList<Integer> tail2 = num2;
        LinkedList<Integer> result = new LinkedList<Integer>();

        while (tail1.peek() != null && tail2.peek() != null) {
            temp = carry + tail1.poll() + tail2.poll();
            if (temp >= 10) {
                carry = temp / 10;
                sum = temp % 10;
            } else {
                sum = temp;
                carry = 0;
            }
            result.addLast(sum);
        }
        //loop through tail1
        sum = 0;
        if (tail1.size() > tail2.size()) {

            while (tail1.peek() != null) {
                temp = carry + tail1.poll();
                if (temp >= 10) {
                    carry = temp / 10;
                    sum = temp % 10;
                } else {
                    sum = temp;
                    carry = 0;
                }
                result.addLast(sum);
            }
        } else {
            //loop through tail2
            while (tail2.peek() != null) {
                temp = carry + tail2.poll();
                if (temp >= 10) {
                    carry = temp / 10;
                    sum = temp % 10;
                } else {
                    sum = temp;
                    carry = 0;
                }
                result.addLast(sum);
            }
        }

        return result;
    }

    static void test1() {

        LinkedList<Integer> num1 = new LinkedList<Integer>();
        num1.addLast(2);
        num1.addLast(4);
        num1.addLast(3);

        LinkedList<Integer> num2 = new LinkedList<Integer>();
        num2.addLast(5);
        num2.addLast(6);
        num2.addLast(4);

        LinkedList<Integer> result = sum(num1, num2);

        if (result.peekFirst() != null && result.peekFirst() == 7) {
            System.out.println("Test1 pass");
        } else {
            System.out.println("Test1 failed");
        }

        LinkedList<Integer> resultTail = result;

        while (resultTail.peek() != null) {
            System.out.println(resultTail.poll());
        }

    }

    public static void main(String[] args) {

        test1();

    }
}
