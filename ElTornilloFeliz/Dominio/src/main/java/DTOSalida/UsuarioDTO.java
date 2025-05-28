/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

/**
 * clase que muestra los dto de salida
 *
 * @author SDavidLedesma
 */
public class UsuarioDTO {

    //atributos
    private String id;
    private String nombreUsuario;

    /**
     * constructor por omision
     */
    public UsuarioDTO() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param nombreUsuario
     */
    public UsuarioDTO(String id, String nombreUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
    }

    //getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + '}';
    }

}
