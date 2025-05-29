/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.CrearDevolucion;
import DTOSalida.DevolucionDTO;
import DTOSalida.ItemDevolucionDTO;
import Excepcion.PersistenciaException;
import Excepciones.NegocioException;
import Interfaces.IDevolucionDAO;
import Interfaces.IProductoDAO;
import Mappers.DevolucionMapper;
import Mappers.ItemDevolucionMapper;
import POJOs.Devolucion;
import POJOs.ItemDevolucion;
import POJOs.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public class DevolucionBO {

    private final IDevolucionDAO devolucionDAO;
    private final IProductoDAO productoDAO;

    public DevolucionBO(IDevolucionDAO devolucionDAO, IProductoDAO productoDAO) {
        this.devolucionDAO = devolucionDAO;
        this.productoDAO = productoDAO;
    }

    public DevolucionDTO registrarDevolucion(CrearDevolucion dto) throws NegocioException {
        try {
            Devolucion devolucion = DevolucionMapper.toEntity(dto); // ✅ Ahora sí encaja
            Devolucion registrada = devolucionDAO.registrarDevolucion(devolucion);

            List<ItemDevolucionDTO> productosSalida = new ArrayList<>();
            for (ItemDevolucion item : registrada.getProductosDevueltos()) {
                Producto producto = productoDAO.buscarPorId(item.getProductoId());
                productosSalida.add(ItemDevolucionMapper.toDTO(item, producto.getNombre()));
            }

            return DevolucionMapper.toDTO(registrada, productosSalida);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar devolución", e);
        }
    }
}
