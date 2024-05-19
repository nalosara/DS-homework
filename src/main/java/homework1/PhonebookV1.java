package main.java.homework1;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) {
        try {
            Entry[] entries = FileUtils.readFile("raw_phonebook_data.csv");

            MergeSort.sort(entries);

            FileUtils.writeToFile(entries, "sorted_phonebook.csv");

            System.out.println("Loading the entries...");
            System.out.println("Sorting the entries...");
            System.out.println("Saving the sorted file...");
            System.out.println("==================================");
            System.out.println("System is ready.");
            System.out.println("\n");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter the name that you wish to search for, or -1 to exit: ");
                String input = scanner.nextLine();

                // Check if the user wants to exit the program
                if (input.equals("-1")) {
                    System.out.println("Thank you for using the phonebook.");
                    break;
                }

                // Run binary search on the sorted data array
                int[] indexes = BinarySearch.search(entries, input);

                if (indexes.length == 0) {
                    System.out.println("No entries with the given name exist in the phonebook.");
                } else {
                    int startIndex = indexes[0];
                    int endIndex = indexes[1];
                    int count = endIndex - startIndex + 1;

                    System.out.println("Entries found: " + count);
                    System.out.println();
                    for (int i = startIndex; i <= endIndex; i++) {
                        //System.out.println("Entry " + (i + 1) + ":");
                        System.out.println("Name: " + entries[i].getName());
                        System.out.println("Street Address: " + entries[i].getStreetAddress());
                        System.out.println("City: " + entries[i].getCity());
                        System.out.println("Post code: " + entries[i].getPostcode());
                        System.out.println("Country: " + entries[i].getCountry());
                        System.out.println("Phone number: " + entries[i].getPhoneNumber());
                        System.out.println();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}

