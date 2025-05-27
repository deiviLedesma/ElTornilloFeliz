/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Usuario;

/**
 * Interfaz DAO para la gestion de usuarios del sistema
 *
 * @author SDavidLedesma
 */
public interface IUsuarioDAO {

    /**
     * registra un nuevo usuario lanza una persistenciaException
     *
     * @param usuario
     * @return devuelve el usuario registrado
     * @throws PersistenciaException
     */
    Usuario registrarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * busca un usuario por su nombre de usuario lanza una persistenciaException
     *
     * @param nombreUsuario
     * @return devuelve el usuario encontrado por su nombre
     * @throws PersistenciaException
     */
    Usuario buscarPorNombreUsuario(String nombreUsuario) throws PersistenciaException;

    /**
     * valida si las credenciales del usuario son correctas lanza una
     * persistenciaException
     *
     * @param nombreUsuario
     * @param contrasenia
     * @return devuelve el usario validado (true/false)
     * @throws PersistenciaException
     */
    boolean validarCredenciales(String nombreUsuario, String contrasenia) throws PersistenciaException;

}
