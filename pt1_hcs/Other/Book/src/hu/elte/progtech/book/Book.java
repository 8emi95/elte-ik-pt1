package hu.elte.progtech.book;

public abstract class Book {

    protected int pages;
    private boolean isCompulsory;

    protected Book(int pages, boolean isCompulsory) {
        this.pages = pages;
        this.isCompulsory = isCompulsory;
    }

    public int getTime() {
        int baseTime = getTimeBasedOnPages();
        return isCompulsory ? baseTime * 2 : baseTime;
    }

    protected abstract int getTimeBasedOnPages();

}
