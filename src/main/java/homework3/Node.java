package main.java.homework3;

import java.util.ArrayList;

public class Node<Entry> {
    String key;
    ArrayList<Entry> values;
    Node<Entry> left, right;
    boolean color; // true for red, false for black

    public Node(String key, Entry value, boolean color) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(value);
        this.left = null;
        this.right = null;
        this.color = color;
    }
}
