package hu.elte.progtech.book.genre;

public enum BookGenre {
    
    CRIME_FICTION("krimi"),
    RUSSIAN_DRAMA("orosz"),
    FANTASY("fantasy");

    private String key;

    private BookGenre(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
