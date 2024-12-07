package L5.model.shelf;

import L5.model.book.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@NoArgsConstructor
@Getter
@Slf4j
public abstract class Shelf {

    public abstract ShelfType getShelfType();
    public abstract List<Book> getBooks();
    public abstract void clearShelf();
    public void log(String message){
        log.info(message);
    };

    public void returnBookOnShelf(Book book) {
    }


}
