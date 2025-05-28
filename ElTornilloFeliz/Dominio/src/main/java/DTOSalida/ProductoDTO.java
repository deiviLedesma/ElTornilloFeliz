/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

/**
 * Clase que muestra los DTOs de salida
 *
 * @author SDavidLedesma
 */
public class ProductoDTO {

    //atributos
    private String id;
    private String nombre;
    private String desccripcion;
    private String categoria;
    private String unidadMedida;
    private double precioCompra;
    private double precioVenta;
    private int existencias;
    private byte[] iamgen;

    /**
     * constructor por omision
     */
    public ProductoDTO() {

    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param nombre
     * @param desccripcion
     * @param categoria
     * @param unidadMedida
     * @param precioCompra
     * @param precioVenta
     * @param existencias
     * @param iamgen
     */
    public ProductoDTO(String id, String nombre, String desccripcion, String categoria, String unidadMedida, double precioCompra, double precioVenta, int existencias, byte[] iamgen) {
        this.id = id;
        this.nombre = nombre;
        this.desccripcion = desccripcion;
        this.categoria = categoria;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
        this.iamgen = iamgen;
    }

    //getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesccripcion() {
        return desccripcion;
    }

    public void setDesccripcion(String desccripcion) {
        this.desccripcion = desccripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
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

    public byte[] getIamgen() {
        return iamgen;
    }

    public void setIamgen(byte[] iamgen) {
        this.iamgen = iamgen;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" + "id=" + id + ", nombre=" + nombre + ", desccripcion=" + desccripcion + ", categoria=" + categoria + ", unidadMedida=" + unidadMedida + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", existencias=" + existencias + ", iamgen=" + iamgen + '}';
    }

}
