/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.CrearUnidadMedida;
import DTOSalida.UnidadMedidaDTO;
import Excepcion.PersistenciaException;
import Excepciones.NegocioException;
import Interfaces.IUnidadMedida;
import Mappers.UnidadMedidaMapper;
import POJOs.UnidadMedida;

/**
 *
 * @author SDavidLedesma
 */
public class UnidadMedidaBO {

    private final IUnidadMedida unidadDAO;

    public UnidadMedidaBO(IUnidadMedida unidadDAO) {
        this.unidadDAO = unidadDAO;
    }

    public UnidadMedidaDTO registrarUnidad(CrearUnidadMedida dto) throws NegocioException {
        try {
            UnidadMedida unidad = UnidadMedidaMapper.toEntity(dto);
            UnidadMedida registrada = unidadDAO.registrarMedida(unidad);
            return UnidadMedidaMapper.toDTO(registrada);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar unidad de medida", e);
        }
    }
}
