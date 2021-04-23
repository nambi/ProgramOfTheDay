package org.nava.year21.apr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given the root node of a directed graph,
 * clone this graph by creating its deep copy so that the cloned graph has the same vertices and edges as the original graph.
 * <p>
 * Let’s look at the below graphs as an example. If the input graph is
 * G=(V,E) where V is set of vertices and
 * E is set of edges, then the output graph (cloned graph)
 * <p>
 * G′=(V′,E′) such that V=V′  and E=E′
 */
public class CloneDirectedGraph {

    private static Node clone_rec(
        Node root,
        HashMap<Node, Node> nodes_completed) {
        if (root == null) {
            return null;
        }

        Node pNew = new Node(root.data);
        nodes_completed.put(root, pNew);

        for (Node p : root.neighbors) {
            Node x = nodes_completed.get(p);
            if (x == null) {
                pNew.neighbors.add(clone_rec(p, nodes_completed));
            } else {
                pNew.neighbors.add(x);
            }
        }
        return pNew;
    }

    public static Node clone(Node root) {
        HashMap<Node, Node> nodes_completed =
            new HashMap<Node, Node>();

        return clone_rec(root, nodes_completed);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(null);
        ArrayList<Node> vertices = null;//get

        Graph.printGraph(graph);

        Node cp = clone(vertices.get(0));
        System.out.println();
        System.out.println("After copy.");
        Graph.printGraph(null); // cp
    }
}

class Node {
    public int data;
    public List<Node> neighbors = new ArrayList<Node>();

    public Node(int d) {
        data = d;
    }
}
