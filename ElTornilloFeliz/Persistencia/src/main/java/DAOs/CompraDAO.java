/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.ICompraDAO;
import POJOs.Compra;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class CompraDAO implements ICompraDAO {

    private final MongoCollection<Compra> coleccion;

    /**
     * constructor que obtiene la coleccion de compras desde la conexion
     */
    public CompraDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Compra", Compra.class);
    }

    /**
     * registra una nueva compra en la base de datos
     *
     * @param compra
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Compra registrarCompra(Compra compra) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(compra);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("La inserción de la compra no fue reconocida por el servidor");
            }

            return compra;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al registrar la compra", e);
        }
    }

    /**
     * busca todas las compras realizadas dentro de un rango de fechas
     *
     * @param inicio
     * @param fin
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Compra> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            //filtro por rango en el campo fechaHora
            Bson filtro = Filters.and(
                    Filters.gte("fechaHora", inicio),
                    Filters.lte("fechaHora", fin)
            );

            //devuelve las compras en forma de lista
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al  buscar compras por rango de fechas", e);
        }
    }

    /**
     * busca una compra especifica por su id
     *
     * @param id
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Compra buscarPorId(ObjectId id) throws PersistenciaException {
        try {
            //filtro por id
            Bson filtro = Filters.eq("_id", id);
            //retorna directamente la compra si existe
            return coleccion.find(filtro).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar la compra por ID");
        }
    }

    /**
     * Obtiene todas las compars registradas en la base de datos
     *
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Compra> obtenerTodas() throws PersistenciaException {
        try {
            //retorna todas las compras en forma de lista
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todas las compras", e);
        }
    }

}
