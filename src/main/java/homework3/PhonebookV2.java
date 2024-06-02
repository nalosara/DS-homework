package main.java.homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {
        try {
            System.out.println("Loading the entries...");
            RedBlackTree<Entry> phoneBook = FileUtils.readFile("raw_phonebook_data.csv");

            int[] edgeCounts = phoneBook.countRedAndBlackEdges();
            System.out.println("==================================");
            System.out.println("System is ready.");
            System.out.println("Total red edges in the tree: " + edgeCounts[1]);
            System.out.println("Total black edges in the tree: " + edgeCounts[0]);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a name that you wish to search for, or -1 to exit:");
                String input = scanner.nextLine();
                if ("-1".equals(input)) {
                    break;
                }

                ArrayList<Entry> results = phoneBook.get(input);
                if (results != null) {
                    System.out.println("Found " + results.size() + " entries:");
                    for (Entry entry : results) {
                        System.out.println(entry);
                        System.out.println("------------");
                    }
                } else {
                    System.out.println("No entries found for: " + input);
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
