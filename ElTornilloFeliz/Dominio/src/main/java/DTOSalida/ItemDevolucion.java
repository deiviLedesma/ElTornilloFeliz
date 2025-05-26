/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

/**
 * clase que muestra los DTOs de salida
 *
 * @author SDavidLedesma
 */
public class ItemDevolucion {

    //Atributos
    private String productoId;
    private String nombreProducto;
    private int cantidad;
    private boolean regresarAInventario;

    /**
     * constructor por omision
     */
    public ItemDevolucion() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param productoId
     * @param nombreProducto
     * @param cantidad
     * @param regresarAInventario
     */
    public ItemDevolucion(String productoId, String nombreProducto, int cantidad, boolean regresarAInventario) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.regresarAInventario = regresarAInventario;
    }

    //getters y setters
    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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
        return "ItemDevolucion{" + "productoId=" + productoId + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", regresarAInventario=" + regresarAInventario + '}';
    }

}
