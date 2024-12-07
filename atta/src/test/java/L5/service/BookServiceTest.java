package L5.service;

import L5.exception.InvalidNumberException;
import L5.exception.WrongShelfException;
import L5.model.book.Book;
import L5.model.book.BookType;
import L5.model.shelf.DetectiveShelf;
import L5.model.shelf.Shelf;
import org.junit.jupiter.api.Test;

;import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки корректности работы сервиса
 */
class BookServiceTest {
    @Test

    public void testNumber1() {
        Book book = new Book().setBookName("Убийство в подвале").setBookType(BookType.DETECTIVE).setNumber(1357);
        Integer number = 304;
        assertThrows(InvalidNumberException.class,
                () -> BookService.isNumberValid(book.getNumber(), number));
    }

    @Test
    public void testNumber2() {
        Book book = new Book().setBookName("Что-то о любви").setBookType(BookType.DRAMA).setNumber(308);
        Integer number = 308;
        assertTrue(BookService.isNumberValid(book.getNumber(), number));
    }

}