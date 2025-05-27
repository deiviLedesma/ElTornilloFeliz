/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Categoria;
import POJOs.Producto;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz DAO de la gestion de productos en inventario
 *
 * @author SDavidLedesma
 */
public interface IProductoDAO {

    /**
     * inserta un producto en la base de datos lanza una persistenciaException
     *
     * @param producto
     * @return devuelve el producto adquirido
     * @throws PersistenciaException
     */
    Producto insertar(Producto producto) throws PersistenciaException;

    /**
     * Actualiza un producto en la base de datos lanza un persitenciaException
     *
     * @param producto
     * @return devuelve el producto actualizado
     * @throws PersistenciaException
     */
    Producto actualizar(Producto producto) throws PersistenciaException;

    /**
     * Elimina un producto por su id lanza una persistenciaException
     *
     * @param id
     * @throws PersistenciaException
     */
    void eliminar(ObjectId id) throws PersistenciaException;

    /**
     * busca un producto por su id lanza una persistenciaException
     *
     * @param id
     * @return devuelve el producto enconttrado por su id
     * @throws PersistenciaException
     */
    Producto buscarPorId(ObjectId id) throws PersistenciaException;

    /**
     * busca productos por su nombre el cual contiene una cadena parcial lanza
     * una persistenciaException
     *
     * @param nombreParcial
     * @return devuelve el producto encontrado por su nombre
     * @throws PersistenciaException
     */
    List<Producto> buscarPorNombre(String nombreParcial) throws PersistenciaException;

    /**
     * busca productos por su categoria lanza una persistenciaException
     *
     * @param categoria
     * @return devuelve el producto encontrado por su categoria
     * @throws PersistenciaException
     */
    List<Producto> buscarPorCategoria(Categoria categoria) throws PersistenciaException;

    /**
     * obtiene tods los productos insertados lanza una persistenciaException
     *
     * @return devuelve todos los productos
     * @throws PersistenciaException
     */
    List<Producto> obtenerTodos() throws PersistenciaException;

    /**
     * obtiene los productos con existencia por debajo a un umbral del
     * inventario lanza una persistenciaException
     *
     * @param umbral
     * @return devuelve los productos bajos de stock
     * @throws PersistenciaException
     */
    List<Producto> obtenerProductosBajosStock(int umbral) throws PersistenciaException;

}
