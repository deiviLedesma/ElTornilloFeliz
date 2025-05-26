/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * clase que recibe los DTOs de entrada
 *
 * @author SDavidLedesma
 */
public class CrearItemDevolucion {

    //Atributos
    private String productoId;
    private int cantidad;
    private boolean regresarAInventario;

    /**
     * constructor por omision
     */
    public CrearItemDevolucion() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param productoId
     * @param cantidad
     * @param regresarAInventario
     */
    public CrearItemDevolucion(String productoId, int cantidad, boolean regresarAInventario) {
        this.productoId = productoId;
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
        return "CrearItemDevolucion{" + "productoId=" + productoId + ", cantidad=" + cantidad + ", regresarAInventario=" + regresarAInventario + '}';
    }

}
