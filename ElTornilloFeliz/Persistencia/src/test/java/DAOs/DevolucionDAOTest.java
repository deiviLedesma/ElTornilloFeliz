/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import DTOSalida.ReporteDevolucionDTO;
import Excepcion.PersistenciaException;
import POJOs.Devolucion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author SDavidLedesma
 */
public class DevolucionDAOTest {

    private DevolucionDAO devolucionDAO;

    @Mock
    private MongoCollection<Devolucion> coleccionMock;

    @Mock
    private FindIterable<Devolucion> findIterableMock;

    @Mock
    private MongoCursor<Devolucion> cursorMock;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        devolucionDAO = new DevolucionDAO(coleccionMock);
        when(coleccionMock.find(any(Bson.class))).thenReturn(findIterableMock);
        when(findIterableMock.iterator()).thenReturn(cursorMock);
        //when(cursorMock.hasNext()).thenReturn(true, false); // solo una iteración

    }

    @Test
    public void testGenerarReporteDevolucionesPorFechas() throws PersistenciaException {
        Date inicio = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000); // ayer
        Date fin = new Date(); // hoy

        Devolucion devolucionMock = new Devolucion();
        devolucionMock.setId(new ObjectId("64b64c8efbed0c56a4b4f50b"));
        devolucionMock.setUsuario("usuarioTest");
        devolucionMock.setMotivo("Defecto en producto");
        devolucionMock.setFecha(fin);
        devolucionMock.setProductosDevueltos(new ArrayList<>()); // lista vacía para este ejemplo

        when(cursorMock.hasNext()).thenReturn(true, false);
        when(cursorMock.next()).thenReturn(devolucionMock);

        List<ReporteDevolucionDTO> resultado = devolucionDAO.generarReporteDevolucionesPorFechas(inicio, fin);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());

        ReporteDevolucionDTO dto = resultado.get(0);
        assertEquals("64b64c8efbed0c56a4b4f50b", dto.getId());
        assertEquals("usuarioTest", dto.getUsuario());
        assertEquals("Defecto en producto", dto.getMotivo());
        assertEquals(0, dto.getCantidadProductos());
        assertEquals(fin, dto.getFecha());
    }
}
