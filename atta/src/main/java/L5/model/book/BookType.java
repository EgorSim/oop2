package L5.model.book;

/**
 * Жанр книги (детектив, драма, фантастика)
 */
public enum BookType {
    DETECTIVE("detective"),
    DRAMA("drama"),
    FANTASTIC("fantastic");

    private final String value;

    BookType(String value) {
        this.value = value;
    }

    public String toValue(){
        return value;
    }
}
