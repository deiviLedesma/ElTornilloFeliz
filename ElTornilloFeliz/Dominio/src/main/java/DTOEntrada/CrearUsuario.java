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
public class CrearUsuario {

    //Atributos
    private String nombreUsuario;
    private String contrasenia;

    /**
     * contructor por omision
     */
    public CrearUsuario() {
    }

    /**
     * constructor que inicialza los atributos
     *
     * @param nombreUsuario
     * @param contrasenia
     */
    public CrearUsuario(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    //getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "CrearUsuario{" + "nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + '}';
    }

}
