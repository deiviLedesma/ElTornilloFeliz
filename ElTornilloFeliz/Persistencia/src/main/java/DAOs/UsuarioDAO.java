/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IUsuarioDAO;
import POJOs.Usuario;
import Utilidades.Encriptador;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.conversions.Bson;

/**
 *
 * @author SDavidLedesma
 */
public class UsuarioDAO implements IUsuarioDAO {

    private MongoCollection<Usuario> coleccion;

    /**
     * constructor que inicializa la coleccion de usuarios desde la base de
     * datos
     *
     * @param database
     */
    public UsuarioDAO(MongoDatabase database) {
        this.coleccion = Conexion.getDatabase().getCollection("Usuario", Usuario.class);
    }

    /**
     * inserta un nuevo usuario
     *
     * @param usuario
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(usuario);
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("La insercion del usuario no fue reconocida por el servidor");
            }

            return usuario;
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al registrar el usuario", e);
        }
    }

    /**
     * busca un usuario por su nombre
     *
     * @param nombreUsuario
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Usuario buscarPorNombreUsuario(String nombreUsuario) throws PersistenciaException {
        try {
            //busca al usuario que coincida con el nombre
            Bson filtro = Filters.eq("nombreUsuario", nombreUsuario);
            //retorna al usuario que coincidio con el nombre
            return coleccion.find(filtro).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar usuario por nombre de usuario", e);
        }
    }

    /**
     * valida si las credenciales del usuario son correcectas
     *
     * @param nombreUsuario
     * @param contrasenia
     * @return
     * @throws PersistenciaException
     */
    @Override
    public boolean validarCredenciales(String nombreUsuario, String contrasenia) throws PersistenciaException {
        try {
            //buscar el usuario por su nombre
            Bson filtro = Filters.eq("nombreUsuario", nombreUsuario);
            Usuario usuario = coleccion.find(filtro).first();

            if (usuario == null) {
                return false;
            }
            //compara la contraseña ingresada con el hash guardado
            return Encriptador.verificarContrasenia(contrasenia, usuario.getContrasenia());
        } catch (Exception e) {
            throw new PersistenciaException("Error al validar las credenciales del usuario", e);
        }
    }

}
