package database;

import entity.Author;

import java.util.List;

public interface AuthorCRUD {

    Author saveAuthor(Author author);

    List<Author> findAllAuthors();

    Author findById(Integer id);

    void update(Author author);

    void delete(Integer id);









}
