package main.java.homework1;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    public static void sort(Entry[] entries) {
        sort(entries, null);
    }

    public static void sort(Entry[] entries, Comparator<Entry> comparator) {
        if (entries.length < 2) {
            return;
        }

        int mid = entries.length / 2;
        Entry[] left = Arrays.copyOfRange(entries, 0, mid);
        Entry[] right = Arrays.copyOfRange(entries, mid, entries.length);

        sort(left, comparator);
        sort(right, comparator);
        merge(entries, left, right, comparator);
    }

    private static void merge(Entry[] entries, Entry[] left, Entry[] right, Comparator<Entry> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator == null) {
                if (left[i].compareTo(right[j]) <= 0) {
                    entries[k++] = left[i++];
                } else {
                    entries[k++] = right[j++];
                }
            } else {
                if (comparator.compare(left[i], right[j]) <= 0) {
                    entries[k++] = left[i++];
                } else {
                    entries[k++] = right[j++];
                }
            }
        }
        while (i < left.length) {
            entries[k++] = left[i++];
        }

        while (j < right.length) {
            entries[k++] = right[j++];
        }
    }
}
