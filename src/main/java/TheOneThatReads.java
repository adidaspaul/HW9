
import java.io.*;
import java.util.Scanner;

public class TheOneThatReads {
    public static void main(String[] args) {
        try {
            new TheOneThatReads().validate();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    File file = new File("src/main/resources/File1.txt");
    Scanner numbers;


    public void validate() throws IOException {
        if (!file.exists()) {
            System.out.println(file.getName() + " does not exist");
        }
        numbers = new Scanner(file);
        while (numbers.hasNextLine()) {
            String lines = numbers.nextLine();
            if (lines.contains("(") || lines.contains("-"))
                System.out.println(lines);
        }
    }

}
