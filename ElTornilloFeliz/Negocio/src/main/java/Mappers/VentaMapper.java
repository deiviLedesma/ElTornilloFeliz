/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearVenta;
import POJOs.ItemVenta;
import POJOs.Venta;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author SDavidLedesma
 */
public class VentaMapper {

    public static Venta toEntity(CrearVenta dto) {
        List<ItemVenta> productos = dto.getProductos().stream()
                .map(ItemVentaMapper::toEntity)
                .collect(Collectors.toList());
        return new Venta(null, new Date(), productos, 0.0, dto.getUsuario());
    }
}
