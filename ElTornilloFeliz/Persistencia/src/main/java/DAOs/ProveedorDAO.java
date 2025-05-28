/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IProveedorDAO;
import POJOs.Proveedor;
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
 * DAO para manejar operaciones CRUD sobre la colección Proveedor en MongoDB.
 *
 * @author SDavidLedesma
 */
public class ProveedorDAO implements IProveedorDAO {

    private final MongoCollection<Proveedor> coleccion;

    /**
     * Constructor que inicializa la colección de proveedores desde la conexion
     */
    public ProveedorDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Proveedor", Proveedor.class);
    }

    /**
     * metodo que registra un nuevo proveedor
     *
     * @param proveedor
     * @return devuelve el nuevo proveedor registrado
     * @throws PersistenciaException
     */
    @Override
    public Proveedor registrarProveedor(Proveedor proveedor) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(proveedor);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("La inserción del proveedor no fue reconocida");
            }
            return proveedor;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al insertar el proveedor", e);
        }
    }

    /**
     * metodo que actualiza un proveedor
     *
     * @param proveedor
     * @return devuelve el proveedor actualizado
     * @throws PersistenciaException
     */
    @Override
    public Proveedor actualizar(Proveedor proveedor) throws PersistenciaException {
        try {
            //filtro para busqueda del proveedor por "_id"
            Bson filtro = Filters.eq("_id", proveedor.getId());
            //actualiza el proveedor de ser encontrado
            UpdateResult resultado = coleccion.replaceOne(filtro, proveedor);
            //sentencia logica que verifica si se realizo la actualizacion
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se actualizó el proveedor");
            }
            //devuelve el proveedor actualizado
            return proveedor;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al actualizar el proveedor", e);
        }
    }

    /**
     * metodo que elimina un proveedor
     *
     * @param id
     * @throws PersistenciaException
     */
    @Override
    public void eliminar(ObjectId id) throws PersistenciaException {
        try {
            //elimina el resultado que coincida con el id
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", id));
            //sentencia logica que veirfica si se elimino
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se eliminó el proveedor");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar el proveedor", e);
        }
    }

    /**
     * metodo que busca a un proveedor por su id
     *
     * @param id
     * @return devuelve un proveedor encontrado por su id
     * @throws PersistenciaException
     */
    @Override
    public Proveedor buscarPorId(ObjectId id) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar proveedor por ID", e);
        }
    }

    /**
     * metodo que busca un proveedor por su nombre
     *
     * @param nombreParcial
     * @return devuelve un proveedor que coincida con el nombre
     * @throws PersistenciaException
     */
    @Override
    public List<Proveedor> buscarPorNombre(String nombreParcial) throws PersistenciaException {
        try {
            //filtroq ue busca la semejancia del nombre escrito con el del nombre del proveeodr
            Bson filtro = Filters.regex("nombre", ".*" + nombreParcial + ".*", "i");
            //devuelve todos los nombres que coincidan
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar proveedores por nombre", e);
        }
    }

    /**
     * metodo que devuelve todos los proveedores
     *
     * @return devuelve todos los proveedores
     * @throws PersistenciaException
     */
    @Override
    public List<Proveedor> obtenerTodos() throws PersistenciaException {
        try {
            //devuelve todos los proveedores que existan en la coleccion
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los proveedores", e);
        }
    }
}
