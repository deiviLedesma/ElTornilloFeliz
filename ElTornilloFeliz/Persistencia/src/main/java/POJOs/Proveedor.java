/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import org.bson.types.ObjectId;

/**
 * clase que selecciona al proveedor para realizar las compras
 *
 * @author SDavidLedesma
 */
public class Proveedor {

    //Atributos
    private ObjectId id;
    private String nombre;
    private String telefono;
    private String correo;

    /**
     * constructor por omision
     */
    public Proveedor() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param nombre
     * @param telefono
     * @param correo
     */
    public Proveedor(ObjectId id, String nombre, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Proveedor(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + '}';
    }

}
