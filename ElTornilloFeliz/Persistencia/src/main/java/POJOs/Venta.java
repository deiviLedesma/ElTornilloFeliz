/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Representa una venta realizada a un cliente
 *
 * @author SDavidLedesma
 */
public class Venta {

    //Atributos
    private ObjectId id;
    private Date fechaHora;
    private List<ItemVenta> productos;
    private double total;
    private String usuario;

    /**
     * Constructor por omision
     */
    public Venta() {
    }

    /**
     * Constructor que inicializa los atributos
     *
     * @param id
     * @param fechaHora
     * @param productos
     * @param total
     * @param usuario
     */
    public Venta(ObjectId id, Date fechaHora, List<ItemVenta> productos, double total, String usuario) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.productos = productos;
        this.total = total;
        this.usuario = usuario;
    }

    public Venta(Date fechaHora, List<ItemVenta> productos, double total, String usuario) {
        this.fechaHora = fechaHora;
        this.productos = productos;
        this.total = total;
        this.usuario = usuario;
    }

    //getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<ItemVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<ItemVenta> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fechaHora=" + fechaHora + ", productos=" + productos + ", total=" + total + ", usuario=" + usuario + '}';
    }

}
