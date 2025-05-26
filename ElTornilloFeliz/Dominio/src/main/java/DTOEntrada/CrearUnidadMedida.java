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
public class CrearUnidadMedida {

    //Atributos
    private String nomnbre;
    private String descripcion;

    /**
     * constructor por omision
     */
    public CrearUnidadMedida() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param nomnbre
     * @param descripcion
     */
    public CrearUnidadMedida(String nomnbre, String descripcion) {
        this.nomnbre = nomnbre;
        this.descripcion = descripcion;
    }

    //getters y setters
    public String getNomnbre() {
        return nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CrearUnidadMedida{" + "nomnbre=" + nomnbre + ", descripcion=" + descripcion + '}';
    }

}
