package hu.elte.progtech.book.genre;

import hu.elte.progtech.book.Book;

public class CrimeFiction extends Book {

    public CrimeFiction(int pages, boolean isCompulsory) {
        super(pages, isCompulsory);
    }

    @Override
    protected int getTimeBasedOnPages() {
        if (pages >= 100) {
            return (pages - 100) * 3 + 200;
        } else {
            return pages * 2;
        }
    }

}
