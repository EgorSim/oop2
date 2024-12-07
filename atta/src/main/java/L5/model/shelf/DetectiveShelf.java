package L5.model.shelf;

import L5.model.book.Book;

import java.util.ArrayList;
import java.util.List;

public class DetectiveShelf extends Shelf{

    private List<Book> bookList = new ArrayList<>();
    @Override
    public ShelfType getShelfType() {
        return ShelfType.DETECTIVE_SHELF;
    }

    @Override
    public void returnBookOnShelf(Book book) {
        super.log("Кладем книгу на полку для детективов..");
        this.bookList.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return this.bookList;
    }

    @Override
    public void clearShelf() {
        this.bookList = new ArrayList<>();
    }
}
