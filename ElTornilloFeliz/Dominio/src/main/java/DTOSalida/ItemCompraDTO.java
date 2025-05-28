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
public class ItemCompraDTO {

    //atributos
    private String productoId;
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    /**
     * constructor por omision
     */
    public ItemCompraDTO() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param productoId
     * @param nombreProducto
     * @param cantidad
     * @param precioUnitario
     * @param subtotal
     */
    public ItemCompraDTO(String productoId, String nombreProducto, int cantidad, double precioUnitario, double subtotal) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
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
        return "ItemCompraDTO{" + "productoId=" + productoId + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + '}';
    }

}
