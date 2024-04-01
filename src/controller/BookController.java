package controller;

import database.BookCRUD;
import entity.Book;

import javax.swing.*;
import java.util.List;

public class BookController {

    private final BookCRUD bookModel;

    public BookController(BookCRUD bookModel) {
        this.bookModel = bookModel;
    }

    public void findByFilters() {

        String[] options = {"ID", "Title", "Author"};

        JOptionPane.showMessageDialog(null, "List of existing books\n" + bookModel.findAllBooks());

        String selectedFilter = (String) JOptionPane.showInputDialog(null, "Select the filter you want to use\n", "Filter", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        String valueFilter = JOptionPane.showInputDialog(null, "Enter the query (ID, title or Author)");

        List<Book> listBooks = this.bookModel.findByFilters(selectedFilter, valueFilter);
    }

    public void findAll() {

        List<Book> listBooks;

        listBooks = this.bookModel.findAllBooks();

        JOptionPane.showMessageDialog(null, "The books list 📚 \n" + listBooks);

    }
}
