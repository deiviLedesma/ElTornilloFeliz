/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import DTOSalida.ReporteCajaDTO;
import Excepcion.PersistenciaException;
import POJOs.Caja;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author SDavidLedesma
 */
public class CajaDAOTest {

    private CajaDAO cajaDAO;

    @Mock
    private MongoCollection<Caja> coleccionMock;

    @Mock
    private FindIterable<Caja> findIterableMock;

    @Mock
    private MongoCursor<Caja> cursorMock;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        cajaDAO = new CajaDAO(coleccionMock);
        when(coleccionMock.find(any(Bson.class))).thenReturn(findIterableMock);
        when(findIterableMock.iterator()).thenReturn(cursorMock);
        //when(cursorMock.hasNext()).thenReturn(true, false); // solo una iteración

    }

    @Test
    public void testGenerarReporteCajasPorFechas() throws PersistenciaException {
        Date inicio = new Date(1700000000000L);
        Date fin = new Date(1800000000000L);

        Caja cajaMock = new Caja();
        cajaMock.setId(new ObjectId("64b64c8efbed0c56a4b4f50a"));
        cajaMock.setUsuario("usuarioTest");
        cajaMock.setFechaApertura(inicio);
        cajaMock.setFechaCierre(fin);
        cajaMock.setMontoInicial(100.0);
        cajaMock.setMontoFinal(500.0);
        cajaMock.setTotalVentas(400.0);

        when(cursorMock.hasNext()).thenReturn(true, false);
        when(cursorMock.next()).thenReturn(cajaMock);

        List<ReporteCajaDTO> resultado = cajaDAO.generarReporteCajasPorFechas(inicio, fin);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());

        ReporteCajaDTO dto = resultado.get(0);
        assertEquals("64b64c8efbed0c56a4b4f50a", dto.getId());
        assertEquals("usuarioTest", dto.getUsuario());
        assertEquals(inicio, dto.getFechaApertura());
        assertEquals(fin, dto.getFechaCierre());
        assertEquals(100.0, dto.getMontoInicial());
        assertEquals(500.0, dto.getMontoFinal());
        assertEquals(400.0, dto.getTotalVentas());
    }

}
