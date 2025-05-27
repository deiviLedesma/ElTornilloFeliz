/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Representa una sesión de caja para apertura y cierre de jornada
 *
 * @author SDavidLedesma
 */
public class Caja {

    //atributos
    private ObjectId id;
    private Date fechaApertura;
    private Date fechaCierre;
    private double montoInicial;
    private double montoFinal;
    private String usuario;
    private double totalVentas;
    private String observaciones; //opcional

    /**
     * Constructor por omision
     */
    public Caja() {
    }

    /**
     * constructor que incializa los parametros
     *
     * @param id
     * @param fechaApertura
     * @param fechaCierre
     * @param montoInicial
     * @param montoFinal
     * @param usuario
     * @param totalVentas
     * @param observaciones
     */
    public Caja(ObjectId id, Date fechaApertura, Date fechaCierre, double montoInicial, double montoFinal, String usuario, double totalVentas, String observaciones) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.montoInicial = montoInicial;
        this.montoFinal = montoFinal;
        this.usuario = usuario;
        this.totalVentas = totalVentas;
        this.observaciones = observaciones;
    }

    //getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        return "Caja{" + "id=" + id + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", montoInicial=" + montoInicial + ", montoFinal=" + montoFinal + ", usuario=" + usuario + ", totalVentas=" + totalVentas + ", observaciones=" + observaciones + '}';
    }

}
