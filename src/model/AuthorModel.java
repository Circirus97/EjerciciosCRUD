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

        Connection objConnection = ConfigDB.openConnection();

        Author objAuthor = (Author) object;

        try{

            String sql = "INSERT INTO authors(name, nationality) VALUE(?, ?);";

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
