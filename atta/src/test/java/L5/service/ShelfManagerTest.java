package L5.service;


import L5.exception.InvalidNumberException;
import L5.exception.WrongShelfException;
import L5.model.book.Book;
import L5.model.book.BookType;
import L5.model.shelf.DetectiveShelf;
import L5.model.shelf.DramaShelf;
import L5.model.shelf.Shelf;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@Slf4j
class ShelfManagerTest {

    @Test
    public void testCheckReturnBook1() throws WrongShelfException {
        Book book = new Book().setBookName("Детектив очень интересный").setBookType(BookType.DETECTIVE).setNumber(1357);
        ShelfManager shelfManager = new ShelfManager();
        Shelf shelf = new DetectiveShelf();
        assertEquals(shelfManager.returnBookOnShelf(book, shelf), book);
    }

    @Test
    public void testCheckReturnBook2() throws WrongShelfException {
        Book book = new Book().setBookName("Детектив очень интересный").setBookType(BookType.DETECTIVE).setNumber(1357);
        ShelfManager shelfManager = new ShelfManager();
        Shelf shelf = new DramaShelf();
        assertThrows(WrongShelfException.class,
                () -> shelfManager.returnBookOnShelf(book, shelf));
    }

}