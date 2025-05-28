/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.Conexion;
import DTOSalida.ReporteCajaDTO;
import Excepcion.PersistenciaException;
import Interfaces.ICajaDAO;
import POJOs.Caja;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class CajaDAO implements ICajaDAO {

    private final MongoCollection<Caja> coleccion;

    /**
     * constructor que obtiene la coleccion de caja desde la conexion
     */
    public CajaDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Caja", Caja.class);
    }

    // Constructor alternativo para pruebas
    public CajaDAO(MongoCollection<Caja> coleccionMock) {
        this.coleccion = coleccionMock;
    }

    @Override
    public Caja abrirCaja(Caja caja) throws PersistenciaException {
        //validar que no exista ya una caja abierta para el usaurio
        if (obtenerCajaAbierta(caja.getUsuario()) != null) {
            throw new PersistenciaException("El USAURIO " + caja.getUsuario() + " ya tiene una caja abierta");
        }

        try {
            //insertar la nueva caja
            InsertOneResult resultado = coleccion.insertOne(caja);
            //verifica que el servidor reconocio la operacion
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("La insercion no fue reconocida por el servidor");
            }

            return caja;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Erro al insertar la caja", e);
        }
    }

    /**
     * Cierra la caja identificada por su ObjectId, siempre que este abierta
     * Actualiza los campos de cierre
     *
     * @param id
     * @param datosCierre
     * @throws PersistenciaException
     */
    @Override
    public void cerrarCaja(ObjectId id, Caja datosCierre) throws PersistenciaException {
        /**
         * Valida que la caja aun este abierta (sin fecha de cierre)
         */
        Bson filtro = Filters.and(
                Filters.eq("_id", id),
                Filters.eq("fechaCierre", null)// caja abierta
        );

        /**
         * define los camos que se actualizan al cerrar la caja
         */
        Bson actualizacion = Updates.combine(
                Updates.set("fechaCierre", datosCierre.getFechaCierre()),
                Updates.set("montoFinal", datosCierre.getMontoFinal()),
                Updates.set("totalVentas", datosCierre.getTotalVentas()),
                Updates.set("observaciones", datosCierre.getObservaciones())
        );

        /**
         * ejecuta la actualiacoin en mongo
         */
        UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);

        /**
         * verifica si la caja fue modificada correctamente
         */
        if (resultado.getModifiedCount() == 0) {
            throw new PersistenciaException("No se pudo cerrar la caja. Verifica que este abierta y exista");
        }
    }

    /**
     * obtiene la caja actualmente abierta
     *
     * @return la caja abierta
     * @throws PersistenciaException
     */
    @Override
    public Caja obtenerCajaAbierta(String usuario) throws PersistenciaException {
        try {
            //construye el filtro para buscar una caja que aun no tenga fecha de cierre
            Bson filtro = Filters.and(
                    Filters.eq("fechaCierre", null), //caja abierta
                    Filters.eq("usuario", usuario)); //usaurio en caja

            //busca directamente y devuelve la caja
            return coleccion.find(filtro).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obteners la caja abierta", e);
        }
    }

    /**
     * busca todas las cajas cuya fecha de apertura este dentro del rango
     * indicado
     *
     * @param inicio
     * @param fin
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Caja> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            //filtro por rango en el campo fechaApertura
            Bson filtro = Filters.and(
                    Filters.gte("fechaApertura", inicio),
                    Filters.lte("fechaApertura", fin)
            );
            //aejecuta la consulta y devuelve los resultados como lista de caja
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar cajas por rango de fechas", e);
        }
        //uso List<Caja> resultado = cajaDAO.buscarPorRangoFechas(
        //new SimpleDateFormat("yyyy-MM-dd").parse("2025-05-01"),
        //new SimpleDateFormat("yyyy-MM-dd").parse("2025-05-20")
    }

    /**
     * busca una caja en especifico por su id
     *
     * @param id
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Caja buscarPorId(ObjectId id) throws PersistenciaException {
        try {
            //filtro por id
            Bson filtro = Filters.eq("_id", id);

            //retorna directamente la caja si existe
            return coleccion.find(filtro).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar la caja por ID", e);
        }
    }

    /**
     * permite que un usuario pueda estar en cualquier caja previamente creada
     *
     * @param id
     * @param nuevoUsuario
     * @throws PersistenciaException
     */
    @Override
    public void actualizarUsuarioEnCaja(ObjectId id, String nuevoUsuario) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", id);
            Bson actualizacion = Updates.set("usuario", nuevoUsuario);
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se pudo actualizar el usaurio de la caja");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error en cambio de usuario en caja del servidor", e);
        }
    }

    /**
     * Genera un reporte de cajas abiertas o cerradas entre fechas.
     *
     * @param inicio Fecha de inicio del rango.
     * @param fin Fecha de fin del rango.
     * @return Lista de cajas encontradas como DTOs.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<ReporteCajaDTO> generarReporteCajasPorFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            Bson filtro = Filters.and(
                    Filters.gte("fechaApertura", inicio),
                    Filters.lte("fechaApertura", fin)
            );

            List<ReporteCajaDTO> reporte = new ArrayList<>();
            for (Caja caja : coleccion.find(filtro)) {
                ReporteCajaDTO dto = new ReporteCajaDTO();
                dto.setId(caja.getId().toHexString());
                dto.setUsuario(caja.getUsuario());
                dto.setFechaApertura(caja.getFechaApertura());
                dto.setFechaCierre(caja.getFechaCierre());
                dto.setMontoInicial(caja.getMontoInicial());
                dto.setMontoFinal(caja.getMontoFinal());
                dto.setTotalVentas(caja.getTotalVentas());
                reporte.add(dto);
            }

            return reporte;
        } catch (Exception e) {
            throw new PersistenciaException("Error al generar reporte de cajas", e);
        }
    }

}
