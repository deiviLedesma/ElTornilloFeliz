/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearCompra;
import DTOEntrada.CrearItemCompra;
import DTOSalida.CompraDTO;
import DTOSalida.ItemCompraDTO;
import POJOs.Compra;
import POJOs.ItemCompra;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class CompraMapper {

    public static Compra toEntity(CrearCompra dto) {
        Compra c = new Compra();
        c.setProveedor(dto.getProveedorId());
        c.setUsuario(dto.getUsuario());
        List<ItemCompra> items = new ArrayList<>();
        for (CrearItemCompra itemDto : dto.getProductos()) {
            ItemCompra item = new ItemCompra();
            item.setProductoId(new ObjectId(itemDto.getProductoId()));
            item.setCantidad(itemDto.getCantidad());
            item.setPrecioUnitario(itemDto.getPrecioUnitario());
            items.add(item);
        }
        c.setProductos(items);
        return c;
    }

    public static CompraDTO toDTO(Compra c, List<ItemCompraDTO> productos) {
        CompraDTO dto = new CompraDTO();
        dto.setId(c.getId().toHexString());
        dto.setProveedorNombre(c.getProveedor());
        dto.setFechaHora(c.getFechaHora());
        dto.setUsuario(c.getUsuario());
        dto.setTotal(c.getTotal());
        dto.setProductos(productos);
        return dto;
    }
}

