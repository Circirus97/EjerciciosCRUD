package database;

import entity.Book;

import java.util.List;

public interface BookCRUD {

    Book save(Book book);

    List<Book> findAllBooks();

    List<Book> findByFilters(String filter, String value);

    Book findById(Integer id);

    void update(Book book);

    void delete(Integer id);









}
