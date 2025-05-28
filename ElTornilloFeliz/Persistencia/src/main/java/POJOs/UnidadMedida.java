/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class UnidadMedida {

    //atributos
    private ObjectId id;
    private String nombre;
    private String descripcion;

    /**
     * constructor por omision
     */
    public UnidadMedida() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param nombre
     * @param descripcion
     */
    public UnidadMedida(ObjectId id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public UnidadMedida(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //getters y setters
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

    @Override
    public String toString() {
        return "UnidadMedida{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

}
