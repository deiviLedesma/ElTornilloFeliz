/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.CrearProveedor;
import DTOSalida.ProveedorDTO;
import Excepcion.PersistenciaException;
import Excepciones.NegocioException;
import Interfaces.IProveedorDAO;
import Mappers.ProveedorMapper;
import POJOs.Proveedor;

/**
 *
 * @author SDavidLedesma
 */
public class ProveedorBO {

    private final IProveedorDAO proveedorDAO;

    public ProveedorBO(IProveedorDAO proveedorDAO) {
        this.proveedorDAO = proveedorDAO;
    }

    public ProveedorDTO registrarProveedor(CrearProveedor dto) throws NegocioException {
        try {
            Proveedor proveedor = ProveedorMapper.toEntity(dto);
            Proveedor registrado = proveedorDAO.registrarProveedor(proveedor);
            return ProveedorMapper.toDTO(registrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar proveedor", e);
        }
    }
}
