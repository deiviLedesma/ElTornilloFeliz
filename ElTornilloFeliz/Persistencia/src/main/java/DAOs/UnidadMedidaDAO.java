/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IUnidadMedida;
import POJOs.UnidadMedida;
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
 * DAO para manejar operaciones CRUD sobre la colección UnidadMedida en MongoDB.
 *
 * @author SDavidLedesma
 */
public class UnidadMedidaDAO implements IUnidadMedida {

    private final MongoCollection<UnidadMedida> coleccion;

    /**
     * Constructor que inicializa la colección de unidades de medida desde la
     * base de datos.
     */
    public UnidadMedidaDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("UnidadMedida", UnidadMedida.class);
    }

    /**
     * metodo que registra la unidad de medida
     *
     * @param unidadMedida
     * @return devuelve la unidad de medida
     * @throws PersistenciaException
     */
    @Override
    public UnidadMedida registrarMedida(UnidadMedida unidadMedida) throws PersistenciaException {
        try {
            //inserta solo uno en la coleccion
            InsertOneResult resultado = coleccion.insertOne(unidadMedida);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("La inserción de la unidad de medida no fue reconocida");
            }
            return unidadMedida;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al insertar la unidad de medida", e);
        }
    }

    /**
     * metodo que actualiza la infrmacion de la unidad de medida
     *
     * @param unidadMedida
     * @return devuelve la unidad de medida actualizada
     * @throws PersistenciaException
     */
    @Override
    public UnidadMedida actualizar(UnidadMedida unidadMedida) throws PersistenciaException {
        try {
            //aplica el fitrlo de "_id" para buscar en base al id 
            Bson filtro = Filters.eq("_id", unidadMedida.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, unidadMedida);
            //sentencia logica para comprobrar que se haya actualizado
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se actualizó la unidad de medida");
            }
            //devuelve la unidad de medida actualizada
            return unidadMedida;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al actualizar la unidad de medida", e);
        }
    }

    /**
     * metodo que elimina una unidad de medida
     *
     * @param id
     * @throws PersistenciaException
     */
    @Override
    public void eliminar(ObjectId id) throws PersistenciaException {
        try {
            //elimina el resultado que sea igual al id proporcionado
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", id));
            //sentencia logica para comprobar que se haya eliminado la unidad de medida
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se eliminó la unidad de medida");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al eliminar la unidad de medida", e);
        }
    }

    /**
     * metodo que busca la unidad de medida por id
     *
     * @param id
     * @return devuelve la unidad de medida encontrada por su id
     * @throws PersistenciaException
     */
    @Override
    public UnidadMedida buscarPorId(ObjectId id) throws PersistenciaException {
        try {
            //busca por filtro "_id" en UnidadMedida y lo devuelve
            return coleccion.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar unidad de medida por ID", e);
        }
    }

    /**
     * metodo que devuelve todas las uniadades de medida
     *
     * @return devuelve todas las unidades de medida
     * @throws PersistenciaException
     */
    @Override
    public List<UnidadMedida> obtenerTodos() throws PersistenciaException {
        try {
            //devuelve todos los datos de la coleccion
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todas las unidades de medida", e);
        }
    }

    @Override
    public List<UnidadMedida> buscarPorNombre(String nombreParcial) throws PersistenciaException {
        try {
            //filtro que busca por el nombre parcial/completo de la unidad de medida
            //los parametros que tiene sirven para poder buscar con Mayusculas o minisuclas y entre palabras
            Bson filtro = Filters.regex("nombre", ".*" + nombreParcial + ".*", "i");
            //retorna directamente el/los productos que coincidan con el nombre en forma de lista
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar unidades de medida por nombre", e);
        }
    }
}
