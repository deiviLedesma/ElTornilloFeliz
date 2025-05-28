/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.ICategoriaDAO;
import POJOs.Categoria;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * DAO para manejar operaciones CRUD sobre la colección Categoria en MongoDB.
 *
 * @author SDavidLedesma
 */
public class CategoriaDAO implements ICategoriaDAO {

    private final MongoCollection<Categoria> coleccion;

    /**
     * Constructor que inicializa la colección de categorias desde la conexion
     */
    public CategoriaDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Categoria", Categoria.class);
    }

    /**
     * metodo que registra una categoria
     *
     * @param categoria
     * @return devuelve la categoria registrada
     * @throws PersistenciaException
     */
    @Override
    public Categoria registrarCaregoria(Categoria categoria) throws PersistenciaException {
        try {
            //inserta una nueva categoria
            InsertOneResult resultado = coleccion.insertOne(categoria);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("La inserción de la categoría no fue reconocida");
            }
            //devuelve la categoria insertada
            return categoria;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al insertar la categoría", e);
        }
    }

    /**
     * metodo que actualiza una categoria
     *
     * @param categoria
     * @return devuelve la categoria actualizada
     * @throws PersistenciaException
     */
    @Override
    public Categoria actualizar(Categoria categoria) throws PersistenciaException {
        try {
            //fitlra la busqueda para que coincida con "_id" con el id de categoria
            Bson filtro = Filters.eq("_id", categoria.getId());
            //actualiza el resultado que coincida con el id
            UpdateResult resultado = coleccion.replaceOne(filtro, categoria);
            //sentencia logica que verifica si se hizo la actualizacion
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se actualizó la categoría");
            }
            //devuelve la categoria actualizada
            return categoria;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al actualizar la categoría", e);
        }

    }

    /**
     * metodo que elimina una categoria
     *
     * @param id
     * @throws PersistenciaException
     */
    @Override
    public void eliminar(ObjectId id) throws PersistenciaException {
        try {
            //elimina el resultado que coincida con el id buscado
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", id));
            //sentencia logica para comprobar que se haya eliminado 
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se eliminó la categoría");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al eliminar la categoría", e);
        }
    }

    /**
     * metodo que busca una categoria
     *
     * @param id
     * @return devuelve una categoria encontrada por su id
     * @throws PersistenciaException
     */
    @Override
    public Categoria buscarPorId(ObjectId id) throws PersistenciaException {
        try {
            //devuelve la categoria que coincida con el id escrito
            return coleccion.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar categoría por ID", e);
        }
    }

    /**
     * metodo que devuelve todas las categorias
     *
     * @return devuelve todas las categorias
     * @throws PersistenciaException
     */
    @Override
    public List<Categoria> obtenerTodos() throws PersistenciaException {
        try {
            //devvuelve todas las categorias de la coleccion
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todas las categorías", e);
        }
    }

    /**
     * metodo que busca la categoria por nombre
     *
     * @param nombreParcial
     * @return devuelve la categoria en encontrada por nombre
     * @throws PersistenciaException
     */
    @Override
    public List<Categoria> buscarPorNombre(String nombreParcial) throws PersistenciaException {
        try {
            //filtro que busca por el nombre parcial/completo de la categoria
            //los parametros que tiene sirven para poder buscar con Mayusculas o minisuclas y entre palabras
            Bson filtro = Filters.regex("nombre", ".*" + nombreParcial + ".*", "i");
            //retorna directamente el/los productos que coincidan con el nombre en forma de lista
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar categorias por nombre", e);
        }
    }

}
