/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IProductoDAO;
import POJOs.Categoria;
import POJOs.Producto;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class ProductoDAO implements IProductoDAO {

    private MongoCollection<Producto> coleccion;

    /**
     * constructor que inicializa la coleccion de productos desde la base de
     * datos
     *
     *
     */
    public ProductoDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Producto", Producto.class);
    }

    @Override
    public Producto insertar(Producto producto) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(producto);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("La insercion de el producto no fue reconocida por el servidor");
            }

            return producto;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al registrar el producto", e);
        }
    }

    /**
     * actualiza un producto existente en la base de datos
     *
     * @param producto
     * @throws PersistenciaException
     */
    @Override
    public Producto actualizar(Producto producto) throws PersistenciaException {
        try {
            //filtro que obtiene el el id del producto
            Bson filtro = Filters.eq("_id", producto.getId());

            Bson actualizacion = Updates.combine(
                    Updates.set("nombre", producto.getNombre()),
                    Updates.set("descripcion", producto.getDescripcion()),
                    Updates.set("precioCompra", producto.getPrecioCompra()),
                    Updates.set("precioVenta", producto.getPrecioVenta()),
                    Updates.set("existencias", producto.getExistencias()),
                    Updates.set("categoria", producto.getCategoria()),
                    Updates.set("unidadMedida", producto.getUnidadMedida()),
                    Updates.set("imagen", producto.getImagen())
            );

            //encuentra  el producto del id y lo actualiza
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);

            //verifica si sse modifico algun documento
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se pudo actualizar el producto");
            }

            //retorna producto actualizado
            return producto;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al actualizar el producto", e);
        }

    }

    /**
     * elimina un producto por su id
     *
     * @param id
     * @throws PersistenciaException
     */
    @Override
    public void eliminar(ObjectId id) throws PersistenciaException {
        try {
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", id));

            //verifica si se elimino el producto
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se pudo eliminar el producto");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al eliminar el producto", e);
        }
    }

    /**
     * Busca un producto por su id
     *
     * @param id
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Producto buscarPorId(ObjectId id) throws PersistenciaException {
        try {
            //retorna directamente el producto igual al del id
            return coleccion.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar el producto por id", e);
        }
    }

    /**
     * busca productos el cual coincida con el nombre
     *
     * @param nombreParcial
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Producto> buscarPorNombre(String nombreParcial) throws PersistenciaException {
        try {
            //filtro que busca por el nombre parcial/completo del producto
            //los parametros que tiene sirven para poder buscar con Mayusculas o minisuclas y entre palabras
            //ejemplo si escribe "ma" mostrara Martilllo, desarmador, etc
            Bson filtro = Filters.regex("nombre", ".*" + nombreParcial + ".*", "i");
            //retorna directamente el/los productos que coincidan con el nombre en forma de lista
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar productos por nombre", e);
        }
    }

    /**
     * busca productos por su categoria
     *
     * @param categoria
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Producto> buscarPorCategoria(Categoria categoria) throws PersistenciaException {
        try {
            //filtro por su categira
            Bson filtro = Filters.eq("categoria", categoria);
            //retorna directamente los productos los cuales coincidan con la categoria en forma de lista
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar productos por su categoria", e);
        }
    }

    /**
     * devuelve todos los productos registrados
     *
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Producto> obtenerTodos() throws PersistenciaException {
        try {
            //retorna todos los productos en forma de lista
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los productos", e);
        }
    }

    /**
     * obtiene los productos que sean menor o igual al umbral del inventario
     * especificado este metodo funciona para la accion de realizar pedidos
     *
     * @param umbral
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Producto> obtenerProductosBajosStock(int umbral) throws PersistenciaException {
        try {
            //filtro de si es menor o igual al stock
            Bson filtro = Filters.lte("existencias", umbral);
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar productos con bajo stock", e);
        }
    }

}
