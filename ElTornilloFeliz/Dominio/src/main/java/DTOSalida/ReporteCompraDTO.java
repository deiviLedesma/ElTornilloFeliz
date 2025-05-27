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
public class ReporteCompraDTO {

    //atributos
    private String idCompra;
    private String proveedor;
    private double total;
    private Date fechaHora;
    private String usuario;

    public ReporteCompraDTO() {
    }

    public ReporteCompraDTO(String idCompra, String proveedor, double total, Date fechaHora, String usuario) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.total = total;
        this.fechaHora = fechaHora;
        this.usuario = usuario;
    }

    //getters y setters
    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "ReporteCompraDTO{" + "idCompra=" + idCompra + ", proveedor=" + proveedor + ", total=" + total + ", fechaHora=" + fechaHora + ", usuario=" + usuario + '}';
    }

}
