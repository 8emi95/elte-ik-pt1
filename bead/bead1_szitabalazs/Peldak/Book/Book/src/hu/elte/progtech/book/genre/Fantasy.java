package hu.elte.progtech.book.genre;

import hu.elte.progtech.book.Book;

public class Fantasy extends Book {

    public Fantasy(int pages, boolean isCompulsory) {
        super(pages, isCompulsory);
    }

    @Override
    protected int getTimeBasedOnPages() {
        int pagesToRead = pages;
        int sum = 0;
        int multiplier = 4;
        while (pagesToRead >= 100) {
            pagesToRead -= 100;
            sum += 100 * multiplier;
            multiplier = multiplier == 4 ? 3 : 4;
        }
        sum += pagesToRead * multiplier;
        return sum;
    }

}
