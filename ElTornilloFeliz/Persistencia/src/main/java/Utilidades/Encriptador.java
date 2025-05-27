/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Clase que encriptara las conrtaseñas y valida las contraseñas
 *
 * @author SDavidLedesma
 */
public class Encriptador {

    /**
     * genera un hash seguro con salt automatico usando bcrypt
     *
     * @param contrasenia
     * @return
     */
    public static String encriptarContrasenia(String contrasenia) {

        // el numero 12 indica el costo (fuerza)
        return BCrypt.hashpw(contrasenia, BCrypt.gensalt(12));
    }

    /**
     * verifica si una contraseña ingresada coincide con el hash guardado
     *
     * @param contrasenia
     * @param hashGuardado
     * @return
     */
    public static boolean verificarContrasenia(String contrasenia, String hashGuardado) {
        return BCrypt.checkpw(contrasenia, hashGuardado);
    }
}
