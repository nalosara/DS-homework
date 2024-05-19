package main.java.homework1;

import java.util.Comparator;

public class CountryComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.getCountry().compareTo(e2.getCountry());
    }
}
