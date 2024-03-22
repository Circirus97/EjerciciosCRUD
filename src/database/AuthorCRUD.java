package database;

import entity.Author;

import java.util.List;

public interface AuthorCRUD {

    Object insertAuthor(Object object);

    Object updateAuthor(Object object);

    void deleteAuthor(Object object);

    List<Object> findAllAuthor();

    Object findByIdAuthor(int id);

    List<Author> findByNameAuthor(String name);

}
