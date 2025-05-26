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
public class CrearCategoria {

    //atributos
    private String nombre;
    private String descripcion;

    /**
     * constructor por omision
     */
    public CrearCategoria() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param nombre
     * @param descripcion
     */
    public CrearCategoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //getters y setters
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
        return "CrearCategoria{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

}
