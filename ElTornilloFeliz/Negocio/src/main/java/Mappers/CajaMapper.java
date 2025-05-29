/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearCaja;
import DTOSalida.CajaDTO;
import POJOs.Caja;

/**
 *
 * @author SDavidLedesma
 */
public class CajaMapper {

    public static Caja toEntity(CrearCaja dto) {
        Caja c = new Caja();
        c.setMontoInicial(dto.getMontoInicial());
        c.setUsuario(dto.getUsuario());
        return c;
    }
    
     public static CajaDTO toDTO(Caja c) {
        CajaDTO dto = new CajaDTO();
        dto.setId(c.getId().toHexString());
        dto.setFechaApertura(c.getFechaApertura());
        dto.setMontoInicial(c.getMontoInicial());
        dto.setUsuario(c.getUsuario());
        return dto;
    }
    
}


