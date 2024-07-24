import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.regex.*;

public class TextFileScript {
    private static final String INPUT_FILE_PATH = "C:\\Users\\gabri\\Downloads\\Project_Calculator\\TextFileProcessor\\src\\input.txt";
    private static final String OUTPUT_FILE_PATH = "C:\\Users\\gabri\\Downloads\\Project_Calculator\\TextFileProcessor\\src\\output.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response = "";

        do {
            System.out.print("Enter the word to find: ");
            String phraseToFind = scanner.nextLine();

            try {
                if (!Files.exists(Paths.get(INPUT_FILE_PATH))) {
                    throw new FileNotFoundException("Input file not found: " + INPUT_FILE_PATH);
                }

                int count = countOccurrencesInFile(INPUT_FILE_PATH, phraseToFind);

                String result = "The word \"" + phraseToFind + "\" appears " + count + " times.";
                saveToFile(result, OUTPUT_FILE_PATH);

                System.out.println(result);
                System.out.println("Result saved in " + OUTPUT_FILE_PATH);

            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }

            do {
                System.out.print("Do you want to search for another word? (yes/no): ");
                response = scanner.nextLine().toLowerCase().trim();
            } while (!response.equals("yes") && !response.equals("no"));

        } while (response.equals("yes"));

        scanner.close();
        System.out.println("Thank you for using the word search program!");
    }

    static int countOccurrencesInFile(String filePath, String phrase) throws IOException {
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(phrase) + "\\b", Pattern.CASE_INSENSITIVE);
        int count = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
            }
        }
        return count;
    }

    static void saveToFile(String content, String filePath) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }
}