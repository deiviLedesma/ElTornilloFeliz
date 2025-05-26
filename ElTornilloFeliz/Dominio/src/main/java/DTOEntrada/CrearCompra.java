/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

import java.util.List;

/**
 * clase que recibe los DTOs de entrada
 *
 * @author SDavidLedesma
 */
public class CrearCompra {

    //atributos
    private String proveedorId;
    private List<CrearItemCompra> productos;
    private String usuario;

    /**
     * constructor por omision
     */
    public CrearCompra() {
    }

    /**
     * constructor que inicializa losa atributos
     *
     * @param proveedorId
     * @param productos
     * @param usuario
     */
    public CrearCompra(String proveedorId, List<CrearItemCompra> productos, String usuario) {
        this.proveedorId = proveedorId;
        this.productos = productos;
        this.usuario = usuario;
    }

    //getters y setters
    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    public List<CrearItemCompra> getProductos() {
        return productos;
    }

    public void setProductos(List<CrearItemCompra> productos) {
        this.productos = productos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "CrearCompra{" + "proveedorId=" + proveedorId + ", productos=" + productos + ", usuario=" + usuario + '}';
    }

}
