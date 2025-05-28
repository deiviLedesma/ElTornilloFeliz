/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearItemDevolucion;
import DTOSalida.ItemDevolucionDTO;
import POJOs.ItemDevolucion;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class ItemDevolucionMapper {

    public static ItemDevolucion toEntity(CrearItemDevolucion dto) {
        return new ItemDevolucion(new ObjectId(dto.getProductoId()), dto.getCantidad(), dto.isRegresarAInventario());
    }

    public static ItemDevolucionDTO toDTO(ItemDevolucion item, String nombreProducto) {
        ItemDevolucionDTO dto = new ItemDevolucionDTO();
        dto.setProductoId(item.getProductoId().toHexString());
        dto.setNombreProducto(nombreProducto);
        dto.setCantidad(item.getCantidad());
        dto.setRegresarAInventario(item.isRegresarAInventario());
        return dto;
    }
}
