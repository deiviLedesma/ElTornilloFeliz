/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearDevolucion;
import POJOs.Devolucion;
import POJOs.ItemDevolucion;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author SDavidLedesma
 */
public class DevolucionMapper {

    public static Devolucion toEntity(CrearDevolucion dto) {
        List<ItemDevolucion> productos = dto.getProductosDevueltos().stream()
                .map(ItemDevolucionMapper::toEntity)
                .collect(Collectors.toList());
        return new Devolucion(null, new Date(), dto.getMotivo(), dto.getUsuario(), productos);
    }
}
