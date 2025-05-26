/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

import java.util.Date;

/**
 * clase que muestra los DTOs de entrada
 *
 * @author SDavidLedesma
 */
public class Caja {

    //atributos
    private String id;
    private Date fechaApertura;
    private double montoInicial;
    private String usuario;
    private Date fechaCierre;
    private double montoFinal;
    private double totalVentas;
    private String observaciones;

    /**
     * constructor por omision
     */
    public Caja() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param fechaApertura
     * @param montoInicial
     * @param usuario
     * @param fechaCierre
     * @param montoFinal
     * @param totalVentas
     * @param observaciones
     */
    public Caja(String id, Date fechaApertura, double montoInicial, String usuario, Date fechaCierre, double montoFinal, double totalVentas, String observaciones) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.montoInicial = montoInicial;
        this.usuario = usuario;
        this.fechaCierre = fechaCierre;
        this.montoFinal = montoFinal;
        this.totalVentas = totalVentas;
        this.observaciones = observaciones;
    }

    //getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Caja{" + "id=" + id + ", fechaApertura=" + fechaApertura + ", montoInicial=" + montoInicial + ", usuario=" + usuario + ", fechaCierre=" + fechaCierre + ", montoFinal=" + montoFinal + ", totalVentas=" + totalVentas + ", observaciones=" + observaciones + '}';
    }

}
