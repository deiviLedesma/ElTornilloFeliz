/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

import java.util.Date;
import java.util.List;

/**
 * clase que recibe los DTOs de entrada
 *
 * @author SDavidLedesma
 */
public class CrearVenta {

    //atributos
    private String id;
    private String cajaId;
    private List<CrearItemVenta> productos;
    private double total;
    private Date fechaHora;
    private String usuario;

    /**
     * constructor por omision
     */
    public CrearVenta() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param cajaId
     * @param productos
     * @param total
     * @param fechaHora
     * @param usuario
     */
    public CrearVenta(String id, String cajaId, List<CrearItemVenta> productos, double total, Date fechaHora, String usuario) {
        this.id = id;
        this.cajaId = cajaId;
        this.productos = productos;
        this.total = total;
        this.fechaHora = fechaHora;
        this.usuario = usuario;
    }

    //getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCajaId() {
        return cajaId;
    }

    public void setCajaId(String cajaId) {
        this.cajaId = cajaId;
    }

    public List<CrearItemVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<CrearItemVenta> productos) {
        this.productos = productos;
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
        return "CrearVenta{" + "id=" + id + ", cajaId=" + cajaId + ", productos=" + productos + ", total=" + total + ", fechaHora=" + fechaHora + ", usuario=" + usuario + '}';
    }

}
