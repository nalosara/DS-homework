package main.java.homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    public static RedBlackTree<Entry> readFile(String filePath) throws IOException {
        RedBlackTree<Entry> tree = new RedBlackTree<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 6) {
                    Entry entry = new Entry(
                            values[0].trim(),
                            values[1].trim(),
                            values[2].trim(),
                            values[3].trim(),
                            values[4].trim(),
                            values[5].trim()
                    );
                    tree.put(values[0].trim(), entry);
                }
            }
        }
        return tree;
    }
}
