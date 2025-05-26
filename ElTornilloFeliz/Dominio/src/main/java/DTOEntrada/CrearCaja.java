/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * clase que recibe los DTOS de entrada
 *
 * @author SDavidLedesma
 */
public class CrearCaja {

    //atributos
    private double montoInicial;
    private String usuario;

    /**
     * constructor por omision
     */
    public CrearCaja() {
    }

    /**
     * constructor que incializa los atributos
     *
     * @param montoInicial
     * @param usuario
     */
    public CrearCaja(double montoInicial, String usuario) {
        this.montoInicial = montoInicial;
        this.usuario = usuario;
    }

    //getters y setters
    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "CrearCaja{" + "montoInicial=" + montoInicial + ", usuario=" + usuario + '}';
    }

}
