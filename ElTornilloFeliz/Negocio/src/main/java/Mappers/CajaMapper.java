/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.CrearCaja;
import POJOs.Caja;
import java.util.Date;

/**
 *
 * @author SDavidLedesma
 */
public class CajaMapper {

    public static Caja toEntity(CrearCaja dto) {
        return new Caja(dto.getMontoInicial(), dto.getUsuario());
    }
}
