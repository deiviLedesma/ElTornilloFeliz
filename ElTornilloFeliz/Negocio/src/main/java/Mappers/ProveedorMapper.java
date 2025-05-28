/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearProveedor;
import DTOSalida.ProveedorDTO;
import POJOs.Proveedor;

/**
 *
 * @author SDavidLedesma
 */
public class ProveedorMapper {

    public static Proveedor toEntity(CrearProveedor dto) {
        return new Proveedor(dto.getNombre(), dto.getTelefono(), dto.getCorreo());
    }

    public static ProveedorDTO toDTO(Proveedor proveedor) {
        ProveedorDTO dto = new ProveedorDTO();
        dto.setId(proveedor.getId().toHexString());
        dto.setNombre(proveedor.getNombre());
        dto.setTelefono(proveedor.getTelefono());
        dto.setCorreo(proveedor.getCorreo());
        return dto;
    }
}
