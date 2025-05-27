/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Caja;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz DAO para la gestion de caJas (apertura y cierre diario)
 *
 * @author SDavidLedesma
 */
public interface ICajaDAO {

    /**
     * Registra la apertura de una caja lanza persistenciaException
     *
     * @param caja
     * @return devuelve la creacion de la caja
     * @throws PersistenciaException
     */
    Caja abrirCaja(Caja caja) throws PersistenciaException;

    /**
     * Registra el cierre de una caja existente lanza persistenciaException
     *
     * @param id
     * @param datosCierre
     * @throws PersistenciaException
     */
    void cerrarCaja(ObjectId id, Caja datosCierre) throws PersistenciaException;

    /**
     * obtiene la caja abierta por un usuario persistenciaException
     *
     * @param usuario
     * @return devuelve la caja abierta
     * @throws PersistenciaException
     */
    Caja obtenerCajaAbierta(String usuario) throws PersistenciaException;

    /**
     * busca cajas abiertas o cerradas dentro de un rango de fechas lanza una
     * persistenciaException
     *
     * @param inicio
     * @param fin
     * @return devuelve las cajas abiertas/cerradas de un rango de fechas
     * @throws PersistenciaException
     */
    List<Caja> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException;

    /**
     * busca una caja por su id lanza una persistenciaException
     *
     * @param id
     * @return devuelve la caja encontrada por su id
     * @throws PersistenciaException
     */
    Caja buscarPorId(ObjectId id) throws PersistenciaException;

    /**
     * actualiza que un usuario pueda estar en una caja ya existente, es de
     * decir que simula cambios de usuario en cajas activas
     *
     * @param id
     * @param nuevoUsuario
     * @throws PersistenciaException
     */
    void actualizarUsuarioEnCaja(ObjectId id, String nuevoUsuario) throws PersistenciaException;
}
