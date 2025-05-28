/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearUsuario;
import DTOSalida.UsuarioDTO;
import POJOs.Usuario;

/**
 *
 * @author SDavidLedesma
 */
public class UsuarioMapper {

    public static Usuario toEntity(CrearUsuario dto) {
        return new Usuario(dto.getNombreUsuario(), dto.getContrasenia());
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId().toHexString());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        return dto;
    }
}
