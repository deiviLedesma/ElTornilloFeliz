/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * clase de excepciones para la capa de negocio
 *
 * @author SDavidLedesma
 */
public class NegocioException extends Exception {

    /**
     * constructor por omision
     */
    public NegocioException() {
    }

    /**
     * constructor que muestra el mensaje personalizado de la excepcion
     *
     * @param message
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * constructor que muestra el mensaje personalizado de la excepcion y la
     * causa de la excepcion
     *
     * @param message
     * @param cause
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

}
