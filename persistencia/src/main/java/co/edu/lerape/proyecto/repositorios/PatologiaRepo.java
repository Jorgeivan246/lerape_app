package co.edu.lerape.proyecto.repositorios;


import co.edu.lerape.proyecto.entidades.Patologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatologiaRepo extends JpaRepository<Patologia,String> {



}
