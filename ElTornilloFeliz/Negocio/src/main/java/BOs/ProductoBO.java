/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.CrearProducto;
import DTOSalida.ProductoDTO;
import Excepcion.PersistenciaException;
import Excepciones.NegocioException;
import Interfaces.ICategoriaDAO;
import Interfaces.IProductoDAO;
import Interfaces.IUnidadMedida;
import Mappers.ProductoMapper;
import POJOs.Categoria;
import POJOs.Producto;
import POJOs.UnidadMedida;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class ProductoBO {

    private final IProductoDAO productoDAO;
    private final ICategoriaDAO categoriaDAO;
    private final IUnidadMedida unidadMedidaDAO;

    public ProductoBO(IProductoDAO productoDAO, ICategoriaDAO categoriaDAO, IUnidadMedida unidadMedidaDAO) {
        this.productoDAO = productoDAO;
        this.categoriaDAO = categoriaDAO;
        this.unidadMedidaDAO = unidadMedidaDAO;
    }

    public ProductoDTO registrarProducto(CrearProducto dto) throws NegocioException {
        try {
            Categoria categoria = categoriaDAO.buscarPorId(new ObjectId(dto.getCategoriaId()));
            UnidadMedida unidad = unidadMedidaDAO.buscarPorId(new ObjectId(dto.getUnidadMedidaId()));
            Producto producto = ProductoMapper.toEntity(dto, categoria, unidad);
            Producto registrado = productoDAO.insertar(producto);
            return ProductoMapper.toDTO(registrado, categoria.getNombre(), unidad.getNombre());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar el producto", e);
        }
    }
}
