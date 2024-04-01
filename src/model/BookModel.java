package model;

import database.BookCRUD;
import database.ConfigDB;
import entity.Author;
import entity.Book;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookModel implements BookCRUD {

    private Connection connection = ConfigDB.openConnection();


    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> findAllBooks() {

        List<Book> listBooks = new ArrayList<>();


        try {

            String sql = "SELECT * FROM books;";

            PreparedStatement objPrepare = connection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();


            while (objResult.next()) {

                Book book = new Book();


                book.setId(objResult.getInt("id"));
                book.setTitle(objResult.getString("title"));
                book.setYearPublication(objResult.getDate("year_publication"));
                book.setPrice(objResult.getDouble("price"));
                book.setIdAuthor(objResult.getInt("id_author"));


                listBooks.add(book);
            }

          //  objPrepare.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error show books list " + e.getMessage());
        }

       // ConfigDB.closeConnection();

        return listBooks;
    }

    @Override
    public List<Book> findByFilters(String filter, String value) {

        String sql;

        List<Book> listBooks = new ArrayList<>();


        try {


            if (Objects.equals(filter, "ID")) {
                sql = "SELECT * FROM books WHERE id = ?;";

                listBooks = findByFilterId(sql, value);

            }
            if (Objects.equals(filter, "Title")) {

                sql = "SELECT * FROM books WHERE title LIKE ?;";

                listBooks = findByTitle(sql, value);

            }
            if (Objects.equals(filter, "Author")) {

                sql = "SELECT * FROM books b JOIN authors a ON b.id_author = a.id WHERE a.name LIKE ?;";

                listBooks = findByAuthor(sql, value);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error find by filters " + e.getMessage());

        }

        //ConfigDB.closeConnection();
        return listBooks;
    }

    private List<Book> findByTitle(String sql, String value) {

        List<Book> listBooks = new ArrayList<>();

        try {
            PreparedStatement objPrepare = connection.prepareStatement(sql);
            objPrepare.setString(1, "%" +  value + "%");
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {

                Book book = new Book();

                book.setId(objResult.getInt("id"));
                book.setTitle(objResult.getString("title"));
                book.setYearPublication(objResult.getDate("year_publication"));
                book.setPrice(objResult.getDouble("price"));
                book.setIdAuthor(objResult.getInt("id_author"));


                listBooks.add(book);
            }

            //objPrepare.close();
            JOptionPane.showMessageDialog(null, "List of books filtered by titles:\n" + listBooks);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error show books " + e.getMessage());

        }

        return listBooks;

    }

    public List<Book> findByAuthor(String sql, String value) {

        List<Book> listBooks = new ArrayList<>();

        try {
            PreparedStatement objPrepare = connection.prepareStatement(sql);
            objPrepare.setString(1, "%" + value + "%");
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {

                Book book = new Book();

                book.setId(objResult.getInt("id"));
                book.setTitle(objResult.getString("title"));
                book.setYearPublication(objResult.getDate("year_publication"));
                book.setPrice(objResult.getDouble("price"));
                book.setIdAuthor(objResult.getInt("id_author"));


                listBooks.add(book);
            }

            //objPrepare.close();
            JOptionPane.showMessageDialog(null, "List of books filtered by ID author:\n" + listBooks);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error show books  " + e.getMessage());
        }

        return listBooks;

    }

    public List<Book> findByFilterId(String sql, String value) {

        ConfigDB.openConnection();

        List<Book> listBooks = new ArrayList<>();

        try {
            PreparedStatement objPrepare = connection.prepareStatement(sql);
            objPrepare.setInt(1, Integer.parseInt(value));
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {

                Book book = new Book();

                book.setId(objResult.getInt("id"));
                book.setTitle(objResult.getString("title"));
                book.setYearPublication(objResult.getDate("year_publication"));
                book.setPrice(objResult.getDouble("price"));
                book.setIdAuthor(objResult.getInt("id_author"));


                listBooks.add(book);
            }


            JOptionPane.showMessageDialog(null, "List of books filtered by ID" + listBooks);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error show books  " + e.getMessage());
        }

        return listBooks;

    }

    @Override
    public Book findById(Integer id) {
        return null;
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Integer id) {

    }
}
