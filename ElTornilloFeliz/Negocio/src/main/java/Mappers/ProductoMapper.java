/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearProducto;
import DTOSalida.ProductoDTO;
import POJOs.Categoria;
import POJOs.Producto;
import POJOs.UnidadMedida;

/**
 *
 * @author SDavidLedesma
 */
public class ProductoMapper {

    public static Producto toEntity(CrearProducto dto, Categoria categoria, UnidadMedida unidadMedida) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setCategoria(categoria);
        producto.setUnidadMedida(unidadMedida);
        producto.setPrecioCompra(dto.getPrecioCompra());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencias(dto.getExistencias());
        producto.setImagen(dto.getImagen());
        return producto;
    }

    public static ProductoDTO toDTO(Producto producto, String categoriaNombre, String unidadMedidaNombre) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId().toHexString());
        dto.setNombre(producto.getNombre());
        dto.setDesccripcion(producto.getDescripcion());
        dto.setCategoria(categoriaNombre);
        dto.setUnidadMedida(unidadMedidaNombre);
        dto.setPrecioCompra(producto.getPrecioCompra());
        dto.setPrecioVenta(producto.getPrecioVenta());
        dto.setExistencias(producto.getExistencias());
        dto.setIamgen(producto.getImagen());
        return dto;
    }
}
