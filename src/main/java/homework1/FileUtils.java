package main.java.homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        List<Entry> entries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                Entry entry = new Entry(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        values[5]
                );
                entries.add(entry);
            }

        }

        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("name;street_address;city;postcode;country;phone_number");
            writer.newLine();

            for (Entry entry : entries) {
                // Split the name into surname and name
                String[] nameParts = entry.getName().split(", ");
                String surname = nameParts[0];
                String name = nameParts[1];

                writer.write(surname + ", " + name + ";" +
                        entry.getStreetAddress() + ";" +
                        entry.getCity() + ";" +
                        entry.getPostcode() + ";" +
                        entry.getCountry() + ";" +
                        entry.getPhoneNumber());
                writer.newLine();
            }

        }
    }


}