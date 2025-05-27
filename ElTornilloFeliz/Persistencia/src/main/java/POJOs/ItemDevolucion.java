/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import org.bson.types.ObjectId;

/**
 * Representa un producto devuelto, indicando si regresa a inventario podemos
 * manipular la cantidad de devolucion y confirmar si esta devuelto o no depende
 * de devolucion
 *
 * @author SDavidLedesma
 */
public class ItemDevolucion {

    //atributos
    private ObjectId productoId;
    private int cantidad;
    private boolean regresarAInventario;

    /**
     * Constructor por omision
     */
    public ItemDevolucion() {
    }

    /**
     * Constructor que inicializa los atributos
     *
     * @param productoId
     * @param cantidad
     * @param regresarAInventario
     */
    public ItemDevolucion(ObjectId productoId, int cantidad, boolean regresarAInventario) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.regresarAInventario = regresarAInventario;
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

    public boolean isRegresarAInventario() {
        return regresarAInventario;
    }

    public void setRegresarAInventario(boolean regresarAInventario) {
        this.regresarAInventario = regresarAInventario;
    }

    @Override
    public String toString() {
        return "ItemDevolucion{" + "productoId=" + productoId + ", cantidad=" + cantidad + ", regresarAInventario=" + regresarAInventario + '}';
    }

}
