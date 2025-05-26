/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * Clase que recibe los DTOs de entrada
 *
 * @author SDavidLedesma
 */
public class CrearProducto {

    //atributos
    private String nombre;
    private String descripcion;
    private String categoriaId;
    private String unidadMedidaId;
    private double precioCompra;
    private double precioVenta;
    private int existencias;
    private byte[] imagen;

    /**
     * constructor por omision
     */
    public CrearProducto() {

    }

    /**
     * constructor que incializa los atributos
     * @param nombre
     * @param descripcion
     * @param categoriaId
     * @param unidadMedidaId
     * @param precioCompra
     * @param precioVenta
     * @param existencias
     * @param imagen 
     */
    public CrearProducto(String nombre, String descripcion, String categoriaId, String unidadMedidaId, double precioCompra, double precioVenta, int existencias, byte[] imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoriaId = categoriaId;
        this.unidadMedidaId = unidadMedidaId;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
        this.imagen = imagen;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getUnidadMedidaId() {
        return unidadMedidaId;
    }

    public void setUnidadMedidaId(String unidadMedidaId) {
        this.unidadMedidaId = unidadMedidaId;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "CrearProducto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", categoriaId=" + categoriaId + ", unidadMedidaId=" + unidadMedidaId + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", existencias=" + existencias + ", imagen=" + imagen + '}';
    }

}
