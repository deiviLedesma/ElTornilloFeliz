/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IVentaDAO;
import POJOs.Venta;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class VentaDAO implements IVentaDAO {

    private final MongoCollection<Venta> coleccion;

    /**
     * Constructor que inicializa la colección de ventas desde la base de datos.
     */
    public VentaDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Venta", Venta.class);
    }

    /**
     * Registra una nueva venta en la base de datos.
     *
     * @param venta La venta a registrar.
     * @return La venta registrada.
     * @throws PersistenciaException Si ocurre un error durante el registro.
     */
    @Override
    public Venta registrarVenta(Venta venta) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(venta);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("La inserción de la venta no fue reconocida por el servidor");
            }
            return venta;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al registrar la venta", e);
        }
    }

    /**
     * Obtiene todas las ventas realizadas en una fecha específica.
     *
     * @param fecha La fecha a consultar
     * @return Lista de ventas realizadas en la fecha indicada
     * @throws PersistenciaException Si ocurre un error durante la consulta
     */
    @Override
    public List<Venta> obtenerVentasDelDia(Date fecha) throws PersistenciaException {
        try {
            //convierte date a LocalDate
            LocalDate localDate = fecha.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            //crea los limites del dia en localDateTime
            LocalDateTime inicio = localDate.atStartOfDay(); // 00:00:00
            LocalDateTime fin = localDate.atTime(23, 59, 59); //23:59:59

            //convierte a date para que mongo lo pueda procesar
            Date inicioDia = Date.from(inicio.atZone(ZoneId.systemDefault()).toInstant());
            Date finDia = Date.from(fin.atZone(ZoneId.systemDefault()).toInstant());

            //Filtro por rango del dia
            Bson filtro = Filters.and(
                    Filters.gte("fechaHora", inicioDia),
                    Filters.lte("fechaHora", finDia)
            );

            return coleccion.find(filtro).into(new ArrayList<>());

        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener las ventas del dia");
        }
    }

    /**
     * Busca todas las ventas dentro de un rango de fechas.
     *
     * @param inicio Fecha de inicio del rango
     * @param fin Fecha de fin del rango
     * @return Lista de ventas en el rango especificado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda
     */
    @Override
    public List<Venta> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            Bson filtro = Filters.and(
                    Filters.gte("fechaHora", inicio),
                    Filters.lte("fechaHora", fin)
            );

            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar ventas por rango de fechas", e);
        }
    }

    /**
     * Busca una venta por su ID
     *
     * @param id ID de la venta
     * @return Venta encontrada o null si no existe
     * @throws PersistenciaException Si ocurre un error durante la búsqueda
     */
    @Override
    public Venta buscarPorId(ObjectId id) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", id);
            return coleccion.find(filtro).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar la venta por ID", e);
        }
    }
}
