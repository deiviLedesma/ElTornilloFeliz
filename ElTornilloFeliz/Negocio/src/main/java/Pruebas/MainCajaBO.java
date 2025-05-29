/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import BOs.CajaBO;
import DAOs.CajaDAO;
import DTOEntrada.CrearCaja;
import DTOSalida.CajaDTO;
import Excepciones.NegocioException;
import java.util.Date;

/**
 *
 * @author SDavidLedesma
 */
public class MainCajaBO {

    public static void main(String[] args) {
        // Crear una instancia del DAO
        CajaDAO cajaDAO = new CajaDAO();

        // Crear una instancia del BO con el DAO
        CajaBO cajaBO = new CajaBO(cajaDAO);

        // Crear un DTO con los datos de la caja a abrir
        CrearCaja crearCaja = new CrearCaja();
        crearCaja.setMontoInicial(1000.0);
        crearCaja.setUsuario("admin");

        try {
            // Llamar al método para abrir la caja
            CajaDTO cajaAbierta = cajaBO.abrirCaja(crearCaja);

            // Imprimir los detalles de la caja abierta
            System.out.println("Caja abierta exitosamente:");
            System.out.println("ID: " + cajaAbierta.getId());
            System.out.println("Monto Inicial: " + cajaAbierta.getMontoInicial());
            System.out.println("Usuario: " + cajaAbierta.getUsuario());
        } catch (NegocioException e) {
            System.err.println("Error al abrir la caja: " + e.getMessage());
        }
    }
}
