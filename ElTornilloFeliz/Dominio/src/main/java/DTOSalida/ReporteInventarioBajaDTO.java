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
public class ReporteInventarioBajaDTO {

    //atributos
    private String productoId;
    private String nombre;
    private String categoria;
    private int existencias;
    private int umbral;

    /**
     * constructor por omision
     */
    public ReporteInventarioBajaDTO() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param productoId
     * @param nombre
     * @param categoria
     * @param existencias
     * @param umbral
     */
    public ReporteInventarioBajaDTO(String productoId, String nombre, String categoria, int existencias, int umbral) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.categoria = categoria;
        this.existencias = existencias;
        this.umbral = umbral;
    }

    //getters y setters
    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getUmbral() {
        return umbral;
    }

    public void setUmbral(int umbral) {
        this.umbral = umbral;
    }

    @Override
    public String toString() {
        return "ReporteInventarioBajaDTO{" + "productoId=" + productoId + ", nombre=" + nombre + ", categoria=" + categoria + ", existencias=" + existencias + ", umbral=" + umbral + '}';
    }

}
