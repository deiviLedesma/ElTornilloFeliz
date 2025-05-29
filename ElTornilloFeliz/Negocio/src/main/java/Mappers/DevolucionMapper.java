/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearDevolucion;
import DTOEntrada.CrearItemDevolucion;
import DTOSalida.DevolucionDTO;
import DTOSalida.ItemDevolucionDTO;
import POJOs.Devolucion;
import POJOs.ItemDevolucion;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class DevolucionMapper {

    public static Devolucion toEntity(CrearDevolucion dto) {
        Devolucion d = new Devolucion();
        d.setMotivo(dto.getMotivo());
        d.setUsuario(dto.getUsuario());
        List<ItemDevolucion> items = new ArrayList<>();
        for (CrearItemDevolucion itemDto : dto.getProductosDevueltos()) {
            ItemDevolucion item = new ItemDevolucion();
            item.setProductoId(new ObjectId(itemDto.getProductoId()));
            item.setCantidad(itemDto.getCantidad());
            items.add(item);
        }
        d.setProductosDevueltos(items);
        return d;
    }

    public static DevolucionDTO toDTO(Devolucion d, List<ItemDevolucionDTO> productos) {
        DevolucionDTO dto = new DevolucionDTO();
        dto.setId(d.getId().toHexString());
        dto.setFecha(d.getFecha());
        dto.setMotivo(d.getMotivo());
        dto.setUsuario(d.getUsuario());
        dto.setProductosDevueltos(productos);
        return dto;
    }
}
