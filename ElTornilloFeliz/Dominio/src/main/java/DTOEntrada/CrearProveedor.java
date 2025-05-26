/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * clase que recibe los DTOs de entrada
 *
 * @author SDavidLedesma
 */
public class CrearProveedor {

    //atributos
    private String nombre;
    private String telefono;
    private String correo;

    /**
     * constructor por omision
     */
    public CrearProveedor() {
    }

    /**
     * contructor que inicializa los atributos
     *
     * @param nombre
     * @param telefono
     * @param correo
     */
    public CrearProveedor(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    //getters y setters
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
        return "CrearProveedor{" + "nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + '}';
    }

}
