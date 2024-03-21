package controller;

import entity.Author;
import model.AuthorModel;

import javax.swing.*;

public class AuthorController {

    AuthorModel objAuthorModel;

    public AuthorController(){

        this.objAuthorModel = new AuthorModel();
    }

    public void create(){

        Author objAuthor = new Author();

        String name = JOptionPane.showInputDialog("Insert Author name: ");
        String nationality = JOptionPane.showInputDialog("Insert Author nationality: ");

        objAuthor.setName(name);
        objAuthor.setNationality(nationality);

        objAuthor = (Author) this.objAuthorModel.insertAuthor(objAuthor);

        JOptionPane.showMessageDialog(null, objAuthor.toString());

    }




}
