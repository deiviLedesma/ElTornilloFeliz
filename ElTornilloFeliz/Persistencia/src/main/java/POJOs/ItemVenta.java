/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import org.bson.types.ObjectId;

/**
 * Representa un producto vendido dentro de una venta muestra cantidad avender y
 * precio de venta depende de venta
 *
 * @author SDavidLedesma
 */
public class ItemVenta {

    //atributos
    private ObjectId productoId;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    /**
     * Constructor por omision
     */
    public ItemVenta() {
    }

    /**
     * Constructor que inicializa los atributos
     *
     * @param productoId
     * @param cantidad
     * @param precioUnitario
     * @param subtotal
     */
    public ItemVenta(ObjectId productoId, int cantidad, double precioUnitario, double subtotal) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "ItemVenta{" + "productoId=" + productoId + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + '}';
    }

}
