package main.java.homework1;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) {
        try {
            // Load the unsorted file into an array
            Entry[] entries = FileUtils.readFile("raw_phonebook_data.csv");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose sorting criteria: ");
            System.out.println("1. Name");
            System.out.println("2. Street Address");
            System.out.println("3. City");
            System.out.println("4. Postcode");
            System.out.println("5. Country");
            System.out.println("6. Phone Number");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            Comparator<Entry> comparator = null;
            switch (choice) {
                case 1:
                    // Default comparator in Entry class is for name
                    break;
                case 2:
                    comparator = new StreetAddressComparator();
                    break;
                case 3:
                    comparator = new CityComparator();
                    break;
                case 4:
                    comparator = new PostcodeComparator();
                    break;
                case 5:
                    comparator = new CountryComparator();
                    break;
                case 6:
                    comparator = new PhoneNumberComparator();
                    break;
                default:
                    System.out.println("Invalid choice. Sorting by name.");
            }

            // Sort the entries
            MergeSort.sort(entries, comparator);

            // Save the sorted entries into a new CSV file
            FileUtils.writeToFile(entries, "sorted_phonebook.csv");

            System.out.println("Loading the entries...");
            System.out.println("Sorting the entries...");
            System.out.println("Saving the sorted file...");
            System.out.println("==================================");
            System.out.println("System is ready.");
            System.out.println("\n");

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
