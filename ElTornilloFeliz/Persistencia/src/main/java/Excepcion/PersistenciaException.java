/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepcion;

/**
 * clase que se usara para las excepciones de persistencia
 *
 * @author SDavidLedesma
 */
public class PersistenciaException extends Exception {

    /**
     * constructor por omision
     */
    public PersistenciaException() {
    }

    /**
     * constructtor que muestra el mensaje personalizado de la excepcion
     *
     * @param message
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * constructor que muestra el mensaje personalizado y la causa de la
     * excepcion
     *
     * @param message
     * @param cause
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
