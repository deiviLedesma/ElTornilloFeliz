/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.CrearCaja;
import DTOSalida.CajaDTO;
import Excepcion.PersistenciaException;
import Excepciones.NegocioException;
import Interfaces.ICajaDAO;
import Mappers.CajaMapper;
import POJOs.Caja;

/**
 *
 * @author SDavidLedesma
 */
public class CajaBO {

    private final ICajaDAO cajaDAO;

    public CajaBO(ICajaDAO cajaDAO) {
        this.cajaDAO = cajaDAO;
    }

    public CajaDTO abrirCaja(CrearCaja dto) throws NegocioException {
        try {
            Caja caja = CajaMapper.toEntity(dto);
            Caja abierta = cajaDAO.abrirCaja(caja);
            return CajaMapper.toDTO(abierta);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al abrir caja", e);
        }
    }
}
