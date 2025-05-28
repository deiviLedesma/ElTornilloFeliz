/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearCategoria;
import DTOSalida.CategoriaDTO;
import POJOs.Categoria;

/**
 *
 * @author SDavidLedesma
 */
public class CategoriaMapper {

    public static Categoria toEntity(CrearCategoria dto) {
        return new Categoria(dto.getNombre(),dto.getDescripcion());
    }

    public static CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId().toHexString());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        return dto;
    }
}
