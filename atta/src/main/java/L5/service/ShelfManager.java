package L5.service;

import L5.exception.WrongShelfException;
import L5.model.book.Book;
import L5.model.book.BookType;
import L5.model.shelf.Shelf;
import L5.model.shelf.ShelfType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ShelfManager {

    /**
     * Список полок
     */
    private final Map<ShelfType, Book> shelves = new HashMap<>();
    private final String ERROR_MESSAGE = "Во время выполнения функции произошла ошибка: %s";

    /**
     * Сравниваем тип продукта и полки, отлавливаем ошибку
     *
     * @param book - книга, которую хотим положить на полку
     * @param shelf   - полка
     */
    public Book returnBookOnShelf(Book book, Shelf shelf) throws WrongShelfException {
        try {
            isRightShelf(book.getBookType(), shelf.getShelfType());
            shelf.returnBookOnShelf(book);
            shelves.put(shelf.getShelfType(), book);
        } catch (WrongShelfException e) {
            log.error(ERROR_MESSAGE.formatted(e.getMessage()));
            throw e;
        } finally {
            if (!shelves.containsKey(shelf.getShelfType())){
                shelves.put(shelf.getShelfType(), book);
                log.info("Библиотекарь положил книгу на полку!");

            }
        }
        return book;
    }

    /**
     * Если значения енамов не совпадают, выкидывается ошибка
     *
     * @param bookType - тип продукта
     * @param shelfType   - тип полки
     */
    private static void isRightShelf(BookType bookType, ShelfType shelfType) throws WrongShelfException {
        if (!bookType.toValue().equals(shelfType.toValue())) {
            throw new WrongShelfException("Попытка положить книгу не на ту полку!");
        }
    }
}
