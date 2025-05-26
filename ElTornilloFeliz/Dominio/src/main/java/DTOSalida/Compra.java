/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

import DTOEntrada.CrearItemCompra;
import java.util.Date;
import java.util.List;

/**
 * clase que muestra los DTOs de salida
 *
 * @author SDavidLedesma
 */
public class Compra {

    //Atributos
    private String id;
    private String proveedorNombre;
    private List<CrearItemCompra> productos;
    private double total;
    private Date fechaHora;
    private String usuario;

    /**
     * constructor por omision
     */
    public Compra() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param proveedorNombre
     * @param productos
     * @param total
     * @param fechaHora
     * @param usuario
     */
    public Compra(String id, String proveedorNombre, List<CrearItemCompra> productos, double total, Date fechaHora, String usuario) {
        this.id = id;
        this.proveedorNombre = proveedorNombre;
        this.productos = productos;
        this.total = total;
        this.fechaHora = fechaHora;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProveedorNombre() {
        return proveedorNombre;
    }

    public void setProveedorNombre(String proveedorNombre) {
        this.proveedorNombre = proveedorNombre;
    }

    public List<CrearItemCompra> getProductos() {
        return productos;
    }

    public void setProductos(List<CrearItemCompra> productos) {
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
        return "Compra{" + "id=" + id + ", proveedorNombre=" + proveedorNombre + ", productos=" + productos + ", total=" + total + ", fechaHora=" + fechaHora + ", usuario=" + usuario + '}';
    }

}
