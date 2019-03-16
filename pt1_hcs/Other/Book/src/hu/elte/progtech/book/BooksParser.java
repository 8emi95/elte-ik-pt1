package hu.elte.progtech.book;

import static hu.elte.progtech.book.genre.BookGenre.CRIME_FICTION;
import static hu.elte.progtech.book.genre.BookGenre.FANTASY;
import static hu.elte.progtech.book.genre.BookGenre.RUSSIAN_DRAMA;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import hu.elte.progtech.book.genre.CrimeFiction;
import hu.elte.progtech.book.genre.Fantasy;
import hu.elte.progtech.book.genre.RussianDrama;

public class BooksParser implements Closeable {

    private static final String COMPULSORY = "k";

    private static final String PAGE_NUMBER_ERROR = "Page number must be positive";
    private static final String GENRE_ERROR = "Unknown genre";
    private static final String NOT_ENOUGH_DATA_ERROR = "Not enough data about a book";

    private Scanner scanner;

    public BooksParser(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
    }

    public List<Book> parse() throws NoSuchElementException, NumberFormatException {
        List<Book> books = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fragments = line.split("\\s+");
            books.add(createBook(fragments));
        }
        return books;
    }

    private Book createBook(String[] fragments) throws NoSuchElementException, NumberFormatException {
        try {
            if (COMPULSORY.equals(fragments[fragments.length - 1])) {
                return createBook(fragments[fragments.length - 3], fragments[fragments.length - 2], true);
            } else {
                return createBook(fragments[fragments.length - 2], fragments[fragments.length - 1], false);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(NOT_ENOUGH_DATA_ERROR);
        }
    }

    private Book createBook(String genre, String pages, boolean isCompulsory) throws NoSuchElementException, NumberFormatException {
        int pageCount = getPageCount(pages);
        if (CRIME_FICTION.getKey().equals(genre)) {
            return new CrimeFiction(pageCount, isCompulsory);
        } else if (RUSSIAN_DRAMA.getKey().equals(genre)) {
            return new RussianDrama(pageCount, isCompulsory);
        } else if (FANTASY.getKey().equals(genre)) {
            return new Fantasy(pageCount, isCompulsory);
        } else {
            throw new NoSuchElementException(GENRE_ERROR);
        }
    }

    private int getPageCount(String pages) throws NumberFormatException {
        int pageCount = Integer.parseInt(pages);
        if (pageCount < 0) {
            throw new NumberFormatException(PAGE_NUMBER_ERROR);
        }
        return pageCount;
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }

}
