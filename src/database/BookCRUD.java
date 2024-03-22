package database;

import entity.Author;
import entity.Book;

import java.util.List;

public interface BookCRUD {

    Object insertBook(Object object);

    Object updateBook(Object object);

    void deleteBook(Object object);

    List<Object> findAllBook();

    Object findByIdBook(int id);

    List<Book> findByNameBook(String name);

    List<Author> findByNameAuthor(String name);


}
