/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.CrearCompra;
import DTOSalida.CompraDTO;
import DTOSalida.ItemCompraDTO;
import Excepcion.PersistenciaException;
import Excepciones.NegocioException;
import Interfaces.ICompraDAO;
import Interfaces.IProductoDAO;
import Mappers.CompraMapper;
import Mappers.ItemCompraMapper;
import POJOs.Compra;
import POJOs.ItemCompra;
import POJOs.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public class CompraBO {

    private final ICompraDAO compraDAO;
    private final IProductoDAO productoDAO;

    public CompraBO(ICompraDAO compraDAO, IProductoDAO productoDAO) {
        this.compraDAO = compraDAO;
        this.productoDAO = productoDAO;
    }

    public CompraDTO registrarCompra(CrearCompra dto) throws NegocioException {
        try {
            Compra compra = CompraMapper.toEntity(dto);
            Compra registrada = compraDAO.registrarCompra(compra);

            List<ItemCompraDTO> productosSalida = new ArrayList<>();
            for (ItemCompra item : registrada.getProductos()) {
                Producto producto = productoDAO.buscarPorId(item.getProductoId());
                productosSalida.add(ItemCompraMapper.toDTO(item, producto.getNombre()));
            }

            return CompraMapper.toDTO(registrada, productosSalida);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar compra", e);
        }
    }
}
