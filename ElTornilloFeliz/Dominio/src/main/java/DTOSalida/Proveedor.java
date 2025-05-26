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
public class Proveedor {

    //atributos
    private String id;
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
    public Proveedor(String id, String nombre, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
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
