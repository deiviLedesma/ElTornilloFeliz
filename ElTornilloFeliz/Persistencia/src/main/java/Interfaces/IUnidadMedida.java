/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.UnidadMedida;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * interfaz DAO para la gestion de unidades de medida en los productos
 *
 * @author SDavidLedesma
 */
public interface IUnidadMedida {

    /**
     * registra una nueva unidad de medida
     *
     * @param unidadMedida
     * @return devuelve la unidad de medida creada
     * @throws PersistenciaException
     */
    UnidadMedida registrarMedida(UnidadMedida unidadMedida) throws PersistenciaException;

    /**
     * actualiza la unidad de medida
     *
     * @param unidadMedida
     * @return devuelve la unidad de medida actualizada
     * @throws PersistenciaException
     */
    UnidadMedida actualizar(UnidadMedida unidadMedida) throws PersistenciaException;

    /**
     * elimina una unidad de medida
     *
     * @param id
     * @throws PersistenciaException
     */
    void eliminar(ObjectId id) throws PersistenciaException;

    /**
     * busca una medida por su id
     *
     * @param id
     * @return devuelve la medida encontrada por su id
     * @throws PersistenciaException
     */
    UnidadMedida buscarPorId(ObjectId id) throws PersistenciaException;

    /**
     * busca una unidad de medida por nombre
     *
     * @param nombreParcial
     * @return devuelve la medida encontrada por nombre
     * @throws PersistenciaException
     */
    List<UnidadMedida> buscarPorNombre(String nombreParcial) throws PersistenciaException;

    /**
     * muestra todas las unidades de medida
     *
     * @return devuelve todas las unidades de medida
     * @throws PersistenciaException
     */
    List<UnidadMedida> obtenerTodos() throws PersistenciaException;

}
