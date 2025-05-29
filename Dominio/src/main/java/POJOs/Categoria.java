package POJOs;

import java.util.Objects;

/**
 * Representa una categoría de productos 
 * 
 * @author JorgeE
 */
public class Categoria {

    private String id; // id 
    private String nombre; // nombre único de la categoría
    private String descripcion; // descripción opcional de la categoría

    public Categoria() {
    }

    public Categoria(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
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

    // Métodos auxiliares

    @Override
    public String toString() {
        return nombre; // Para mostrar en listas desplegables
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria that = (Categoria) o;
        return Objects.equals(nombre, that.nombre); // Compara por nombre
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
