package org.nava.year21.apr;

import java.util.ListIterator;

/*
Given a string of arithmetic expression, evaluate its result.
 2+3 = 5
 6+4/2*2=10
 3+2.45/8 = 3.30625
 */
public class EvaluateArithmeticOperation {

    static boolean isDivOrMul(char ch) {
        return ch == '*' || ch == '/';
    }

    static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    static boolean isOperator(char temp) {
        return temp == '+' ||
            temp == '-' ||
            temp == '*' ||
            temp == '/';
    }

    public static Pair<Double, Integer> strToDouble(String s, int i) {
        int len = s.length();
        if (i >= len) {
            return null;
        }

        StringBuilder temp = new StringBuilder();
        while (i < len && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) {
            ++i;
        }

        if (i >= len) {
            return null;
        }

        if (s.charAt(i) == '-') {
            temp.append('-');
            ++i;
        }

        for (; i < len; ++i) {
            char ch = s.charAt(i);
            if (ch != '.' && !isDigit(ch)) {
                break;
            }

            temp.append(ch);
        }

        return new Pair<Double, Integer>(Double.parseDouble(temp.toString()), i);

    }

    /**
     * In this solution, we’ll use a two-pass implementation to evaluate the expression:
     * In the first pass, we’ll handle the ∗ and / operators.
     * In the second pass, we’ll handle the + and  − operators.
     * @param expr
     * @return
     */

    static double evaluate(String expr) {
        java.util.LinkedList<Character> operators = new java.util.LinkedList<Character>();
        java.util.LinkedList<Double> operands = new java.util.LinkedList<Double>();

        char op = 0;
        double prev = 0;

        int i = 0;
        int len = expr.length();
        while (i < len) {
            char ch = expr.charAt(i);
            if (ch == ' ' || ch == '\t') {
                ++i;
                continue;
            }

            if (isOperator(ch)) {
                op = ch;
                operators.add(ch);
                ++i;
            } else {
                Pair<Double, Integer> p = strToDouble(expr, i);

                double d = p.first;
                i = p.second;

                if (isDivOrMul(op)) {
                    operators.removeLast();
                    operands.removeLast();

                    prev = (op == '*') ? (prev * d) : (prev / d);
                    operands.add(prev);
                    op = 0;
                } else {
                    operands.add(d);
                    prev = d;
                }
            }
        }

        double t = 0;
        ListIterator iter = null;

        if (!operands.isEmpty()) {
            t = operands.getFirst();
            iter = operands.listIterator(1);
        }

        for (Character operator : operators) {
            double operand = (Double) iter.next();
            t = operator == '+' ?
                (t + operand) :
                (t - operand);
        }

        return t;
    }

    public static boolean test1() {
        EvaluateArithmeticOperation sq = new EvaluateArithmeticOperation();
        double ans = sq.evaluate("2+5");
        return (ans == 7);
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

class Pair<X, Y> {
    public X first;
    public Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }
}
