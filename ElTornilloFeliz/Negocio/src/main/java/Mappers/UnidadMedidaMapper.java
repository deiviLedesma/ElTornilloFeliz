/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearUnidadMedida;
import DTOSalida.UnidadMedidaDTO;
import POJOs.UnidadMedida;

/**
 *
 * @author SDavidLedesma
 */
public class UnidadMedidaMapper {

    public static UnidadMedida toEntity(CrearUnidadMedida dto) {
        return new UnidadMedida(dto.getNomnbre(), dto.getDescripcion());
    }

    public static UnidadMedidaDTO toDTO(UnidadMedida unidad) {
        UnidadMedidaDTO dto = new UnidadMedidaDTO();
        dto.setId(unidad.getId().toHexString());
        dto.setNombre(unidad.getNombre());
        dto.setDescripcion(unidad.getDescripcion());
        return dto;
    }
}
