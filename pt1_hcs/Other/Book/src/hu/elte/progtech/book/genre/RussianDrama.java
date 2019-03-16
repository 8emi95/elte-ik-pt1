package hu.elte.progtech.book.genre;

import hu.elte.progtech.book.Book;

public class RussianDrama extends Book {

    public RussianDrama(int pages, boolean isCompulsory) {
        super(pages, isCompulsory);
    }

    @Override
    protected int getTimeBasedOnPages() {
        return pages * 4;
    }

}
