package database;

import java.util.List;

public interface AutorCRUD {

    Object insertarAutor(Object object);

    List<Object> findAll();

    Object actualizarAutor();

    Object eliminarAutor();



    boolean update(Object object);

    boolean delete(Object object);

}
