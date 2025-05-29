/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOSalida.ItemVentaDTO;
import DTOSalida.VentaDTO;
import Excepcion.PersistenciaException;
import Excepciones.NegocioException;
import Interfaces.ICajaDAO;
import Interfaces.IProductoDAO;
import Interfaces.IVentaDAO;
import Mappers.ItemVentaMapper;
import Mappers.VentaMapper;
import POJOs.Caja;
import POJOs.ItemVenta;
import POJOs.Producto;
import POJOs.Venta;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author SDavidLedesma
 */
public class VentaBO {

    private final IVentaDAO ventaDAO;
    private final IProductoDAO productoDAO;
    private final ICajaDAO cajaDAO;

    public VentaBO(IVentaDAO ventaDAO, IProductoDAO productoDAO, ICajaDAO cajaDAO) {
        this.ventaDAO = ventaDAO;
        this.productoDAO = productoDAO;
        this.cajaDAO = cajaDAO;
    }

    public VentaDTO registrarVenta(VentaDTO dto) throws NegocioException {
        try {
            Caja caja = cajaDAO.buscarPorId(new ObjectId(dto.getCajaId()));
            Venta venta = VentaMapper.toEntity(dto);
            Venta registrada = ventaDAO.registrarVenta(venta);

            List<ItemVentaDTO> productosSalida = new ArrayList<>();
            for (ItemVenta item : registrada.getProductos()) {
                Producto producto = productoDAO.buscarPorId(item.getProductoId());
                productosSalida.add(ItemVentaMapper.toDTO(item, producto.getNombre()));
            }

            return VentaMapper.toDTO(registrada, productosSalida, caja.getId().toHexString());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar venta", e);
        }
    }
}
