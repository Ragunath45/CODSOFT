//-----------------------------Task - 2 Word Counter---------------




import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word Count Program");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file path");
        System.out.print("Choose an option (1/2): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String inputText = "";
        
        if (choice == 1) {
            System.out.print("Enter your text: ");
            inputText = scanner.nextLine();
        } else if (choice == 2) {
            System.out.print("Enter file path: ");
            String filePath = scanner.nextLine();
            
            try {
                Scanner fileScanner = new Scanner(new File(filePath));
                while (fileScanner.hasNextLine()) {
                    inputText += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                scanner.close();
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }
        
        String[] words = inputText.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        System.out.println("Total word count: " + wordCount);

        scanner.close();
    }
}