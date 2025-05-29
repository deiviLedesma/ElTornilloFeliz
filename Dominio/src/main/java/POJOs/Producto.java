/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import org.bson.types.ObjectId;

/**
 * Representa un producto del inventario de la ferreteria
 *
 * @author SDavidLedesma
 */
public class Producto {

    //atributos
    private ObjectId id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private UnidadMedida unidadMedida;
    private double precioCompra;
    private double precioVenta;
    private int existencias;
    private byte[] imagen;

    /**
     * Constructor por omision
     */
    public Producto() {
    }

    /**
     * Constructor que inicializa los atributos
     *
     * @param id
     * @param nombre
     * @param descripcion
     * @param categoria
     * @param unidadMedida
     * @param precioCompra
     * @param precioVenta
     * @param existencias
     * @param imagen
     */
    public Producto(ObjectId id, String nombre, String descripcion, Categoria categoria, UnidadMedida unidadMedida, double precioCompra, double precioVenta, int existencias, byte[] imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
        this.imagen = imagen;
    }

    public Producto(String nombre, String descripcion, Categoria categoria, UnidadMedida unidadMedida, double precioCompra, double precioVenta, int existencias, byte[] imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
        this.imagen = imagen;
    }

    //getter y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
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
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", unidadMedida=" + unidadMedida + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", existencias=" + existencias + ", imagen=" + imagen + '}';
    }

}
