/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

import java.util.Date;

/**
 * constructor que meustra los DTOs de salida
 *
 * @author SDavidLedesma
 */
public class ReporteCajaDTO {

    //atributos
    private String id;
    private String usuario;
    private Date fechaApertura;
    private Date fechaCierre;
    private double montoInicial;
    private double montoFinal;
    private double totalVentas;

    /**
     * constructor por omision
     */
    public ReporteCajaDTO() {
    }

    /**
     * constructor que incializa los atributos
     *
     * @param id
     * @param usuario
     * @param fechaApertura
     * @param fechaCierre
     * @param montoInicial
     * @param montoFinal
     * @param totalVentas
     */
    public ReporteCajaDTO(String id, String usuario, Date fechaApertura, Date fechaCierre, double montoInicial, double montoFinal, double totalVentas) {
        this.id = id;
        this.usuario = usuario;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.montoInicial = montoInicial;
        this.montoFinal = montoFinal;
        this.totalVentas = totalVentas;
    }

    //getters  y setters
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

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    @Override
    public String toString() {
        return "ReporteCajaDTO{" + "id=" + id + ", usuario=" + usuario + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", montoInicial=" + montoInicial + ", montoFinal=" + montoFinal + ", totalVentas=" + totalVentas + '}';
    }

}
