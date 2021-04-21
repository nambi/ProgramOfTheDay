package org.nava.year21.apr;

import java.util.ArrayDeque;
import java.util.Queue;

class StackUsingQueue {

    Queue<Integer> queue1 = new ArrayDeque<Integer>();
    Queue<Integer> queue2 = new ArrayDeque<Integer>();

    void push(int data) {
        queue1.add(data);
    }

    boolean isEmpty() {
        return queue1.size() + queue2.size() == 0;
    }

    void swap_queues() {
        Queue<Integer> queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        int value = queue1.remove();
        swap_queues();
        return value;
    }

    public static boolean test1() {
        StackUsingQueue sq = new StackUsingQueue();
        sq.push(1);
        sq.push(2);
        int data = sq.pop();
        return (data == 2);
    }

    public static boolean doAllTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
