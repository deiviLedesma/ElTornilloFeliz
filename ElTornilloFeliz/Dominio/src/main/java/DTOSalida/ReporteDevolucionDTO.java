/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

import java.util.Date;

/**
 * clase que muestra los DTOs de salida
 *
 * @author SDavidLedesma
 */
public class ReporteDevolucionDTO {

    //atributos
    private String id;
    private String usuario;
    private String motivo;
    private int cantidadProductos;
    private Date fecha;

    /**
     * constructor por omision
     */
    public ReporteDevolucionDTO() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param usuario
     * @param motivo
     * @param cantidadProductos
     * @param fecha
     */
    public ReporteDevolucionDTO(String id, String usuario, String motivo, int cantidadProductos, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.motivo = motivo;
        this.cantidadProductos = cantidadProductos;
        this.fecha = fecha;
    }

    //getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ReporteDevolucionDTO{" + "id=" + id + ", usuario=" + usuario + ", motivo=" + motivo + ", cantidadProductos=" + cantidadProductos + ", fecha=" + fecha + '}';
    }

}
