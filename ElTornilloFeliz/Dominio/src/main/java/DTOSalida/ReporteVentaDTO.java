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
public class ReporteVentaDTO {

    //Atributos
    private String idVenta;
    private String usuario;
    private String caja;
    private double toal;
    private Date fechaHora;

    /**
     * constructor por omision
     */
    public ReporteVentaDTO() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param idVenta
     * @param usuario
     * @param caja
     * @param toal
     * @param fechaHora
     */
    public ReporteVentaDTO(String idVenta, String usuario, String caja, double toal, Date fechaHora) {
        this.idVenta = idVenta;
        this.usuario = usuario;
        this.caja = caja;
        this.toal = toal;
        this.fechaHora = fechaHora;
    }

    //getters y setters
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public double getToal() {
        return toal;
    }

    public void setToal(double toal) {
        this.toal = toal;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "ReporteVentaDTO{" + "idVenta=" + idVenta + ", usuario=" + usuario + ", caja=" + caja + ", toal=" + toal + ", fechaHora=" + fechaHora + '}';
    }

}
