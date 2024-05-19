package main.java.homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int[] result = new int[2]; // Array to store start and end index of matched entries
        result[0] = -1; // Initialize start index
        result[1] = -1; // Initialize end index

        int left = 0;
        int right = entries.length - 1;

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String name = entries[mid].getName();

            if (name.equals(searchableName)) {
                // Found a match, update start and end indexes
                result[0] = findStartIndex(entries, searchableName, mid);
                result[1] = findEndIndex(entries, searchableName, mid);
                break;
            } else if (name.compareTo(searchableName) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Check if no entries were found
        if (result[0] == -1 && result[1] == -1) {
            return new int[0]; // Return an empty array
        }

        return result;
    }

    /*
    public static int[] search(Entry[] entries, String searchableName) {
        int[] result = new int[2]; // Array to store start and end index of matched entries
        result[0] = -1; // Initialize start index
        result[1] = -1; // Initialize end index

        int left = 0;
        int right = entries.length - 1;

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String name = entries[mid].getName();

            if (name.equals(searchableName)) {
                // Found a match, update start and end indexes
                result[0] = findStartIndex(entries, searchableName, mid);
                result[1] = findEndIndex(entries, searchableName, mid);
                break;
            } else if (name.compareTo(searchableName) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }*/

    private static int findStartIndex(Entry[] entries, String searchableName, int index) {
        while (index > 0 && entries[index - 1].getName().equals(searchableName)) {
            index--;
        }
        return index;
    }

    private static int findEndIndex(Entry[] entries, String searchableName, int index) {
        while (index < entries.length - 1 && entries[index + 1].getName().equals(searchableName)) {
            index++;
        }
        return index;
    }


}
