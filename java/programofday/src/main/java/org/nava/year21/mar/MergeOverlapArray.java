package org.nava.year21.mar;

import java.util.ArrayList;

/*
Merge overlapping intervals in an array of interval pairs.

You are given an array (list) of interval pairs as input where each interval has a start and end timestamp.
The input array is sorted by starting timestamps. You are required to merge overlapping intervals and return a new output array.

Consider the input array below.
Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping so they should be merged to one big interval (1, 8).
Similarly, intervals (10, 12) and (12, 15) are also overlapping and should be merged to (10, 15).

 */
public class MergeOverlapArray {

    static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
        ArrayList<Pair> result = new ArrayList<>();

        if (v == null || v.size() < 1) {
            return result;
        }

        //loop through the list
        //compare second left to first right, if its less - Break - arrays are not overlapping
        //else - keep the left, but update the right if its more than the first right
        Pair prev = v.get(0);
        if (v.size() > 1) {
            for (int i = 1; i < v.size(); i++) {
                Pair next = v.get(i);
                if (next.first < prev.second) {
                    if (next.second > prev.second) {
                        prev.second = next.second;
                    }
                } else {
                    result.add(prev);
                    prev = next;
                    continue;
                }
            }
        }
        result.add(prev);

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Pair> v = new ArrayList<Pair>();

        v.add(new Pair(1, 5));
        v.add(new Pair(3, 7));
        v.add(new Pair(4, 6));
        v.add(new Pair(6, 8));
        v.add(new Pair(10, 12));
        v.add(new Pair(11, 15));

        ArrayList<Pair> result = mergeIntervals(v);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
        }
    }
}


class Pair {
    public int first;
    public int second;

    public Pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
}
