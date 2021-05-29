package org.nava.year21.may;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashTableImpl {

    class LinkNod {
        String key;
        String value;

        LinkNod(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<LinkedList<LinkNod>> values = new ArrayList<LinkedList<LinkNod>>();
    private final int INITIAL_SIZE = 5;

    public HashTableImpl() {
        //TODO: can be improved with dynamic size expansion
        int i = 0;
        while (i < INITIAL_SIZE) {
            values.add(new LinkedList<LinkNod>());
            i++;
        }
    }

    int size() {
        return values.size();
    }

    private int hash(String key) {
        return key.length() % INITIAL_SIZE;
    }

    private String getValue(LinkedList<LinkNod> head, String key) {

        Iterator<LinkNod> iterator = head.iterator();
        while (iterator.hasNext()) {
            LinkNod n = iterator.next();
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }

    private String setValue(LinkedList<LinkNod> head, LinkNod node) {
        head.addLast(node);
        return node.value;
    }

    String get(String k) {
        int index = hash(k) % INITIAL_SIZE;

        LinkedList<LinkNod> head = values.get(index);
        return getValue(head, k);
    }

    String put(String k, String v) {
        int index = hash(k) % INITIAL_SIZE;

        LinkedList<LinkNod> head = values.get(index);
        LinkNod node = new LinkNod(k, v);
        return setValue(head, node);
    }

    static boolean test1() {
        HashTableImpl hashTable = new HashTableImpl();
        hashTable.put("key", "nambi");
        hashTable.put("key2", "nambi2");
        boolean result = (hashTable.get("key2").equals("nambi2"));
        System.out.println("test1 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {
        return test1();
    }

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }
}
