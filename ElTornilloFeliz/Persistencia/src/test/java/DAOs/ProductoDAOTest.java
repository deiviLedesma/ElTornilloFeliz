/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import DTOSalida.ReporteInventarioBajaDTO;
import Excepcion.PersistenciaException;
import POJOs.Categoria;
import POJOs.Producto;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
public class ProductoDAOTest {

    private ProductoDAO productoDAO;

    @Mock
    private MongoCollection<Producto> coleccionMock;

    @Mock
    private FindIterable<Producto> findIterableMock;

    @Mock
    private MongoCursor<Producto> cursorMock;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        productoDAO = new ProductoDAO(coleccionMock);
        when(coleccionMock.find(any(Bson.class))).thenReturn(findIterableMock);
        when(findIterableMock.iterator()).thenReturn(cursorMock);
        //when(cursorMock.hasNext()).thenReturn(true, false); // solo una iteración

    }

    @Test
    public void testGenerarReporteInventarioBajo() throws PersistenciaException {
        int umbral = 10;

        Producto productoMock = new Producto();
        productoMock.setId(new ObjectId("64b64c8efbed0c56a4b4f50a"));
        productoMock.setNombre("Martillo");

        Categoria categoria = new Categoria();
        categoria.setNombre("herramienta");
        productoMock.setCategoria(categoria);
        productoMock.setExistencias(5);

        when(cursorMock.hasNext()).thenReturn(true, false);
        when(cursorMock.next()).thenReturn(productoMock);

        List<ReporteInventarioBajaDTO> resultado = productoDAO.generarReporteInventarioBajo(umbral);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());

        ReporteInventarioBajaDTO dto = resultado.get(0);
        assertEquals("64b64c8efbed0c56a4b4f50a", dto.getProductoId());
        assertEquals("Martillo", dto.getNombre());

        DTOSalida.CategoriaDTO categoriaDTO = dto.getCategoria();
        assertNotNull(categoriaDTO);
        assertEquals("herramienta", categoriaDTO.getNombre());
        assertNull(categoriaDTO.getId());
        assertNull(categoriaDTO.getDescripcion());

        assertEquals(5, dto.getExistencias());
        assertEquals(umbral, dto.getUmbral());
    }
}
