package model;


import database.AuthorCRUD;
import database.ConfigDB;
import entity.Author;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorModel implements AuthorCRUD {
   private Connection connection = ConfigDB.openConnection();

    @Override
    public Author saveAuthor(Author author) {


        //1. Abrir conexión
        Connection objConnection = ConfigDB.openConnection();

        try {
            //3. Crear el SQL
            String sql = "INSERT INTO authors(name, nationality) VALUES (?, ?)";

            //4. Preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Asignar los ?
            objPrepare.setString(1, author.getName());
            objPrepare.setString(2, author.getNationality());

            //6. Ejecutamos el Query
            objPrepare.execute();

            //7. Obtener el resultado
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                author.setId(objResult.getInt(1));
            }

            //8. Cerramos el prepareStatement
            objPrepare.close();
            JOptionPane.showMessageDialog(null," Author insertion was successful.");

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error adding Author " + e.getMessage());
        }
        //9. Cerramos la conexión
        ConfigDB.closeConnection();

        return author;

    }

    @Override
    public List<Author> findAllAuthors() {

        //1. Abrir conexión
        Connection objConnection = ConfigDB.openConnection();
        List<Author> listAuthors = new ArrayList<>();


        try {

            String sql = "SELECT * FROM authors;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while (objResult.next()){

                Author objAuthor = new Author();


                objAuthor.setId(objResult.getInt("id"));
                objAuthor.setName(objResult.getString("name"));
                objAuthor.setNationality(objResult.getString("nationality"));


                listAuthors.add(objAuthor);
            }

            objPrepare.close();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error show authors list " + e.getMessage());
        }

        ConfigDB.closeConnection();
       return listAuthors;
    }

    @Override
    public Author findById(Integer id) {

        Author objAuthor = new Author();

        try{

            String sql = "SELECT * FROM authors WHERE id = ? ;";

            PreparedStatement objPrepare = connection.prepareStatement(sql);

            objPrepare.setInt(1, id);

            ResultSet objResult = objPrepare.executeQuery();



            while (objResult.next()){

                objAuthor.setId(objResult.getInt("id"));
                objAuthor.setName(objResult.getString("name"));
                objAuthor.setNationality(objResult.getString("nationality"));

            }

        }catch (SQLException e){

            JOptionPane.showMessageDialog(null, "Error show author " + e.getMessage());

        }

        ConfigDB.closeConnection();
        return objAuthor;
    }

    @Override
    public void update(Author author) {

        try {

            String sql = "UPDATE authors SET name = ?, nationality = ? WHERE (id = ?);";

            PreparedStatement objPrepare = connection.prepareStatement(sql);

            objPrepare.setString(1, author.getName());
            objPrepare.setString(2, author.getNationality());
            objPrepare.setInt(3, author.getId());

            objPrepare.execute();
            objPrepare.close();

            JOptionPane.showMessageDialog(null, "Author updated successfully");

        }catch (SQLException e){

            JOptionPane.showMessageDialog(null, "Error update author " + e.getMessage());
        }

        ConfigDB.closeConnection();


    }

    @Override
    public void delete(Integer id) {

        try {

            String sqlBooks = "DELETE FROM books WHERE id_author = ?;";
            PreparedStatement objPrepareBooks = connection.prepareStatement(sqlBooks);
            objPrepareBooks.setInt(1, id);
            objPrepareBooks.execute();
            objPrepareBooks.close();

            ////////////////////////////////////////////////////////////////////////////////////////

            String sql = "DELETE FROM authors WHERE id = ?;";
            PreparedStatement objPrepare = connection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            objPrepare.execute();
            objPrepare.close();

            JOptionPane.showMessageDialog(null, "Author delete successfully");


        }catch (SQLException e){

            JOptionPane.showMessageDialog(null, "Error delete author " + e.getMessage());

        }

    }
}
