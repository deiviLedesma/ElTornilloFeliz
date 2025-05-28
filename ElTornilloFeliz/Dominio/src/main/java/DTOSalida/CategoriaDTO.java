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
public class CategoriaDTO {

    //Atributo
    private String id;
    private String nombre;
    private String descripcion;

    /**
     * constructor por omision
     */
    public CategoriaDTO() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param nombre
     * @param descripcion
     */
    public CategoriaDTO(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

}
