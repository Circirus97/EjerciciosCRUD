package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    //Variable que va a contener el estado de la conexión
    static Connection objConnection = null;

    //Método para abrir la conexión entre Java y la base de datos

    public static Connection openConnection(){

        try {

            // Class.forName permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos variables con nuestras credenciales de la base de datos
            String url = "jdbc:mysql://bmcdqekun2oymud6tpdk-mysql.services.clever-cloud.com:3306/bmcdqekun2oymud6tpdk";
            String user = "ux9xsqdqpgvwejvk";
            String password = "L16e6ClBQ9iacNbpIyz1";

            //Establecemos la conexion
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Established connection");

        }catch (ClassNotFoundException e){
            System.out.println("Error >> Driver not installed \n"+e.getMessage());
        }catch (SQLException e){
            System.out.println("Error >> A connection to the DB could not be established\n"+e.getMessage());
        }

        return objConnection;
    }


    public static void closeConnection(){

        //Si hay una conexión activa, la cerramos
        try{
            if (objConnection != null) objConnection.close();


            //
        }catch (SQLException e){
            System.out.println("Error >> " + e.getMessage());
        }
    }




}
