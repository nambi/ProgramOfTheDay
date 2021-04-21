package org.nava.year21.apr;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    void enqueue(int data) {
        stack1.push(data);
    }

    boolean isEmpty() {
        return stack1.size() + stack2.size() == 0;
    }

    int dequeue() {
        if (isEmpty()) {
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static boolean test1() {
        QueueUsingStack sq = new QueueUsingStack();
        sq.enqueue(1);
        sq.enqueue(2);
        int data = sq.dequeue();
        return (data == 1);
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
