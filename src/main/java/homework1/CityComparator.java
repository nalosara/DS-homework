package main.java.homework1;

import java.util.Comparator;

public class CityComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.getCity().compareTo(e2.getCity());
    }
}
