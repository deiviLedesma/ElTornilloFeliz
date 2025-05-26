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
public class CrearDevolucion {

    //atributos
    private String usuario;
    private String motivo;
    private List<CrearItemDevolucion> productosDevueltos;

    /**
     * constructor por omision
     */
    public CrearDevolucion() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param usuario
     * @param motivo
     * @param productosDevueltos
     */
    public CrearDevolucion(String usuario, String motivo, List<CrearItemDevolucion> productosDevueltos) {
        this.usuario = usuario;
        this.motivo = motivo;
        this.productosDevueltos = productosDevueltos;
    }

    //getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public List<CrearItemDevolucion> getProductosDevueltos() {
        return productosDevueltos;
    }

    public void setProductosDevueltos(List<CrearItemDevolucion> productosDevueltos) {
        this.productosDevueltos = productosDevueltos;
    }

    @Override
    public String toString() {
        return "CrearDevolucion{" + "usuario=" + usuario + ", motivo=" + motivo + ", productosDevueltos=" + productosDevueltos + '}';
    }

}
