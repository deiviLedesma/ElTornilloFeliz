/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Representa una compra realizada a un proveedr
 *
 * @author SDavidLedesma
 */
public class Compra {

    //atributos
    private ObjectId id;
    private Date fechaHora;
    private String proveedor;
    private List<ItemCompra> productos;
    private double total;
    private String usuario;

    /**
     * Constructor por omision
     */
    public Compra() {
    }

    /**
     * Constructor que incializa los atributos
     *
     * @param id
     * @param fechaHora
     * @param proveedor
     * @param productos
     * @param total
     * @param usuario
     */
    public Compra(ObjectId id, Date fechaHora, String proveedor, List<ItemCompra> productos, double total, String usuario) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.proveedor = proveedor;
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public List<ItemCompra> getProductos() {
        return productos;
    }

    public void setProductos(List<ItemCompra> productos) {
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
        return "Compra{" + "id=" + id + ", fechaHora=" + fechaHora + ", proveedor=" + proveedor + ", productos=" + productos + ", total=" + total + ", usuario=" + usuario + '}';
    }

}
