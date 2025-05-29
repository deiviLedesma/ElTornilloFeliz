package POJOs;

import java.util.Objects;

/**
 * Representa una unidad de medida para los productos del inventario.
 * Clase configurable.
 * 
 * Ejemplos: kilogramo, litro, pieza, metro.
 * 
 * @author JorgeE
 */
public class UnidadMedida {

    private String id; // ID único 
    private String nombre; // Nombre de la unidad, "Litro"
    private String abreviatura; // Abreviatura, , "L", "kg"

    public UnidadMedida() {
    }

    public UnidadMedida(String id, String nombre, String abreviatura) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }

    public UnidadMedida(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public String toString() {
        return nombre + " (" + abreviatura + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnidadMedida)) return false;
        UnidadMedida that = (UnidadMedida) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
