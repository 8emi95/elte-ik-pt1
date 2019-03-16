package hu.elte.progtech.book;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        try (BooksParser parser = new BooksParser("input.txt")) {
            List<Book> books = parser.parse();
            System.out.println("Total time necessary to read all of the books: " + calculateTotalTime(books) + " minutes.");
        } catch (IOException | NoSuchElementException | NumberFormatException e) {
            System.err.println("Error occurred");
        }
    }

    private static int calculateTotalTime(List<Book> books) {
        int totalTime = 0;
        for (Book book : books) {
            totalTime += book.getTime();
        }
        return totalTime;
    }

}
