/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.CrearUsuario;
import DTOSalida.UsuarioDTO;
import Excepcion.PersistenciaException;
import Excepciones.NegocioException;
import Interfaces.IUsuarioDAO;
import Mappers.UsuarioMapper;
import POJOs.Usuario;

/**
 *
 * @author SDavidLedesma
 */
public class UsuarioBO {

    private final IUsuarioDAO usuarioDAO;

    public UsuarioBO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public UsuarioDTO registrarUsuario(CrearUsuario dto) throws NegocioException {
        try {
            Usuario usuario = UsuarioMapper.toEntity(dto);
            Usuario registrado = usuarioDAO.registrarUsuario(usuario);
            return UsuarioMapper.toDTO(registrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar usuario", e);
        }
    }

    public boolean validarCredenciales(String nombre, String contrasenia) throws NegocioException {
        try {
            return usuarioDAO.validarCredenciales(nombre, contrasenia);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al validar credenciales", e);
        }
    }
}
