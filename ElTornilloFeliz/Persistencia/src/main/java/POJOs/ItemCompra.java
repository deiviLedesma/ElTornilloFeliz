/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import org.bson.types.ObjectId;

/**
 * Representa el producto de una compra
 *
 * Esta clase funciona para indicar cantiades de compra precio de compra Depende
 * de compra
 *
 * @author SDavidLedesma
 */
public class ItemCompra {

    //atributos
    private ObjectId productoId;
    private int cantidad;
    private double precioUnitario;

    /**
     * Constructor por omision
     */
    public ItemCompra() {
    }

    /**
     * Constructor que inicialaza los atributos
     *
     * @param productoId
     * @param cantidad
     * @param precioUnitario
     */
    public ItemCompra(ObjectId productoId, int cantidad, double precioUnitario) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    //getters y setters
    public ObjectId getProductoId() {
        return productoId;
    }

    public void setProductoId(ObjectId productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "ItemCompra{" + "productoId=" + productoId + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }

}
