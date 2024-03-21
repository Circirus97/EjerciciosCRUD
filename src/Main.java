import controller.AuthorController;
import database.ConfigDB;
import entity.Author;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ConfigDB.openConnection();

        AuthorController objAuthorController = new AuthorController();

        String option = "";

        do {
            option = JOptionPane.showInputDialog("""
                        MENU
                        1. Menu authors
                        2. Menu books
                        3. EXIT
                        Choose an option
                    """);

            switch (option) {

                case "1":
                    String option2;
                    do {
                        option2 = JOptionPane.showInputDialog("""
                            MENU AUTHORS
                            1. Created a new author.
                            2. Finding author.
                            3. Updated author.
                            4. Delete author.
                            5. EXIT.                        
                            """);

                        switch (option2){
                            case "1":
                                objAuthorController.create();

                                break;

                            case "2":
                                //objAuthorController.getAll();
                                break;

                            case "3":
                                //objAuthorController.updateCoder();
                                break;

                            case "4":
                                //objAuthorController.delete();
                                break;

                            case "5":
                                //objAuthorController.find();
                                break;
                        }

                    }while (!option2.equals("5"));
                    break;

                case "2":
                    String option3;
                    do {
                        option3 = JOptionPane.showInputDialog("""
                            MENU BOOKS
                            1. Created a new book.
                            2. Finding author.
                            3. Updated author.
                            4. Delete author.
                            5. EXIT.                        
                            """);

                        switch (option3){
                            case "1":
                                //objAuthorController.getAll();
                                break;

                            case "2":
                                objAuthorController.create();
                                break;

                            case "3":
                                //objAuthorController.updateCoder();
                                break;

                            case "4":
                                //objAuthorController.delete();
                                break;

                            case "5":
                                //objAuthorController.find();
                                break;
                        }

                    }while (!option3.equals("5"));
                    break;

            }

        } while (!option.equals("3"));


    }
}