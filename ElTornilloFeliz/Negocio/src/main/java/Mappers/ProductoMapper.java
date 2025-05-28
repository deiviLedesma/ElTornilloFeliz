/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import POJOs.Producto;

/**
 *
 * @author SDavidLedesma
 */
public class ProductoMapper {

    public static Producto toEntity(ProductoEntradaDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setCategoriaId(new ObjectId(dto.getCategoriaId()));
        producto.setUnidadMedidaId(new ObjectId(dto.getUnidadMedidaId()));
        producto.setPrecioCompra(dto.getPrecioCompra());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencias(dto.getExistencias());
        producto.setImagen(dto.getImagen());
        return producto;
    }

    public static Producto toDTO(Producto producto, String categoriaNombre, String unidadMedidaNombre) {
        ProductoSalidaDTO dto = new ProductoSalidaDTO();
        dto.setId(producto.getId().toHexString());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setCategoriaNombre(categoriaNombre);
        dto.setUnidadMedidaNombre(unidadMedidaNombre);
        dto.setPrecioCompra(producto.getPrecioCompra());
        dto.setPrecioVenta(producto.getPrecioVenta());
        dto.setExistencias(producto.getExistencias());
        dto.setImagen(producto.getImagen());
        return dto;
    }
}
