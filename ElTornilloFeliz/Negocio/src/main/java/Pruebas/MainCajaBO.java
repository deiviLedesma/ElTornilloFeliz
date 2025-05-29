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
import Interfaces.ICajaDAO;
import POJOs.Caja;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author SDavidLedesma
 */
public class MainCajaBO {

    public static void main(String[] args) {
        // Configura la conexión a MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("eltornillofeliz");

        // Inicializa el DAO y el BO
        ICajaDAO cajaDAO = new CajaDAO((MongoCollection<Caja>) database);
        CajaBO cajaBO = new CajaBO(cajaDAO);

        // Crea un DTO para abrir la caja
        CrearCaja crearCaja = new CrearCaja();
        crearCaja.setMontoInicial(1000.0);
        crearCaja.setUsuario("admin");

        try {
            // Llama al método abrirCaja
            CajaDTO cajaDTO = cajaBO.abrirCaja(crearCaja);
            System.out.println("Caja abierta: " + cajaDTO);
        } catch (NegocioException e) {
            e.printStackTrace();
        } finally {
            mongoClient.close();
        }
    }
}
