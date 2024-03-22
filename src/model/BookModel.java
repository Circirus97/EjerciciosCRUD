package model;

import database.CRUDBook;
import database.ConfigDB;
import entity.Author;
import entity.Book;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class BookModel implements CRUDBook {
    @Override
    public Object insertBook(Object object) {

        //1. Abrir conexión
        Connection objConnection = ConfigDB.openConnection();

        //2. Castear el objeto
        Book objBook = (Book) object;

        try {
            //3. Crear el SQL
            String sql = "INSERT INTO books (title, yearPublication, price) VALUES (?, ?, ?)";

            //4. Preparar el statement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Asignar los ?
            objPrepare.setString(1, objBook.getTitle());
            objPrepare.setDate(2, objBook.getYearPublication());
            objPrepare.setDouble(3, objBook.getPrice());

            //6. Ejecutamos el Query
            objPrepare.execute();

            //7. Obtener el resultado
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objBook.setId(objResult.getInt(1));
            }

            //8. Cerramos el prepareStatement
            objPrepare.close();
            JOptionPane.showMessageDialog(null," Book insertion was successful.");

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error adding Book " + e.getMessage());
        }
        //9. Cerramos la conexión
        ConfigDB.closeConnection();
        return objBook;
    }

    @Override
    public boolean updateBook(Object object) {

        //1. Abrir la conexión
        Connection objConecction = ConfigDB.openConnection();

        //2. Convertir el objeto
        Book objBook = (Book) object;

        //3. Variable bandera para saber si se actualizó
        boolean isUpdated = false;

        try {
            //4. Creamos la sentencia SQL
            String sql = "UPDATE books SET title = ?, year_publication = ?, price = ? WHERE id = ?;";

            //5. Preparamos el statement
            PreparedStatement objPrepare = objConecction.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //6. Dar valor a los ? parámetros de Query
            objPrepare.setString(1, objBook.getTitle());
            objPrepare.setDate(2, objBook.getYearPublication());
            objPrepare.setDouble(3, objBook.getPrice());


            //7. Ejecutamos el query
            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"The update was successful.");
            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            //8. Cerrar la conexión
            ConfigDB.closeConnection();
        }

        return isUpdated;
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