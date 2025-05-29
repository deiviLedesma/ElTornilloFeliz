/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

import DTOEntrada.CrearItemDevolucion;
import java.util.Date;
import java.util.List;

/**
 * clase que muestra los DTOs de salida
 *
 * @author SDavidLedesma
 */
public class DevolucionDTO {

    //Atributos
    private String id;
    private String usuario;
    private String motivo;
    private Date fecha;
    private List<ItemDevolucionDTO> productosDevueltos;

    /**
     * constructor por omision
     */
    public DevolucionDTO() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param usuario
     * @param motivo
     * @param fecha
     * @param productosDevueltos
     */
    public DevolucionDTO(String id, String usuario, String motivo, Date fecha, List<ItemDevolucionDTO> productosDevueltos) {
        this.id = id;
        this.usuario = usuario;
        this.motivo = motivo;
        this.fecha = fecha;
        this.productosDevueltos = productosDevueltos;
    }

    //getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<ItemDevolucionDTO> getProductosDevueltos() {
        return productosDevueltos;
    }

    public void setProductosDevueltos(List<ItemDevolucionDTO> productosDevueltos) {
        this.productosDevueltos = productosDevueltos;
    }

    @Override
    public String toString() {
        return "DevolucionDTO{" + "id=" + id + ", usuario=" + usuario + ", motivo=" + motivo + ", fecha=" + fecha + ", productosDevueltos=" + productosDevueltos + '}';
    }

}
