/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Categoria;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * interfaz DAO de la gestion de categorias en productos
 *
 * @author SDavidLedesma
 */
public interface ICategoriaDAO {

    /**
     * registra una nueva categoria
     *
     * @param categoria
     * @return devuelve la categoria creada
     * @throws PersistenciaException
     */
    Categoria registrarCaregoria(Categoria categoria) throws PersistenciaException;

    /**
     * actualiza el nombre de la categoria
     *
     * @param categoria
     * @return devuelve la categoria actualizada
     * @throws PersistenciaException
     */
    Categoria actualizar(Categoria categoria) throws PersistenciaException;

    /**
     * Elimina una categoria
     *
     * @param id
     * @throws PersistenciaException
     */
    void eliminar(ObjectId id) throws PersistenciaException;

    /**
     * busca una categoria por su id
     *
     * @param id
     * @return devuelve la categoria encontrada por el id
     * @throws PersistenciaException
     */
    Categoria buscarPorId(ObjectId id) throws PersistenciaException;

    /**
     * busca una categoria por su nombre
     *
     * @param nombreParcial
     * @return devuelve la categoria encontrada por el nombre
     * @throws PersistenciaException
     */
    List<Categoria> buscarPorNombre(String nombreParcial) throws PersistenciaException;

    /**
     * muestra todos las categorias
     *
     * @return devuelve todas las categorias
     * @throws PersistenciaException
     */
    List<Categoria> obtenerTodos() throws PersistenciaException;
}
