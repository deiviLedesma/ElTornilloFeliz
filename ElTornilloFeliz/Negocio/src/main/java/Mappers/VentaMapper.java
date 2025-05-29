/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOSalida.ItemVentaDTO;
import DTOSalida.VentaDTO;
import POJOs.ItemVenta;
import POJOs.Venta;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class VentaMapper {

    public static Venta toEntity(VentaDTO dto) {
        Venta v = new Venta();
        v.setFechaHora(dto.getFechaHora());
        v.setUsuario(dto.getUsuario());
        v.setTotal(dto.getTotal());
        List<ItemVenta> items = new ArrayList<>();
        for (ItemVentaDTO itemDto : dto.getProductos()) {
            ItemVenta item = new ItemVenta();
            item.setProductoId(new ObjectId(itemDto.getProductoId()));
            item.setCantidad(itemDto.getCantidad());
            item.setPrecioUnitario(itemDto.getPrecioUnitario());
            items.add(item);
        }
        v.setProductos(items);
        return v;
    }

    public static VentaDTO toDTO(Venta v, List<ItemVentaDTO> productos, String cajaId) {
        VentaDTO dto = new VentaDTO();
        dto.setId(v.getId().toHexString());
        dto.setCajaId(cajaId); // <- Esto faltaba
        dto.setFechaHora(v.getFechaHora());
        dto.setUsuario(v.getUsuario());
        dto.setTotal(v.getTotal());
        dto.setProductos(productos);
        return dto;
    }

}
