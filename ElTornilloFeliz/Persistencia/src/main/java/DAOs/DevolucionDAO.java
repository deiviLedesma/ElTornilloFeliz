/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.Conexion;
import DTOSalida.ReporteDevolucionDTO;
import Excepcion.PersistenciaException;
import Interfaces.IDevolucionDAO;
import POJOs.Caja;
import POJOs.Devolucion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
public class DevolucionDAO implements IDevolucionDAO {

    private MongoCollection<Devolucion> coleccion;

    /**
     * constructor que inicializa la coleccion de devoluciones desde la base de
     * datos
     *
     * @param database
     */
    public DevolucionDAO(MongoDatabase database) {
        this.coleccion = Conexion.getDatabase().getCollection("devoluciones", Devolucion.class);
    }

    // Constructor alternativo para pruebas
    public DevolucionDAO(MongoCollection<Devolucion> coleccionMock) {
        this.coleccion = coleccionMock;
    }

    /**
     * regista una neva devolucion en la base de datos
     *
     * @param devolucion
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Devolucion registrarDevolucion(Devolucion devolucion) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(devolucion);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("La insercion de la devolucion no fue reconocida por el servidor");
            }

            return devolucion;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al registrar la devolucion", e);
        }
    }

    /**
     * busca todas las devoluciones registradas dentro de un rango de fechas
     *
     * @param inicio
     * @param fin
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Devolucion> buscarPorRangeFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            //filtro por rango en el campo fecha
            Bson filtro = Filters.and(
                    Filters.gte("fecha", inicio),
                    Filters.lte("fecha", fin)
            );
            //retorna directamente las devoluciones en forma de lista
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar devoluciones por rango de fechas", e);
        }
    }

    /**
     * busca todas las devoluciones realizadas por un usuario en especifico
     *
     * @param usuario
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Devolucion> buscarPorUsuario(String usuario) throws PersistenciaException {
        try {
            //filtro por nombre de usuario
            Bson filtro = Filters.eq("usuario", usuario);
            //devuelve directamente las devoluciones por usuario en forma de lista
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error all buscar devoluciones por usuario", e);
        }
    }

    /**
     * busca una devolucion por su id
     *
     * @param id
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Devolucion buscarPorId(ObjectId id) throws PersistenciaException {
        try {
            //filtro por su id
            Bson filtro = Filters.eq("_id", id);
            //devuelve directamente la devolucion por su id
            return coleccion.find(filtro).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar la devolucion por ID", e);
        }
    }

    /**
     * Genera un reporte de devoluciones realizadas entre dos fechas.
     *
     * @param inicio Fecha de inicio del rango.
     * @param fin Fecha de fin del rango.
     * @return Lista de devoluciones como DTOs.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<ReporteDevolucionDTO> generarReporteDevolucionesPorFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            Bson filtro = Filters.and(
                    Filters.gte("fecha", inicio),
                    Filters.lte("fecha", fin)
            );

            List<ReporteDevolucionDTO> reporte = new ArrayList<>();
            for (Devolucion devolucion : coleccion.find(filtro)) {
                ReporteDevolucionDTO dto = new ReporteDevolucionDTO();
                dto.setId(devolucion.getId().toHexString());
                dto.setUsuario(devolucion.getUsuario());
                dto.setMotivo(devolucion.getMotivo());
                dto.setCantidadProductos(devolucion.getProductosDevueltos().size());
                dto.setFecha(devolucion.getFecha());
                reporte.add(dto);
            }

            return reporte;
        } catch (Exception e) {
            throw new PersistenciaException("Error al generar reporte de devoluciones", e);
        }
    }

}
