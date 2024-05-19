package main.java.homework1;

import java.util.Comparator;

public class PhoneNumberComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.getPhoneNumber().compareTo(e2.getPhoneNumber());
    }
}
