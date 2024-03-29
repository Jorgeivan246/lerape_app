package co.edu.lerape.proyecto.servicios;


import co.edu.lerape.proyecto.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;

    Usuario actualizarUsuario(Usuario u) throws Exception;

    Usuario login(String email, String password) throws Exception;

    void eliminarUsuario(String email) throws Exception;


    List<Usuario> listarUsuario();

    Usuario otenerUsuario(String email) throws Exception;

/**
    List<Receta> obtenerRecetasRecomendadas(String email) ;

 **/
}
