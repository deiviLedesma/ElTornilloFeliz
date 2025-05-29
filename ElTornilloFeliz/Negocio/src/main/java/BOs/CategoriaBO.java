/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.CrearCategoria;
import DTOSalida.CategoriaDTO;
import Excepcion.PersistenciaException;
import Excepciones.NegocioException;
import Interfaces.ICategoriaDAO;
import Mappers.CategoriaMapper;
import POJOs.Categoria;

/**
 *
 * @author SDavidLedesma
 */
public class CategoriaBO {

    private final ICategoriaDAO categoriaDAO;

    public CategoriaBO(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public CategoriaDTO registrarCategoria(CrearCategoria dto) throws NegocioException {
        try {
            Categoria categoria = CategoriaMapper.toEntity(dto);
            Categoria registrada = categoriaDAO.registrarCaregoria(categoria);
            return CategoriaMapper.toDTO(registrada);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar categoría", e);
        }

    }
}
