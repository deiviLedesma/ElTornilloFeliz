/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearItemCompra;
import DTOSalida.ItemCompraDTO;
import POJOs.ItemCompra;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class ItemCompraMapper {

    public static ItemCompra toEntity(CrearItemCompra dto) {
        return new ItemCompra(new ObjectId(dto.getProductoId()), dto.getCantidad(), dto.getPrecioUnitario());
    }

    public static ItemCompraDTO toDTO(ItemCompra item, String nombreProducto) {
        ItemCompraDTO dto = new ItemCompraDTO();
        dto.setProductoId(item.getProductoId().toHexString());
        dto.setNombreProducto(nombreProducto);
        dto.setCantidad(item.getCantidad());
        dto.setPrecioUnitario(item.getPrecioUnitario());
        dto.setSubtotal(item.getCantidad() * item.getPrecioUnitario());
        return dto;
    }
}
