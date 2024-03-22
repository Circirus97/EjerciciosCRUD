package model;

import database.AuthorCRUD;
import database.ConfigDB;
import entity.Author;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class AuthorModel implements AuthorCRUD {


    @Override
    public Object insertAuthor(Object object) {

        //1. Iniciar conexión
        Connection objConnection = ConfigDB.openConnection();

        //1. Castear el objeto
        Author objAuthor = (Author) object;

        try{

            //3. Crear el SQL
            String sql = "INSERT INTO authors(name, nationality) VALUE(?, ?);";

            //4. Preparar el statement
            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepareStatement.setString(1, objAuthor.getName());
            objPrepareStatement.setString(2, objAuthor.getNationality());

            objPrepareStatement.execute();

            ResultSet objResult = objPrepareStatement.getGeneratedKeys();
            while (objResult.next()) {
                objAuthor.setId(objResult.getInt(1));
            }

            objPrepareStatement.close();
            JOptionPane.showMessageDialog(null, "Author added successfully!");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error adding Author\n" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objAuthor;
    }

    @Override
    public Object updateAuthor(Object object) {
        return null;
    }

    @Override
    public void deleteAuthor(Object object) {

    }

    @Override
    public List<Object> findAllAuthor() {
        return null;
    }

    @Override
    public Object findByIdAuthor(int id) {
        return null;
    }

    @Override
    public List<Author> findByNameAuthor(String name) {
        return null;
    }
}
