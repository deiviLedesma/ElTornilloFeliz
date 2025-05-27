/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Venta;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * interfaz DAO para la gestion de ventas
 *
 * @author SDavidLedesma
 */
public interface IVentaDAO {

    /**
     * Registra una venta lanza una persistenciaException
     *
     * @param venta
     * @return devuelve la venta registrada
     * @throws PersistenciaException
     */
    Venta registrarVenta(Venta venta) throws PersistenciaException;

    /**
     * obitene las ventas realizadas de un dia en especifico lanza una
     * peresistenciaAException
     *
     * @param fecha
     * @return devuelve todas las ventas de un dia en especifico
     * @throws PersistenciaException
     */
    List<Venta> obtenerVentasDelDia(Date fecha) throws PersistenciaException;

    /**
     * busca las ventas dentro de un rango de fechas lanza una
     * persistenciaException
     *
     * @param inicio
     * @param fin
     * @return devuelve las ventas encontradas por un rango de fechas
     * @throws PersistenciaException
     */
    List<Venta> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException;

    /**
     * busca una venta por su id lanza una persistenciaException
     *
     * @param id
     * @return devuelve una venta encontrada por su id
     * @throws PersistenciaException
     */
    Venta buscarPorId(ObjectId id) throws PersistenciaException;

}
