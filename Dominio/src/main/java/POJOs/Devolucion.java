/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Representa una devolucion de productos
 *
 * @author SDavidLedesma
 */
public class Devolucion {

    //atributos
    private ObjectId id;
    private Date fecha;
    private String motivo;
    private String usuario;
    private List<ItemDevolucion> productosDevueltos;

    /**
     * Constructor por omision
     */
    public Devolucion() {
    }

    /**
     * Constructor que inicialza los atributos
     *
     * @param id
     * @param fecha
     * @param motivo
     * @param usuario
     * @param productosDevueltos
     */
    public Devolucion(ObjectId id, Date fecha, String motivo, String usuario, List<ItemDevolucion> productosDevueltos) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.usuario = usuario;
        this.productosDevueltos = productosDevueltos;
    }

    //getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<ItemDevolucion> getProductosDevueltos() {
        return productosDevueltos;
    }

    public void setProductosDevueltos(List<ItemDevolucion> productosDevueltos) {
        this.productosDevueltos = productosDevueltos;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "id=" + id + ", fecha=" + fecha + ", motivo=" + motivo + ", usuario=" + usuario + ", productosDevueltos=" + productosDevueltos + '}';
    }

}
