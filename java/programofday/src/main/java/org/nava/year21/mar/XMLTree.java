package org.nava.year21.mar;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Convert an XML string to an n-ary tree.
 * We don’t need to handle XML attributes in this problem
 */
public class XMLTree {

    static class TreeNode {
        public int data;
        public String text;
        public ArrayList<TreeNode> Children = new ArrayList<TreeNode>();

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(String text) {
            this.text = text;
        }

        public static void display_level_order(TreeNode root) {
            if (root == null)
                return;

            ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.addLast(root);
            TreeNode tempNode = new TreeNode(100);
            queue.addLast(tempNode);

            while (!queue.isEmpty()) {
                TreeNode temp = queue.removeFirst();

                if (temp == tempNode) {
                    System.out.println();
                    if (!queue.isEmpty()) {
                        queue.addLast(tempNode);
                        continue;
                    } else {
                        return;
                    }

                }

                System.out.print(temp.data + ", ");

                for (int i = 0; i < temp.Children.size(); i++) {
                    queue.addLast(temp.Children.get(i));
                }
            }
            System.out.println();
        }
    }

    public static TreeNode createXmlTree(String xml) throws XMLStreamException {
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(is);
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode last = null;
        while (reader.hasNext()) {
            if (reader.getEventType() == XMLStreamConstants.START_DOCUMENT ||
                reader.getEventType() == XMLStreamConstants.SPACE ||
                reader.getEventType() == XMLStreamConstants.END_DOCUMENT) {
                reader.next();
                continue;
            } else if (reader.getEventType() == XMLStreamConstants.END_ELEMENT) {
                if (!stack.empty()) {
                    last = stack.pop();
                }
                reader.next();
                continue;
            }

            if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                TreeNode node = new TreeNode(reader.getLocalName());

                if (!stack.empty()) {
                    stack.peek().Children.add(node);
                }

                stack.push(node);
            } else if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                TreeNode node = new TreeNode(reader.getText());

                if (!stack.empty()) {
                    stack.peek().Children.add(node);
                }
            }

            reader.next();
        }
        return last;
    }

    public static void print_tree(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < depth; ++i) System.out.print("\t");
        System.out.print(root.text + "\n");
        for (TreeNode child : root.Children) {
            print_tree(child, depth + 1);
        }
    }


    public static boolean test1() {

        String input = "<html><body><div><h1>CodeRust</h1><a>http://test.com</a></div><div><h2>Chapter 1</h2></div></body></html>";

        TreeNode output = null;
        try {
            output = createXmlTree(input);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        print_tree(output, 0);
        boolean result = (output != null);

        return result;
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
