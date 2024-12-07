package L5.model.shelf;

/**
 * Тип полки (мясная, рыбная, овощная)
 */
public enum ShelfType {
    DETECTIVE_SHELF("detective"),
    DRAMA_SHELF("drama"),
    FANTASTIC_SHELF("fantastic");

    private final String value;

    ShelfType(String value) {
        this.value = value;
    }

    public String toValue(){
        return value;
    }
}
