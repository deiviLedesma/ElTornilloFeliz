/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Proveedor;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * interfaz DAO para la gestion de proveedores
 *
 * @author SDavidLedesma
 */
public interface IProveedorDAO {

    /**
     *
     * @param proveedor
     * @return devuelve el proveedor registrado
     * @throws PersistenciaException
     */
    Proveedor registrarProveedor(Proveedor proveedor) throws PersistenciaException;

    /**
     * actualiza un proveedor
     *
     * @param proveedor
     * @return devuelve el proveedora actualizado
     * @throws PersistenciaException
     */
    Proveedor actualizar(Proveedor proveedor) throws PersistenciaException;

    /**
     * elimina un proveedor
     *
     * @param id
     * @throws PersistenciaException
     */
    void eliminar(ObjectId id) throws PersistenciaException;

    /**
     * busca un proveedor que coincida con el id
     *
     * @param id
     * @return devuelve al proveedor encontrado por id
     * @throws PersistenciaException
     */
    Proveedor buscarPorId(ObjectId id) throws PersistenciaException;

    /**
     * busca un proveedor por su nombre
     *
     * @param nombreParcial
     * @return devuelve al proveedor encontrado por el nombre
     * @throws PersistenciaException
     */
    List<Proveedor> buscarPorNombre(String nombreParcial) throws PersistenciaException;

    /**
     * muestra todos los provedores
     *
     * @return devuelve todos los proveedores
     * @throws PersistenciaException
     */
    List<Proveedor> obtenerTodos() throws PersistenciaException;
}
