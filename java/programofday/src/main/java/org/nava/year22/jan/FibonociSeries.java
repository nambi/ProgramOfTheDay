package org.nava.year22.jan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Print fibonoci series from given starting number
 */

public class FibonociSeries {


    private static ArrayList<Integer> getFibonoci(int start, int noOfCount) {

        if (noOfCount < 1) {
            System.out.println("Invalid input");
            return null;
        }

        if (start < 1) {
            System.out.println("Invalid input");
            return null;
        }

        Stack<Integer> series = new Stack<Integer>();
        series.add(1);
        fibRec(series, 1,0, noOfCount);
        ArrayList<Integer> fibSeriesTemp = new ArrayList<Integer>();
        fibSeriesTemp.addAll(series);
        ArrayList<Integer> fibSeries = new ArrayList<Integer>();

        for(int s : fibSeriesTemp){
            if(s >= start){
                fibSeries.add(s);
            }
        }
        return fibSeries;
    }

    private static void fibRec(Stack<Integer> series, int start, int prev, int noOfCount) {

        if (series.size() > noOfCount) {
            return;
        }

        int pop = series.peek();

        if (pop == start){
            noOfCount = noOfCount + start;
        }
        int next = pop + prev;
        prev = pop;
        series.add(next);

        fibRec(series, start, prev, noOfCount);
    }

    private static void printFibonoci(ArrayList<Integer> series) {

        if (series != null) {
            for (Integer i : series) {
                System.out.println(i);
            }
        }
    }

    private static boolean test1() {
        System.out.println("------------Executing Test1--------------");
        int start = 1;
        int noOfCount = 8;

        ArrayList<Integer> series = getFibonoci(start, noOfCount);
        printFibonoci(series);

        boolean result = (series != null && series.size() > 1);
        System.out.println("Test1 result " + result);
        return result;
    }

    private static boolean test2() {
        System.out.println("---------Executing Test2----------------");
        int start = 0;
        int noOfCount = 0;

        ArrayList<Integer> series = getFibonoci(start, noOfCount);
        printFibonoci(series);
        boolean result = (series == null);
        System.out.println("Test2 result " + result);
        return result;
    }

    private static boolean test3() {
        System.out.println("---------Executing Test3----------------");
        int start = 2;
        int noOfCount = 5;

        ArrayList<Integer> series = getFibonoci(start, noOfCount);
        printFibonoci(series);
        boolean result = (series != null && series.size() > 1 && series.get(0) == 2);
        System.out.println("Test3 result " + result);
        return result;
    }

    private static boolean doAllTestsPass() {

        return test1() && test2() && test3();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }

}
