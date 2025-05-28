/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearItemVenta;
import DTOSalida.ItemVentaDTO;
import POJOs.ItemVenta;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class ItemVentaMapper {
    
    public static ItemVenta toEntity(CrearItemVenta dto) {
        return new ItemVenta(new ObjectId(dto.getProductoId()), dto.getCantidad(), dto.getPrecioUnitario());
    }

    public static ItemVentaDTO toDTO(ItemVenta item, String nombreProducto) {
        ItemVentaDTO dto = new ItemVentaDTO();
        dto.setProductoId(item.getProductoId().toHexString());
        dto.setNombreProducto(nombreProducto);
        dto.setCantidad(item.getCantidad());
        dto.setPrecioUnitario(item.getPrecioUnitario());
        dto.setSubtotal(item.getCantidad() * item.getPrecioUnitario());
        return dto;
    }
}
