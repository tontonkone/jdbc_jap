package fr.diginamic.file;
import java.io.*;
import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        try (
            PrintWriter writer = new PrintWriter(new File("test.txt"))) {
            writer.println("Hello World");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
