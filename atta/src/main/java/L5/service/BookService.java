package L5.service;

import L5.exception.InvalidNumberException;
import L5.model.book.Book;

import java.util.Objects;

/**
 * Класс для работы с продуктом
 */
public class BookService {

    static boolean isNumberValid(Integer number, Integer numberBook){
        if (!Objects.equals(number, numberBook)){
            throw new InvalidNumberException("Номер билета не совпадает с номером книги");
        }
        return true;
    }
}
