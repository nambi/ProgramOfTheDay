package org.nava.year21.may;

import java.util.*;

/**
 * source : A
 * list of edges : A,B ; B,C ;A,C; B,D; C,D; D,E; F,G; G,H, F,H
 * <p>
 * output : shortest path from A to other vertices
 * B - 1
 * C - 1
 * D - 2
 * E - 3
 * F - 0 (no path)
 * G - 0 (no path)
 * H - 0 (no path)
 */

public class SingleSourceShortestPath {


    static Map<String, Integer> findPaths(String source, List<String> edges) {
        //Keep a map of source to other edges with count of steps
        Map<String, Integer> destinationEdgesCount = new HashMap<String, Integer>();
        String[] possibleVertices = {"A","B", "C", "D", "E", "F", "G", "H"};
        for (String k : possibleVertices) {
            destinationEdgesCount.put(k, 0);
        }
        String currentVertix = source;
        int edgeCount = 0;
        for (String vertix : possibleVertices) {
            currentVertix = vertix;
            if(!currentVertix.equals(source)) {
                for (String path : edges) {
                    String[] vertices = path.split(",");

                    if (currentVertix.equals(vertices[1])) {
                        if (source.equals(vertices[0])) {
                            destinationEdgesCount.put(vertices[1], 1);
                            break;
                        }
                        if (destinationEdgesCount.containsKey(vertices[0])) {
                            int count = destinationEdgesCount.get(vertices[0]);
                            if (count > 0) {
                                destinationEdgesCount.put(vertices[1], count + 1);
                            }
                        }
                    }
                }
            }
        }

        for (String key : destinationEdgesCount.keySet()) {
            System.out.println("Key " + key + " Edges " + destinationEdgesCount.get(key));
        }

        return destinationEdgesCount;
    }
    static boolean test2() {

        String source = "B";
        List<String> edges = new ArrayList<String>();
        edges.add("A,B");
        edges.add("B,C");
        edges.add("A,C");
        edges.add("B,D");
        edges.add("C,D");
        edges.add("D,E");
        edges.add("F,G");
        edges.add("G,H");
        edges.add("F,H");

        Map<String, Integer> destinationEdgesCount = findPaths(source, edges);

        boolean result = destinationEdgesCount.get("E") == 2;

        System.out.println("Test 2 result " + result);

        return result;
    }

    static boolean test1() {

        String source = "A";
        List<String> edges = new ArrayList<String>();
        edges.add("A,B");
        edges.add("B,C");
        edges.add("A,C");
        edges.add("B,D");
        edges.add("C,D");
        edges.add("D,E");
        edges.add("F,G");
        edges.add("G,H");
        edges.add("F,H");

        Map<String, Integer> destinationEdgesCount = findPaths(source, edges);

        boolean result = destinationEdgesCount.get("E") == 3;

        System.out.println("Test 1 result " + result);

        return result;
    }


    static boolean doAllTestsPass() {

        return test1() && test2();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests fail");
        }

    }


}
