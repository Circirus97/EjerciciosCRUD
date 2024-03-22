package model;

import database.BookCRUD;
import entity.Author;
import entity.Book;

import java.util.List;

public class BookModel implements BookCRUD {
    @Override
    public Object insertBook(Object object) {
        return null;
    }

    @Override
    public Object updateBook(Object object) {
        return null;
    }

    @Override
    public void deleteBook(Object object) {

    }

    @Override
    public List<Object> findAllBook() {
        return null;
    }

    @Override
    public Object findByIdBook(int id) {
        return null;
    }

    @Override
    public List<Book> findByNameBook(String name) {
        return null;
    }

    @Override
    public List<Author> findByNameAuthor(String name) {
        return null;
    }
}
