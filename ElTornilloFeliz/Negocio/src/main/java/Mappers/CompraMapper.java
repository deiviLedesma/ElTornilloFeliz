/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearCompra;
import POJOs.Compra;
import POJOs.ItemCompra;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author SDavidLedesma
 */
public class CompraMapper {

    public static Compra toEntity(CrearCompra dto) {
        List<ItemCompra> productos = dto.getProductos().stream()
                .map(ItemCompraMapper::toEntity)
                .collect(Collectors.toList());
        return new Compra(null, new Date(), dto.getProveedorId(), productos, 0.0, dto.getUsuario());
    }
}
