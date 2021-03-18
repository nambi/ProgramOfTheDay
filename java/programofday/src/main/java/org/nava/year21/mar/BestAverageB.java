package org.nava.year21.mar;

import java.util.HashMap;
import java.util.Map;

/**
 * Get the best average for students with multiple marks
 * List of students and their marks are given in 2D array
 * [["Bobby","87"],["Charles","100"],["Eric","64"],["Charles","22"]] ==> Returns 87
 */
public class BestAverageB {

    public static int getBestAverage(String[][] inputMarks) {

        class MarkSheet {
            public MarkSheet(String name, int totalMarks) {
                this.name = name;
                this.noOfSubjects = 1;
                this.totalMarks = totalMarks;
            }

            public String name;
            public int noOfSubjects;
            public int totalMarks;
        }

        Map<String, MarkSheet> marksMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < inputMarks.length; i++) {

            String name = inputMarks[i][0];
            int marks = Integer.valueOf(inputMarks[i][1]);

            if (!marksMap.containsKey(name)) {
                marksMap.put(name, new MarkSheet(name, marks));
            } else {
                MarkSheet markList = marksMap.get(name);
                markList.noOfSubjects = markList.noOfSubjects + 1;
                markList.totalMarks = markList.totalMarks + marks;
                marksMap.put(name, markList);
            }

        }

        for (MarkSheet ms : marksMap.values()) {
            int avg = ms.totalMarks / ms.noOfSubjects;
            if (avg > max) {
                max = avg;
            }
        }
        return max;
    }

    public static boolean test1() {

        String[][] inputMarks = {{"Bobby", "87"}, {"Charles", "100"}, {"Eric", "64"}, {"Charles", "22"}};

        int bestAverage = getBestAverage(inputMarks);

        boolean result = (bestAverage == 87);
        if (!result) {
            System.out.println("test1 failed");
        }

        return result;
    }

    public static boolean doTestsPass() {

        return test1();

    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All tests pass");
        }
    }
}
