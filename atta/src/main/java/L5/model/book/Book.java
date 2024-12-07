package L5.model.book;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


/***
 * Любая книга в библиотеке
 */
@Getter
@Setter
@Accessors(chain = true)
public class Book {
    private String bookName;
    private BookType bookType;


    private Integer number;

}
