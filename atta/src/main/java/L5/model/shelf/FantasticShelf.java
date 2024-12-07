package L5.model.shelf;

import L5.model.book.Book;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FantasticShelf extends Shelf {

    private List<Book> bookList = new ArrayList<>();
    @Override
    public ShelfType getShelfType() {
        return ShelfType.FANTASTIC_SHELF;
    }

    @Override
    public void returnBookOnShelf(Book book) {
        super.log("Кладем книгу на полку для фантастики..");
        this.bookList.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return this.bookList;
    }

    @Override
    public void clearShelf() {
        this.bookList =  new ArrayList<>();
    }
}
