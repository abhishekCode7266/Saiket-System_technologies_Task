import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Textfileanalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Text File Analyzer =====");

        // Create a text file on Desktop automatically
        String desktopPath = System.getProperty("user.home") + "\\Desktop";
        String filePath = desktopPath + "\\TextAnalyzerData.txt";

        File file = new File(filePath);

        try {

            // Create file and add sample text automatically
            FileWriter writer = new FileWriter(file);

            writer.write("Java is easy to learn.\n");
            writer.write("Java is a powerful programming language.\n");
            writer.write("I am learning Java programming.\n");
            writer.write("Java is used for software development.");

            writer.close();

            System.out.println("Text file created successfully.");
            System.out.println("File location: " + filePath);

        } catch (IOException e) {

            System.out.println("Error creating file: " + e.getMessage());
            sc.close();
            return;
        }

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        StringBuilder fullText = new StringBuilder();

        // Read the automatically created file
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                lineCount++;

                charCount += line.length();

                fullText.append(line).append("\n");

                String trimmed = line.trim();

                if (!trimmed.isEmpty()) {
                    wordCount += trimmed.split("\\s+").length;
                }
            }

        } catch (IOException e) {

            System.out.println(
                "Could not read the file: " + e.getMessage()
            );

            sc.close();
            return;
        }

        // Display file statistics
        System.out.println("\n--- File Statistics ---");
        System.out.println("File: TextAnalyzerData.txt");
        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Characters: " + charCount);

        // Search option
        System.out.print(
            "\nWould you like to search for a word? (y/n): "
        );

        String answer = sc.nextLine().trim().toLowerCase();

        if (answer.equals("y") || answer.equals("yes")) {

            System.out.print("Enter the word to search for: ");

            String word = sc.nextLine().trim();

            String[] allWords =
                fullText.toString().split("\\s+");

            int occurrences = 0;

            for (String w : allWords) {

                // Remove punctuation
                String cleanWord =
                    w.replaceAll("[^a-zA-Z0-9]", "");

                if (cleanWord.equalsIgnoreCase(word)) {
                    occurrences++;
                }
            }

            if (occurrences > 0) {

                System.out.println(
                    "Found \"" + word + "\" "
                    + occurrences + " time(s) in the file."
                );

            } else {

                System.out.println(
                    "\"" + word + "\" was not found in the file."
                );
            }
        }

        System.out.println("\nText file analysis completed.");

        sc.close();
    }
}
