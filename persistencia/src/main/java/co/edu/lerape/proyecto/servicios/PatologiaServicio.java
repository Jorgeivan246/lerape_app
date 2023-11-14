package co.edu.lerape.proyecto.servicios;

import co.edu.lerape.proyecto.entidades.Patologia;

import java.util.List;

public interface PatologiaServicio {


    Patologia regirtrarPatologia(Patologia pa) throws Exception;

    Patologia actualizarPatologia(Patologia pa) throws Exception;

    void eliminarPatologia(String id) throws Exception;

    List<Patologia> listarPatologias();

    Patologia obtenerPatologia(String id) throws Exception;


}
