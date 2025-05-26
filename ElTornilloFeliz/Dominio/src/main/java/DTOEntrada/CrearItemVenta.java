/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * clase dto que recibe los DTOs de entrada
 *
 * @author SDavidLedesma
 */
public class CrearItemVenta {

    //Atributos
    private String productoId;
    private int cantidad;
    private double precioUnitario;

    /**
     * constructor por omision
     */
    public CrearItemVenta() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param productoId
     * @param cantidad
     * @param precioUnitario
     */
    public CrearItemVenta(String productoId, int cantidad, double precioUnitario) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "CrearItemVenta{" + "productoId=" + productoId + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }

}
