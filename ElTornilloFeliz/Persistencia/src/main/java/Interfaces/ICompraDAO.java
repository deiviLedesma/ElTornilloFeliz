/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Compra;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * interfaz DAO para la gestion de compras
 *
 * @author SDavidLedesma
 */
public interface ICompraDAO {

    /**
     * Registra una nueva compra lanza una persistenciaException
     *
     * @param compra
     * @return devuelve la compra realizada 
     * @throws PersistenciaException
     */
    Compra registrarCompra(Compra compra) throws PersistenciaException;

    /**
     * busca compras dentro de un rango de fechas lanza persistenciaException
     *
     * @param inicio
     * @param fin
     * @return devuelve la compra realizada en cierto rango de fechas
     * @throws PersistenciaException
     */
    List<Compra> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException;

    /**
     * busca una compra por su id lanza una persistenciaException
     *
     * @param id
     * @return devuelve la compra encontrada por su id
     * @throws PersistenciaException
     */
    Compra buscarPorId(ObjectId id) throws PersistenciaException;

    /**
     * obtiene todas las compras registradas
     *
     * @return devuelve todas las compras
     * @throws PersistenciaException
     */
    List<Compra> obtenerTodas() throws PersistenciaException;
}
