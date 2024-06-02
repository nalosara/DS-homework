package main.java.homework3;

import java.util.ArrayList;

public class RedBlackTree<Entry> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node<Entry> root;

    private boolean isRed(Node<Entry> node) {
        if (node == null) return false;
        return node.color == RED;
    }

    private Node<Entry> rotateLeft(Node<Entry> h) {
        Node<Entry> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node<Entry> rotateRight(Node<Entry> h) {
        Node<Entry> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node<Entry> h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public ArrayList<Entry> get(String searchableName) {
        Node<Entry> x = root;
        ArrayList<Entry> results = new ArrayList<>();
        int redEdges = 0;
        int blackEdges = 0;
        while (x != null) {
            if (searchableName.compareTo(x.key) < 0) {
                x = x.left;
                if (x != null && x.color == RED) redEdges++;
                else blackEdges++;
            } else if (searchableName.compareTo(x.key) > 0) {
                x = x.right;
                if (x != null && x.color == RED) redEdges++;
                else blackEdges++;
            } else {
                results = x.values;
                break;
            }
        }
        System.out.println("Red edges on the path: " + redEdges);
        System.out.println("Black edges on the path: " + blackEdges);
        return results.isEmpty() ? null : results;
    }

    public void put(String searchableName, Entry entry) {
        root = put(root, searchableName, entry);
        root.color = BLACK;
    }

    private Node<Entry> put(Node<Entry> h, String searchableName, Entry entry) {
        if (h == null) return new Node<>(searchableName, entry, RED);

        if (searchableName.compareTo(h.key) < 0) {
            h.left = put(h.left, searchableName, entry);
        } else if (searchableName.compareTo(h.key) > 0) {
            h.right = put(h.right, searchableName, entry);
        } else {
            h.values.add(entry);
        }

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    public int[] countRedAndBlackEdges() {
        int[] counts = new int[2];
        countEdges(root, counts);
        return counts;
    }

    private void countEdges(Node<Entry> node, int[] counts) {
        if (node == null) return;
        if (node.left != null) {
            counts[node.left.color ? 1 : 0]++;
            countEdges(node.left, counts);
        }
        if (node.right != null) {
            counts[node.right.color ? 1 : 0]++;
            countEdges(node.right, counts);
        }
    }
}
