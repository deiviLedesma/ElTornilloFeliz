/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Devolucion;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * interfaz DAO para la gestion de devoluciones de productos o ventas
 *
 * @author SDavidLedesma
 */
public interface IDevolucionDAO {

    /**
     * registra una nueva devolucion lanza una persistenciaException
     *
     * @param devolucion
     * @return retorna la devolucion
     * @throws PersistenciaException
     */
    Devolucion registrarDevolucion(Devolucion devolucion) throws PersistenciaException;

    /**
     * busca devoluciones registradas dentro de un rango de fechas lanza una
     * persistenciaException
     *
     * @param inicio
     * @param fin
     * @return retorna las devoluciones del rango de fechas
     * @throws PersistenciaException
     */
    List<Devolucion> buscarPorRangeFechas(Date inicio, Date fin) throws PersistenciaException;

    /**
     * busca devoluciones realizadas por un usuario en especifico lanza una
     * persistenciaException
     *
     * @param usuario
     * @return retorna las devoluciones hechas por un usuario
     * @throws PersistenciaException
     */
    List<Devolucion> buscarPorUsuario(String usuario) throws PersistenciaException;

    /**
     * busca una devolucion por su id lanza una persistenciaException
     *
     * @param id
     * @return retorna la devolucion por su id
     * @throws PersistenciaException
     */
    Devolucion buscarPorId(ObjectId id) throws PersistenciaException;

}
