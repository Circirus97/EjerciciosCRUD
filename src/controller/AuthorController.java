package controller;

import database.AuthorCRUD;
import entity.Author;

import javax.swing.*;
import java.util.List;

public class AuthorController {


    private final AuthorCRUD objAuthorModel;

    public AuthorController(AuthorCRUD objAuthorModel) {
        this.objAuthorModel = objAuthorModel;
    }

    public void delete(){

        JOptionPane.showMessageDialog(null, "List of existing authors\n" + objAuthorModel.findAllAuthors());

        Integer id = Integer.valueOf(JOptionPane.showInputDialog(null, "Insert the id author to deleted: "));

        this.objAuthorModel.delete(id);
    }

    public void update() {

        JOptionPane.showMessageDialog(null, "List of existing authors\n" + objAuthorModel.findAllAuthors());

        Integer id = Integer.valueOf(JOptionPane.showInputDialog(null, "Insert the id author: "));

        String updateName = JOptionPane.showInputDialog(null, "Insert new name: ");
        String updateNationality = JOptionPane.showInputDialog(null, "Insert new nationality: ");

        Author author = new Author();

        author.setName(updateName);
        author.setNationality(updateNationality);
        author.setId(id);

        this.objAuthorModel.update(author);

        JOptionPane.showMessageDialog(null, "The author, " + updateName + "\nupdated successful");

    }

    public void findById() {

        Integer idAuthor = Integer.valueOf(JOptionPane.showInputDialog(null, "Insert author id: "));

        Author objAuthor = this.objAuthorModel.findById(idAuthor);

        JOptionPane.showMessageDialog(null, "The consulted author is: \n" + objAuthor);
    }

    public void findAll() {

        List<Author> listAuthors;

        listAuthors = this.objAuthorModel.findAllAuthors();

        JOptionPane.showMessageDialog(null, "The author list 📚 \n" + listAuthors);

    }


    public void create() {

        Author objAuthor = new Author();

        String name = JOptionPane.showInputDialog(null, "Insert author name: ");
        String nationality = JOptionPane.showInputDialog(null, "Insert auhtor nationality");

        objAuthor.setName(name);
        objAuthor.setNationality(nationality);

        objAuthor = this.objAuthorModel.saveAuthor(objAuthor);

        JOptionPane.showMessageDialog(null, "Author inserted: \n" + objAuthor.toString());

    }


}
